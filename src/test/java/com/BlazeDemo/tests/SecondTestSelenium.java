package com.BlazeDemo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SecondTestSelenium {

    private WebDriver driver;
    private WebDriverWait WebDriverWait;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        WebDriverWait = new WebDriverWait(driver,3);
    }

    @Test
    public void testHomePage() {
        driver.get("http://blazedemo.com");

        WebElement select1 = driver.findElement(By.cssSelector("[name=\"fromPort\"]"));
        Select selectWin1 = new Select(select1);
        selectWin1.selectByValue("Boston");

        WebElement select2 = driver.findElement(By.cssSelector("[name=\"toPort\"]"));
        Select selectWin2 = new Select(select2);
        selectWin2.selectByValue("Berlin");

//        driver.findElement(By.cssSelector("[value=\"Boston\"]")).click();
//        driver.findElement(By.cssSelector("[value=\"Berlin\"]")).click();

        driver.findElement(By.cssSelector("input")).click();

        WebElement header = driver.findElement(By.cssSelector("h3"));
        String headerStr = header.getText();
        Assert.assertTrue(header.isDisplayed());
        Assert.assertEquals("Flights from Boston to Berlin:", headerStr);

        WebElement flight = driver.findElement(By.xpath("/html/body//table[@class='table']//td[.='9696']"));
        String flightStr = flight.getText();
        WebElement airline = driver.findElement(By.xpath("/html/body//table[@class='table']//td[.='Aer Lingus']"));
        String airlineStr = airline.getText();
        WebElement price = driver.findElement(By.xpath("/html/body//table[@class='table']//td[.='$200.98']"));
        String priceStr = price.getText().substring(1);

        driver.findElement(By.cssSelector("tbody tr:nth-of-type(3) [type=\"submit\"]")).click();

        WebElement flightNumber = driver.findElement(By.xpath("/html//p[.='Flight Number: 9696']"));
        String flightString = flightNumber.getText().substring(15);
        WebElement airline2 = driver.findElement(By.xpath("/html//p[.='Airline: Aer Lingus']"));
        String airlineString = airline2.getText().substring(9);
        WebElement price2 = driver.findElement(By.xpath("/html//p[.='Price: 200.98']"));
        String priceString = price2.getText().substring(7);

        Assert.assertEquals(airlineStr,airlineString);
        Assert.assertEquals(flightStr,flightString);
        Assert.assertEquals(priceStr,priceString);

        WebElement taxes = driver.findElement(By.xpath("/html//p[.='Arbitrary Fees and Taxes: 514.76']"));
        String taxesStr = taxes.getText().substring(26);

        WebElement totalcost = driver.findElement(By.xpath("/html/body//em[.='715.74 ']"));
        String costStr = totalcost.getText().substring(0,6);

        float costInt = Float.parseFloat(costStr);
        float taxesInt = Float.parseFloat(taxesStr);
        float priceInt = Float.parseFloat(priceString);
        float a = Math.abs(taxesInt + priceInt);

        Assert.assertEquals(a,costInt);

        driver.findElement(By.cssSelector("#inputName")).sendKeys("Вася Петрович");

    }


    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


