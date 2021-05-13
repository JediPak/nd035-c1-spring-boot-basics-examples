package com.udacity.jwdnd.c1.review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginTest {

   @LocalServerPort
   private int port;

   private static WebDriver driver;
   private LoginPageObject loginPO;

   @BeforeAll
   public static void beforeAll(){
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
   }

   @AfterAll
   public static void afterAll(){
      driver.quit();
   }

   @BeforeEach
   public void beforeEach(){
      driver.get("http://localhost:"+port+"/login");
      loginPO = new LoginPageObject(driver);
   }

   @Test
   void testLoginFail() {
      String username = "username";
      String password = "password";
      loginPO.login(username, password);
      boolean loginFailed = loginPO.wrongLogin();
      assertEquals(true, loginFailed);

   }
}
