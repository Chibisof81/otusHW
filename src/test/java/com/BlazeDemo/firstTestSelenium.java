package com.BlazeDemo;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class firstTestSelenium {

    @Test
    public void Test() {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://blazedemo.com");
        WebElement FindFlights = driver.findElement(By.cssSelector("input"));
        FindFlights.click();
        driver.quit();
    }
}