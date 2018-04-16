package com.BlazeDemo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondTestSelenium {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @Test
    public void testHomePage() {
        driver.get("http://blazedemo.com");
        driver.findElement(By.cssSelector("[value=\"Boston\"]")).click();
        driver.findElement(By.cssSelector("[value=\"Berlin\"]")).click();
        driver.findElement(By.cssSelector("input")).click();
        WebElement header = driver.findElement(By.cssSelector("h3"));
        Assert.assertTrue(header.isDisplayed());
        Assert.assertEquals("Flights from Boston to Berlin:", header.getText());

        WebElement flight = driver.findElement(By.xpath("/html/body//table[@class='table']//td[.='9696']"));
        String flightStr = flight.getText();

        WebElement airline = driver.findElement(By.xpath("/html/body//table[@class='table']//td[.='Aer Lingus']"));
        String airlineStr = airline.getText();

        driver.findElement(By.cssSelector("tbody tr:nth-of-type(3) [type=\"submit\"]")).click();

        WebElement flightNumber = driver.findElement(By.xpath("/html//p[.='Flight Number: 9696']"));
        String flightString = flightNumber.getText().substring(15);


        WebElement airline2 = driver.findElement(By.xpath("/html//p[.='Airline: Aer Lingus']"));
        String airlineString = airline2.getText().substring(9);

        Assert.assertEquals(airlineStr,airlineString);
        Assert.assertEquals(flightStr,flightString);
    }


    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


