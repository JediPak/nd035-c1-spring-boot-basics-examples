package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/animal");

        WebElement inputAnimal = driver.findElement(By.id("animalText"));
        WebElement inputAdj = driver.findElement(By.id("adjective"));
        WebElement button = driver.findElement(By.xpath("/html/body/form/input[3]"));
        ///html/body/form/input[3]


        /*for(int i = 0; i < 4; ++i){
            inputAnimal.sendKeys("cat"+i);
            inputAdj.sendKeys("pink"+i);
            button.click();

        }*/
        inputAnimal.sendKeys("cat 1");
        inputAdj.sendKeys("pink 1");
        driver.findElement(By.xpath("/html/body/form/input[3]")).click();
        //Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/form/input[3]")).click();
        //Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/form/input[3]")).click();
        //Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/form/input[3]")).click();
        //Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/form/input[3]")).click();
        //Thread.sleep(2000);

        String str = driver.findElement(By.tagName("h1")).getText();
        System.out.println("Captured String: "+str);

        Thread.sleep(5000);
        driver.quit();

    }
}
