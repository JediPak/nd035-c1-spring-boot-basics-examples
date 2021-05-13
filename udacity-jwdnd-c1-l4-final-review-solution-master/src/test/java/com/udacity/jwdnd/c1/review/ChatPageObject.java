package com.udacity.jwdnd.c1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ChatPageObject {

   @FindBy(id = "messageText")
   private WebElement messageTextField;

   @FindBy(id = "messageType")
   private WebElement messageTypeField;

   @FindBy(id = "result-message")
   private List <WebElement> texts;

   public ChatPageObject(WebDriver d){
      PageFactory.initElements(d, this);
   }

   private void selectMessageType(String messageType){
      Select statusDropdown=new Select(messageTypeField);
      statusDropdown.selectByVisibleText(messageType);
   }

   public void submitMessage(String message, String messageType){
      messageTextField.sendKeys(message);
      selectMessageType(messageType);
      messageTypeField.submit();
   }

   public List<String> getText(){
      List<String> textsToString = new ArrayList <>();
      for(WebElement we: texts)
         textsToString.add(we.getText());
      return textsToString;
   }



}
