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
public class ErrorLastResponseDTO   {
  
  private @Valid String msg;
  private @Valid Date created;

  /**
   * Сообщение последней ошибки
   **/
  public ErrorLastResponseDTO msg(String msg) {
    this.msg = msg;
    return this;
  }

  

  
  @ApiModelProperty(required = true, value = "Сообщение последней ошибки")
  @JsonProperty("msg")
  @NotNull
  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }/**
   * Когда ошибка произошла
   **/
  public ErrorLastResponseDTO created(Date created) {
    this.created = created;
    return this;
  }

  

  
  @ApiModelProperty(required = true, value = "Когда ошибка произошла")
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
    ErrorLastResponseDTO errorLastResponse = (ErrorLastResponseDTO) o;
    return Objects.equals(this.msg, errorLastResponse.msg) &&
        Objects.equals(this.created, errorLastResponse.created);
  }

  @Override
  public int hashCode() {
    return Objects.hash(msg, created);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorLastResponseDTO {\n");
    
    sb.append("    msg: ").append(toIndentedString(msg)).append("\n");
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

