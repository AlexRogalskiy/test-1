package com.mesh.test.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.validation.constraints.*;
import javax.validation.Valid;

import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2020-08-23T14:13:29.776513300+03:00[Europe/Moscow]")
public class ProfileDTO   {
  
  private @Valid Integer id;
  private @Valid String name;
  private @Valid String email;
  private @Valid Integer age;
  private @Valid Date created;

  /**
   * Id профиля
   **/
  public ProfileDTO id(Integer id) {
    this.id = id;
    return this;
  }

  

  
  @ApiModelProperty(required = true, value = "Id профиля")
  @JsonProperty("id")
  @NotNull
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }/**
   * Имя человека
   **/
  public ProfileDTO name(String name) {
    this.name = name;
    return this;
  }

  

  
  @ApiModelProperty(required = true, value = "Имя человека")
  @JsonProperty("name")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }/**
   * Почта
   **/
  public ProfileDTO email(String email) {
    this.email = email;
    return this;
  }

  

  
  @ApiModelProperty(required = true, value = "Почта")
  @JsonProperty("email")
  @NotNull
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }/**
   * Возраст
   **/
  public ProfileDTO age(Integer age) {
    this.age = age;
    return this;
  }

  

  
  @ApiModelProperty(required = true, value = "Возраст")
  @JsonProperty("age")
  @NotNull
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }/**
   * Дата создания профиля
   **/
  public ProfileDTO created(Date created) {
    this.created = created;
    return this;
  }

  

  
  @ApiModelProperty(required = true, value = "Дата создания профиля")
  @JsonProperty("created")
  @NotNull
  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProfileDTO profile = (ProfileDTO) o;
    return Objects.equals(this.id, profile.id) &&
        Objects.equals(this.name, profile.name) &&
        Objects.equals(this.email, profile.email) &&
        Objects.equals(this.age, profile.age) &&
        Objects.equals(this.created, profile.created);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, age, created);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProfileDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

