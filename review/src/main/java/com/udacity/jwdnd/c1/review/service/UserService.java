package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.Mapper.UserMapper;
import com.udacity.jwdnd.c1.review.model.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {

   private HashService hashService;
   private UserMapper userMapper;

   public UserService(HashService hashService, UserMapper userMapper) {
      this.hashService = hashService;
      this.userMapper = userMapper;
   }

   public boolean isUsernameAvailable(String username){
      return (userMapper.getUser(username) != null);
   }

   public Integer createUser(User user){
      SecureRandom random = new SecureRandom();
      byte[] salt = new byte[16];
      random.nextBytes(salt); //fills salt with random bytes
      String encodedSalt = Base64.getEncoder().encodeToString(salt);
      String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
      user.setSalt(encodedSalt);
      user.setPassword(hashedPassword);
      return userMapper.createUser(user);
   }

   public User getUser(String username){
      return userMapper.getUser(username);
   }

}
