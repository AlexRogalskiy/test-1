# test
Тестовое задание для Meshgroup

Запуск:
  1. В IDEA создать конфигурацию запуска Tomcat, добавить артефакт test:war exploded в Deployment, а во вкладку Before Launch добавить только Run Maven Goal: clean install.
  2. По пути test\target\ лежит полностью рабочий артефакт test-0.0.1-SNAPSHOT.war. Можно закинуть его на томкат в папку webapps.

Краткое описание:
  Проект на Spring Boot.
  
  В test\src\main\resources\openapi лежит api.yaml, в котором, с помощью программы Stoplight Studio я описал 
  необходимые REST пути и сущности. Для генерации REST API использую openapi-generator, который собирает необходимые java интерфейсы c jax-rs аннотациями из 
  вышеупомянутого файла api.yaml при сборке Maven'ом. Остается только прописать имплементацию (com.mesh.test.webapi.resourse.*), вспомогательные классы для имплементации 
  (com.mesh.test.webapi.exception.* - удобное раширение REST исключений
  и com.mesh.test.webapi.provider.* - кастомные провайдеры для правильного отображения текста искючений в сущности {"msg": "Сообщение"} )
  и логику (работа с бд - com.mesh.test.repository.*, сервисы настоящего времени и сохранения последнего сообщения об ошибке - com.mesh.test.service.*), 
  а также создать сервлет для перенаправления http запросов (сom.mesh.test.webapi.WebCofig).
  
  Для доступа к базе данных на Postgres использую Spring Data.
  
