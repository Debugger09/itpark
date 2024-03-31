package com.sprinpay.itpark.services.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {

   @NotBlank(message = "Nom champ requis")
   private String userName;
   @NotBlank(message = "Mot de passe champ requis")
   private String password;

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
}
