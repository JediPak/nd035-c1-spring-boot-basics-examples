package com.udacity.jwdnd.c1.review.controller;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.Message;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.udacity.jwdnd.c1.review.service.MessageService;



@Controller
@RequestMapping("/chat")
public class ChatController {
   private MessageService messageService;

   public ChatController(MessageService messageService) {
      this.messageService = messageService;
   }

   @GetMapping()
   public String getChat(
           @ModelAttribute("chatMessage") Message chatMessage,
           @ModelAttribute("chatForm") ChatForm chatForm,
           Model model){
      model.addAttribute("messages", messageService.getMessages());
      return "chat";
   }

   @PostMapping()
   public String postChat(
           @ModelAttribute("chatMessage") Message chatMessage,
           @ModelAttribute("chatForm") ChatForm chatForm,
           Authentication authentication,
           Model model){
      messageService.addMessage(chatMessage, chatForm);
      model.addAttribute("messages", messageService.getMessage(authentication.getName()));
      //chatMessage.setMessage("");
      //chatMessage.setUsername("");
      return "chat";
   }
}
