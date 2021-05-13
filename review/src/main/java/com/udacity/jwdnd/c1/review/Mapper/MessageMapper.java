package com.udacity.jwdnd.c1.review.Mapper;

import com.udacity.jwdnd.c1.review.model.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageMapper {

   @Select("SELECT * FROM Message WHERE username = #{username}")
   List<Message> getMessage_usern(String username);

   @Select("SELECT * FROM Message")
   List <Message> getMessages();

   @Insert("INSERT INTO Message (username, message)" +
           "VALUES (#{username}, #{message})")
   @Options(keyProperty = "messageid", useGeneratedKeys = true)
   Integer createMessage(Message message);

   @Delete("DELETE FROM Message WHERE messageid = #{messageid}")
   void deleteMessage(Integer messageid);
}
