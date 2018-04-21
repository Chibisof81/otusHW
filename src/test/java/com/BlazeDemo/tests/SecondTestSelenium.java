package com.BlazeDemo.tests;

import com.BlazeDemo.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTestSelenium extends AbstractTest {


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

        WebElement inputName = driver.findElement(By.id("inputName"));
        WebElement address =driver.findElement(By.id("address"));
        WebElement city = driver.findElement(By.id("city"));
        WebElement state = driver.findElement(By.id("state"));
        WebElement zipCode =  driver.findElement(By.id("zipCode"));
        WebElement select3 = driver.findElement(By.id("cardType"));
        Select selectWin3 = new Select(select3);
        WebElement cardNumber = driver.findElement(By.id("creditCardNumber"));
        WebElement creditCardMonth = driver.findElement(By.id("creditCardMonth"));
        creditCardMonth.clear();
        WebElement creditCardYear = driver.findElement(By.id("creditCardYear"));
        creditCardYear.clear();
        WebElement cardHolder = driver.findElement(By.id("nameOnCard"));

        inputName.sendKeys("Вася Петрович");
        address.sendKeys("улица, дом, квартира");
        city.sendKeys("Moscow");
        state.sendKeys("Idaho");
        zipCode.sendKeys("123456");
        selectWin3.selectByValue("dinersclub");
        cardNumber.sendKeys("987654321");
        creditCardMonth.sendKeys("8");
        creditCardYear.sendKeys("2018");
        cardHolder.sendKeys("Vasia Petrovich");


        driver.findElement(By.id("rememberMe")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        String confirmation  = driver.getCurrentUrl();

        Assert.assertEquals(confirmation,"http://blazedemo.com/confirmation.php");

    }


}


