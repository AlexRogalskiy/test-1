package com.mesh.test.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import javax.validation.Valid;

import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2020-08-26T21:20:49.755125300+03:00[Europe/Moscow]")
public class ProfilesSetRequestDTO   {
  
  private @Valid String name;
  private @Valid String email;
  private @Valid Integer age;

  /**
   * Имя
   **/
  public ProfilesSetRequestDTO name(String name) {
    this.name = name;
    return this;
  }

  

  
  @ApiModelProperty(required = true, value = "Имя")
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
  public ProfilesSetRequestDTO email(String email) {
    this.email = email;
    return this;
  }

  

  
  @ApiModelProperty(required = true, value = "Почта")
  @JsonProperty("email")
  @NotNull
 @Pattern(regexp="^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }/**
   * Возраст
   * minimum: 0
   **/
  public ProfilesSetRequestDTO age(Integer age) {
    this.age = age;
    return this;
  }

  

  
  @ApiModelProperty(required = true, value = "Возраст")
  @JsonProperty("age")
  @NotNull
 @Min(0)  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProfilesSetRequestDTO profilesSetRequest = (ProfilesSetRequestDTO) o;
    return Objects.equals(this.name, profilesSetRequest.name) &&
        Objects.equals(this.email, profilesSetRequest.email) &&
        Objects.equals(this.age, profilesSetRequest.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, age);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProfilesSetRequestDTO {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
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

