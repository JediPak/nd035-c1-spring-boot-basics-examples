package com.udacity.jwdnd.c1.review.model;

import java.util.Objects;

public class Message {
   private Integer messageid;
   private String username;
   private String message;

   public Message(Integer messageid, String username, String message) {
      this.messageid = messageid;
      this.username = username;
      this.message = message;
   }
   /*public Message(String username, String message) {
      this.username = username;
      this.message = message;
   }*/

   public Integer getMessageid() {
      return messageid;
   }

   public void setMessageid(Integer messageid) {
      this.messageid = messageid;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Message)) return false;
      Message that = (Message) o;
      return Objects.equals(messageid, that.messageid) && Objects.equals(username, that.username) && Objects.equals(message, that.message);
   }

   @Override
   public int hashCode() {
      return Objects.hash(messageid, username, message);
   }
}
