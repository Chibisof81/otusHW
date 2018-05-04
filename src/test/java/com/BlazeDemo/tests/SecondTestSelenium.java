package com.BlazeDemo.tests;

import com.BlazeDemo.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import static domain.UserData.*;

public class SecondTestSelenium extends AbstractTest {

    private String from = "Boston";
    private String to = "Berlin";

    @Test
    public void testHomePage() {
        driver.get("http://blazedemo.com");


        new Select(driver.findElement(By.cssSelector("[name=\"fromPort\"]"))).selectByValue(from);
        new Select(driver.findElement(By.cssSelector("[name=\"toPort\"]"))).selectByValue(to);

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

        Assert.assertEquals(airlineStr, airlineString);
        Assert.assertEquals(flightStr, flightString);
        Assert.assertEquals(priceStr, priceString);

        WebElement taxes = driver.findElement(By.xpath("/html//p[.='Arbitrary Fees and Taxes: 514.76']"));
        String taxesStr = taxes.getText().substring(26);

        WebElement totalcost = driver.findElement(By.xpath("/html/body//em[.='715.74 ']"));
        String costStr = totalcost.getText().substring(0, 6);

        float costInt = Float.parseFloat(costStr);
        float taxesInt = Float.parseFloat(taxesStr);
        float priceInt = Float.parseFloat(priceString);
        float a = Math.abs(taxesInt + priceInt);

        Assert.assertEquals(a, costInt);

        driver.findElement(By.id("inputName")).sendKeys(USER_1.getInputName());
        driver.findElement(By.id("address")).sendKeys(USER_1.getAddress());
        driver.findElement(By.id("city")).sendKeys(USER_1.getCity());
        driver.findElement(By.id("state")).sendKeys(USER_1.getState());
        driver.findElement(By.id("zipCode")).sendKeys(USER_1.getZipCode());
        new Select(driver.findElement(By.id("cardType"))).selectByValue(USER_1.getCardType());
        driver.findElement(By.id("creditCardNumber")).sendKeys(USER_1.getCardNumber());
        WebElement creditCardMonth = driver.findElement(By.id("creditCardMonth"));
        creditCardMonth.clear();
        creditCardMonth.sendKeys(USER_1.getCardMonth());
        WebElement creditCardYear = driver.findElement(By.id("creditCardYear"));
        creditCardYear.clear();
        creditCardYear.sendKeys(USER_1.getCardYear());
        driver.findElement(By.id("nameOnCard")).sendKeys(USER_1.getCardHolder());

        driver.findElement(By.id("rememberMe")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        String confirmation = driver.getCurrentUrl();

        Assert.assertEquals(confirmation, "http://blazedemo.com/confirmation.php");
    }
}