package com.udacity.jwdnd.c1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

   @FindBy(id = "inputUsername")
   private WebElement usernameField;

   @FindBy(id = "inputPassword")
   private WebElement passwordField;

   @FindBy(id = "submit-button")
   private WebElement submit;

   @FindBy(id = "signup-link")
   private WebElement signUp;

   @FindBy(id = "error-msg")
   private WebElement loginFailedmsg;

   @FindBy(className = "display-5")
   private WebElement title;

   public LoginPageObject(WebDriver d){
      PageFactory.initElements(d, this);
   }

   public void login(String username, String password){
      usernameField.sendKeys(username);
      passwordField.sendKeys(password);
      submit.click();
   }

   public void signup(){
      signUp.click();
   }

   public boolean wrongLogin(){
      return loginFailedmsg.isDisplayed();
   }

   public boolean atLoginPage(){
      return title.getText().equals("Login");
   }

}
