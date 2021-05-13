package com.udacity.jwdnd.c1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPageObject {

   @FindBy(id = "inputFirstName")
   private WebElement firstNameField;

   @FindBy(id = "inputLastName")
   private WebElement lastNameField;

   @FindBy(id = "inputUsername")
   private WebElement usernameField;

   @FindBy(id = "inputPassword")
   private WebElement passwordField;

   @FindBy(id = "submit-button")
   private WebElement submit;

   @FindBy(id = "success-msg")
   private WebElement signUpSuccess;

   //shows up only after signUpSuccess.Display is true
   @FindBy(id = "login-link")
   private WebElement loginLink;

   @FindBy(id = "error-msg")
   private WebElement signUpFailed;

   @FindBy(className = "display-5")
   private WebElement title;

   public SignupPageObject(WebDriver d){
      PageFactory.initElements(d, this);
   }

   public void signup(String firstname, String lastname,
                      String username, String password){
      firstNameField.sendKeys(firstname);
      lastNameField.sendKeys(lastname);
      usernameField.sendKeys(username);
      passwordField.sendKeys(password);
      submit.click();
   }

   public void backToLoginAfterSignupSuccess(){
      if (signUpSuccess.isDisplayed()){
         loginLink.submit();
      }
   }

   public void backToLogin(){
      loginLink.submit();
   }

   public boolean SigningupFailed(){
      return signUpFailed.isDisplayed();
   }

   public boolean signingupSuccess(){
      return signUpSuccess.isDisplayed();
   }

   public boolean atSignupPage(){
      return title.getText().equals("Sign Up");
   }
}
