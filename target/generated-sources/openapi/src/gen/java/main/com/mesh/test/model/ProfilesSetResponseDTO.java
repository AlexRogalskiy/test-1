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



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2020-08-23T14:13:29.776513300+03:00[Europe/Moscow]")
public class ProfilesSetResponseDTO   {
  
  private @Valid Integer idUser;

  /**
   * Id Пользователя
   **/
  public ProfilesSetResponseDTO idUser(Integer idUser) {
    this.idUser = idUser;
    return this;
  }

  

  
  @ApiModelProperty(required = true, value = "Id Пользователя")
  @JsonProperty("idUser")
  @NotNull
  public Integer getIdUser() {
    return idUser;
  }

  public void setIdUser(Integer idUser) {
    this.idUser = idUser;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProfilesSetResponseDTO profilesSetResponse = (ProfilesSetResponseDTO) o;
    return Objects.equals(this.idUser, profilesSetResponse.idUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idUser);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProfilesSetResponseDTO {\n");
    
    sb.append("    idUser: ").append(toIndentedString(idUser)).append("\n");
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

