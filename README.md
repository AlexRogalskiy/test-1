
# Тестовое задание

 ## Основной стек проекта
- Java 11
- Spring Boot, Security, OAuth, Data
- БД PostgreSQL
- OpenAPI Generator
- Maven

## Запуск проекта

Запустить проект можно двумя способами:
1. Запустить артефакт:

	По пути `target\test-0.0.1-SNAPSHOT.war` лежит рабочий артефакт приложения. Необходимо закинуть его в папку `\webapps` на **Tomcat** и запусить сам **Tomcat**. Приложение готово к использованию.

2.  Запусить приложение из **IDEA**: 
 
	Создать конфигурацию запуска **Tomcat Server**,  во вкладке *Server* в окно *Before Launch* добавить конфигурацию **Run Maven Goal** со следующей командой:
	```maven
	clean install
	```
	> Кроме **Run Maven Goal** в окне *Before Launch* больше ничего быть не должно

	И во вкладке *Deployment* добавить артефакт **test:war exploded**.
	> **Совет:** Не забудьте заменить *Application context* с **/test_war_exploded** на **/test**, иначе сервер будет работать по первому пути 

## Получение токена

В проекте используется протокол *OAuth2*, что подразумевает, что с каждым запросом (кроме `/api/exit` и `/api/sign`) на сервер должен передаваться *токен*, иначе сервер будет возвращать ошибку *401 Unauthorized*.

 Токен выдается *пользователю* c **логином** и **паролем**. 
 
### Регистрация пользователя

Все пользователи хранятся в БД, поэтому, при первом запуске, нам необходимо зарегестрировать пользователя (либо несколько пользователей):

>**Внимание!** Все пользователи и профили хранятся в БД, и,  чтобы при каждом запуске не пересоздавать пользователей, **после первого запуска приложения** необходимо закоментировать следующую строку в файле `src\resources\application.properties`:
>```bash
>spring.jpa.hibernate.ddl-auto=create
>```
>Чтобы *Hibernate* не пересоздавал и не очищал все таблицы при перезапуске приложения

**Создание *пользователя*** осуществляется через следующий запрос:
```bash
curl --request POST \
  --url http://localhost:8010/test/api/sign \
  --header 'content-type: application/json' \
  --data '{
	"username": <новый логин>,
	"password": <ваш пароль>
}'
```
> Вы можете создавать пользователей с любыми логинами и паролями: логин и пароль потребуются для получения *токена*

>**Важно!** Все запросы в данной инструкции будут показаны в виде ***cURL***. Запросами подразумевается, что проект запущен на сервере на локальной машине на порте `8010` cо значением *Application Context* `/test`.

>Также стоит отметить, что *в данной инструкции* будут показаны только жизненно **необходимые для корректной работы** запросы. Если вы хотите ознакомиться с ***полной *REST* документацией проекта***, вам достаточно открыть файл `src\resources\openapi\api.yaml` в каком-нибудь *swagger редакторе*, например в [этом](https://editor.swagger.io/).

### Получение токена

После успешной регистрации, **получение *токена*   пользователем** осуществляется следующим запросом:
```bash
curl --request POST \
  --url http://client:secret@localhost:8010/test/oauth/token \
  --header 'content-type: application/x-www-form-urlencoded' \
  --data grant_type=password \
  --data username=<логин пользователя> \
  --data password=<пароль пользователя>
```
При успешном выполнении запроса вернется следующий *Response*:
```json
{
  "access_token": "<токен для доступа сервисам>",
  "token_type": "bearer",
  "refresh_token": "<токен для обновления токена доступа>",
  "expires_in": 43199,
  "scope": "read write",
  "jti": "b1ff5964-2e11-40..."
}
```
Теперь можно пользоваться сервисом. К каждому запросу, требующиму авторизации, необходимо добавить следующий **Header**:

```bash
Authorization: Bearer <токен для доступа к сервисам>
```

### Обновление токена

>**Внимание!** *Токены для доступа к сервисам* имеют время жизни, после окончания которого они становятся невалидными. В данном проекте это 12 часов, которых вполне должно хватить на проверку проекта. В любой момент можно  запросить новый *токен доступа*, но, есть ещё возможность обновить *токен доступа* с помощью ***токена для обновления токена доступа*** или просто -- ***refresh токена***.

**Получение нового *токена доступа* через *refresh токен*** осуществляется следующим запросом:
```bash
curl --request POST \
  --url http://client:secret@localhost:8010/test/oauth/token \
  --header 'content-type: application/x-www-form-urlencoded' \
  --data grant_type=refresh_token \
  --data refresh_token=<токен для обновления токена доступа>
```
Данный запрос возвращает точно такой же *Response*, что и предыдущий запрос.

### Пример запроса с токеном
Пример запроса для получения *списка профилей*:
```bash
curl --request GET \
  --url http://localhost:8010/test/api/profiles \
  --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiYXBpIl0sInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTU5ODIyNDYyNSwiYXV0aG9yaXRpZXMiOlsiQURNSU4iXSwianRpIjoiYjFmZjU5NjQtMmUxMS00MDBhLWE1MjYtYjJjOGY0OGJjZTE2IiwiY2xpZW50X2lkIjoiY2xpZW50In0.2PAauX-if2rz9OQvGgC6QCYTzRlk0xu0f_CYtH22CF4'
```
