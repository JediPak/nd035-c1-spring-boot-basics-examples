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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {
	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private static LoginPageObject loginPO;
	private static SignupPageObject signupPO;
	private static ChatPageObject chatPO;

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
		System.out.println("port: ["+port+"]");
		driver.get("http://localhost:" + port.toString() + "/login");

	}

	@Test
	void testLoginSuccessfully() throws InterruptedException {
		String firstname = "firstname";
		String lastname = "lastname";
		String username = "username";
		String password = "password";
		loginPO = new LoginPageObject(driver);
		boolean atLoginPage = loginPO.atLoginPage();
		assertEquals(true, atLoginPage);

		loginPO.signup();
		signupPO = new SignupPageObject(driver);
		boolean atSignupPage = signupPO.atSignupPage();
		assertEquals(true, atSignupPage);

		signupPO.signup(firstname, lastname, username, password);

		//driver.get("http://localhost:" + port.toString() + "/login");
		signupPO.backToLoginAfterSignupSuccess();


		loginPO.login(username, password);

		String message = "Hello";
		String messageType1 = "Say";
		chatPO = new ChatPageObject(driver);
		chatPO.submitMessage(message, messageType1);
		Thread.sleep(3000);
		List <String> result = chatPO.getText();
		System.out.println("result:" + result);
		assertEquals("Hello", result.get(0));

	}

}
