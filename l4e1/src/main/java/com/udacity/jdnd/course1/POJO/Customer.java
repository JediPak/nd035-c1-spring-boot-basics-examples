package com.udacity.jdnd.course1.POJO;

import java.util.Objects;

public class Customer {
   private int id;
   private String username;
   private String password;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Customer)) return false;
      Customer customer = (Customer) o;
      return id == customer.id && username.equals(customer.username) && password.equals(customer.password);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, username, password);
   }
}
