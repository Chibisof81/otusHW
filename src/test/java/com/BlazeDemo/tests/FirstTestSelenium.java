package com.BlazeDemo.tests;

import com.BlazeDemo.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class FirstTestSelenium extends AbstractTest {

    @Test
    public void test() {
        driver.get("http://blazedemo.com");
        WebElement FindFlights = driver.findElement(By.cssSelector("input"));
        FindFlights.click();
        WebElement VirginAmerica = driver.findElement(By.cssSelector("tbody tr:nth-of-type(1) td:nth-child(4)"));
        assertTrue(VirginAmerica.isDisplayed());
        String page = driver.getCurrentUrl();
        assertEquals(page, "http://blazedemo.com/reserve.php");
    }

}