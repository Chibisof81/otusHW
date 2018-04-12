package com.BlazeDemo.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;


public class FirstTestSelenium {

    WebDriver driver;

    @BeforeMethod
    public void before() {
        setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void Test() {

        driver.get("http://blazedemo.com");
        WebElement FindFlights = driver.findElement(By.cssSelector("input"));
        FindFlights.click();
        WebElement VirginAmerica = driver.findElement(By.cssSelector("tbody tr:nth-of-type(1) td:nth-child(4)"));
        assertTrue(VirginAmerica.isDisplayed());
        assertEquals("ok", "http://blazedemo.com/reserve.php", "http://blazedemo.com/reserve.php");
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }

}