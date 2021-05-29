package com.udacity.jdnd.course1.POJO;

import java.util.Objects;

public class Order {
   private int id;
   private int customer_id;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getCustomer_id() {
      return customer_id;
   }

   public void setCustomer_id(int customer_id) {
      this.customer_id = customer_id;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Order)) return false;
      Order order = (Order) o;
      return id == order.id && customer_id == order.customer_id;
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, customer_id);
   }
}
