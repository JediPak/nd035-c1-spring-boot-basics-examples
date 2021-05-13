package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.Mapper.MessageMapper;
import com.udacity.jwdnd.c1.review.model.Message;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

   private MessageMapper messageMapper;

   public void setMessages(Message message) {
      messageMapper.createMessage(message);
   }
   public List<Message> getMessage(String username) {
      return messageMapper.getMessage_usern(username);
   }

   public List<Message> getMessages() {
      return messageMapper.getMessages();
   }

   public void addMessage(Message message, ChatForm chatForm){
      if(chatForm.getChatForm().equals("shout")){
         message.setMessage(message.getMessage().toUpperCase());
      }
      else if(chatForm.getChatForm().equals("whisper")) {
         message.setMessage(message.getMessage().toLowerCase());
      }
   }
}
