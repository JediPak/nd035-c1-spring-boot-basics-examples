package com.udacity.jdnd.course1.POJO;

import java.util.Objects;

public class TacoOrder {
   private Integer order_id;
   private String taco_name;
   private float taco_price;
   private int count;


   public Integer getOrder_id() {
      return order_id;
   }

   public void setOrder_id(Integer order_id) {
      this.order_id = order_id;
   }

   public String getTaco_name() {
      return taco_name;
   }

   public void setTaco_name(String taco_name) {
      this.taco_name = taco_name;
   }

   public float getTaco_price() {
      return taco_price;
   }

   public void setTaco_price(float taco_price) {
      this.taco_price = taco_price;
   }

   public int getCount() {
      return count;
   }

   public void setCount(int count) {
      this.count = count;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof TacoOrder)) return false;
      TacoOrder tacoOrder = (TacoOrder) o;
      return Float.compare(tacoOrder.taco_price, taco_price) == 0 && count == tacoOrder.count && order_id.equals(tacoOrder.order_id) && taco_name.equals(tacoOrder.taco_name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(order_id, taco_name, taco_price, count);
   }
}
