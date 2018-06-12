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
        AbstractTest.getInstance().get("http://blazedemo.com");
        WebElement FindFlights = AbstractTest.getInstance().findElement(By.cssSelector("input"));
        FindFlights.click();
        WebElement VirginAmerica = AbstractTest.getInstance().findElement(By.cssSelector("tbody tr:nth-of-type(1) td:nth-child(4)"));
        assertTrue(VirginAmerica.isDisplayed());
        String page = AbstractTest.getInstance().getCurrentUrl();
        assertEquals(page, "http://blazedemo.com/reserve.php");
    }

}