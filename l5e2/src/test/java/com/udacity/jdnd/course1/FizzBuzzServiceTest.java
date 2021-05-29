package com.udacity.jdnd.course1;

import com.udacity.jdnd.course1.service.FizzBuzzService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FizzBuzzServiceTest {

	static FizzBuzzService fbs;

	@BeforeAll
	static void initService(){
		fbs = new FizzBuzzService();
	}
	@Test
	void testBuzzFizz(){
		//Buzz
		assertEquals(10, fbs.buzzFizz("Buzz", 2));

		//Fizz
		assertEquals(33, fbs.buzzFizz("Fizz", 11));

		//FizzBuzz
		assertEquals(60, fbs.buzzFizz("FizzBuzz", 4));

		//else
		assertEquals(-100, fbs.buzzFizz("-100", -100));

		assertThrows(IllegalArgumentException.class, () -> fbs.buzzFizz("-1", 1));

		assertThrows(IllegalArgumentException.class, () -> fbs.buzzFizz("tacocat", 1));

	}

	@Test
	void testFizzBuzz(){

		// check non-divisible numbers return themselves
		assertEquals("1", fbs.fizzBuzz(1));
		assertEquals("47", fbs.fizzBuzz(47));
		assertEquals("121", fbs.fizzBuzz(121));

		// check numbers divisible by 3
		assertEquals("Fizz", fbs.fizzBuzz(3));
		assertEquals("Fizz", fbs.fizzBuzz(333));

		//check numbers divisible by 5
		assertEquals("Buzz", fbs.fizzBuzz(5));
		assertEquals("Buzz", fbs.fizzBuzz(85));

		//check numbers divisible by 3 and 5
		assertEquals("FizzBuzz", fbs.fizzBuzz(15));
		assertEquals("FizzBuzz", fbs.fizzBuzz(75));

		//check invalid inputs
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(0));
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(-1));
	}
}
