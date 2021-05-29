package com.udacity.jdnd.course1.data;

import org.apache.ibatis.annotations.*;

@Mapper
public interface DeliveryMapper {

   @Select("SELECT * FROM Delivery WHERE id = #{id}")
   public Delivery findDelivery(Integer id);

   @Insert("INSERT INTO Delivery (orderId, time) +" +
           "VALUES(#{orderId}, #{time})")
   @Options(useGeneratedKeys = true, keyProperty = "id")
   public Integer createDelivery(Delivery delivery);

   @Delete("DELETE FROM Delivery WHERE id = #{id}")
   public void deleteDelivery(Integer id);
	

}
