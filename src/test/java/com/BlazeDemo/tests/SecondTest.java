package com.BlazeDemo.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondTest {

    @BeforeTest
    public void Before(String[] args) {
        WebDriver driver = new ChromeDriver();


    @Test

        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));

    }


}
