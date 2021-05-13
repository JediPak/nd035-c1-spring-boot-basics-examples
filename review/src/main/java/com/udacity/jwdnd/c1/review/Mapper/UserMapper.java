package com.udacity.jwdnd.c1.review.Mapper;

import com.udacity.jwdnd.c1.review.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

   @Select("SELECT * FROM User WHERE username = #{username}")
   User getUser(String username);

   @Insert("INSERT INTO User (username, salt, password, firstname, lastname)" +
           "VALUES (#{username}, #{salt}, #{password}, #{firstname}, #{lastname})")
   @Options(keyProperty = "userid", useGeneratedKeys = true)
   Integer createUser(User user);

   @Delete("DELETE FROM User WHERE userid = #{userid}")
   void deleteUser(Integer userid);

}
