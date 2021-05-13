package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.Message;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageListService {

   private List<Message> messages;

   public List <Message> getMessages() {
      return messages;
   }

   public void setMessages(List <Message> messages) {
      this.messages = messages;
   }

   public void addMessage(Message message, ChatForm chatForm){
      if(chatForm.getChatForm().equals("shout")){
         message.setMessage(message.getMessage().toUpperCase());
      }
      else if(chatForm.getChatForm().equals("whisper")) {
         message.setMessage(message.getMessage().toLowerCase());
      }
      messages.add(message);
   }

   @PostConstruct
   public void postContruct(){
      this.messages = new ArrayList <>();
   }
}
