package com.BlazeDemo;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;


public class firstTestSelenium {

    @Test
    public void Test() {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://blazedemo.com");
        WebElement FindFlights = driver.findElement(By.cssSelector("input"));
        FindFlights.click();
        WebElement VirginAmerica = driver.findElement(By.cssSelector("tbody tr:nth-of-type(1) td:nth-child(4)"));
        assertTrue(VirginAmerica.isDisplayed());
        assertEquals("ok", "http://blazedemo.com/reserve.php", "http://blazedemo.com/reserve.php");
        driver.quit();
    }
}