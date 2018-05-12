package com.BlazeDemo.tests;

import com.BlazeDemo.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.PurchasePage;
import page.ReservePage;

import static domain.UserData.USER_1;

public class SecondTestSelenium extends AbstractTest {

    //public static HomePage homePage;

    @Test
    public void testHomePage() {
        driver.get("http://blazedemo.com");

        HomePage hp = new HomePage(driver);

        HomePage.select_list1(USER_1.getFrom());
        HomePage.select_list2(USER_1.getTo());
        HomePage.buttonClick();

        // new Select(HomePage.from).selectByValue(USER_1.getFrom());
        //new Select(HomePage.to).selectByValue(USER_1.getTo());
        //driver.findElement(By.cssSelector("input")).click();

        ReservePage rp = new ReservePage(driver);

        String headerStr = ReservePage.Header();
        String airline = ReservePage.Airline();
        String flightNum = ReservePage.Flight();
        String price = ReservePage.Price();

        Assert.assertEquals("Flights from Boston to Berlin:", headerStr);
        ReservePage.ButtonRes();

        //WebElement header = driver.findElement(By.cssSelector("h3"));
        //String headerStr = header.getText();
        //Assert.assertTrue(header.isDisplayed());
        //Assert.assertEquals("Flights from Boston to Berlin:", headerStr);

        //WebElement flight = driver.findElement(By.xpath("/html/body//table[@class='table']//td[.='9696']"));
        //String flightStr = flight.getText();
        //WebElement airline = driver.findElement(By.xpath("/html/body//table[@class='table']//td[.='Aer Lingus']"));
        //String airlineStr = airline.getText();
        //WebElement price = driver.findElement(By.xpath("/html/body//table[@class='table']//td[.='$200.98']"));
        //String priceStr = price.getText().substring(1);

        //driver.findElement(By.xpath("/html/body//table[@class='table']/tbody/tr[3]/td[1]/input[@value='Choose This Flight']")).click();

        PurchasePage pp = new PurchasePage(driver);

//        WebElement flightNumber = driver.findElement(By.xpath("/html//p[.='Flight Number: 9696']"));
//        String flightString = flightNumber.getText().substring(15);
//        WebElement airline2 = driver.findElement(By.xpath("/html//p[.='Airline: Aer Lingus']"));
//        String airlineString = airline2.getText().substring(9);
//        WebElement price2 = driver.findElement(By.xpath("/html//p[.='Price: 200.98']"));
//        String priceString = price2.getText().substring(7);

        Assert.assertEquals(PurchasePage.AirlineText(), airline);
        Assert.assertEquals(PurchasePage.FlightNumber(), flightNum);
        Assert.assertEquals(PurchasePage.Price2(), price);


        //WebElement taxes = driver.findElement(By.xpath("/html//p[.='Arbitrary Fees and Taxes: 514.76']"));
        String taxesStr = PurchasePage.StrTaxes();

        //WebElement totalcost = driver.findElement(By.xpath("/html/body//em[.='715.74 ']"));
        String costStr = PurchasePage.TotalCost();

        String priceStr = PurchasePage.Price2();

        float costInt = Float.parseFloat(costStr);
        float taxesInt = Float.parseFloat(taxesStr);
        float priceInt = Float.parseFloat(priceStr);
        float a = Math.abs(taxesInt + priceInt);

        Assert.assertEquals(a, costInt);


        PurchasePage.FirstName();
        PurchasePage.Adress();
        PurchasePage.Sity();
        PurchasePage.State();
        PurchasePage.ZipCode();
        PurchasePage.CardType(USER_1.getCardType());
        PurchasePage.CardNumber();
        PurchasePage.CardMonth();
        PurchasePage.CardYear();
        PurchasePage.CardHolder();
        PurchasePage.Galka();
        PurchasePage.KnopkaClick();


        //driver.findElement(By.id("inputName")).sendKeys(USER_1.getInputName());
        //driver.findElement(By.id("address")).sendKeys(USER_1.getAddress());
        //driver.findElement(By.id("city")).sendKeys(USER_1.getCity());
        //driver.findElement(By.id("state")).sendKeys(USER_1.getState());
        //driver.findElement(By.id("zipCode")).sendKeys(USER_1.getZipCode());
        //new Select(driver.findElement(By.id("cardType"))).selectByValue(USER_1.getCardType());
        //driver.findElement(By.id("creditCardNumber")).sendKeys(USER_1.getCardNumber());
        //WebElement creditCardMonth = driver.findElement(By.id("creditCardMonth"));
        //creditCardMonth.clear();
        //creditCardMonth.sendKeys(USER_1.getCardMonth());
        //WebElement creditCardYear = driver.findElement(By.id("creditCardYear"));
        //creditCardYear.clear();
        //creditCardYear.sendKeys(USER_1.getCardYear());
        //driver.findElement(By.id("nameOnCard")).sendKeys(USER_1.getCardHolder());
        //driver.findElement(By.id("rememberMe")).click();
        //driver.findElement(By.cssSelector(".btn-primary")).click();

        String confirmation = driver.getCurrentUrl();
        Assert.assertEquals(confirmation, "http://blazedemo.com/confirmation.php");
    }
}