package com.BlazeDemo.tests;

import com.BlazeDemo.AbstractTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPageObject;

public class ThirdTest extends AbstractTest {

    @Test
    public void loginPageTest() throws InterruptedException {
        LoginPageObject loginPageObject = new LoginPageObject(driver);

        driver.get("http://blazedemo.com/login");
        Actions actions = new Actions(driver);
        actions.moveToElement(LoginPageObject.getLoginButton()).build().perform();
        Dimension dimesions = LoginPageObject.getLoginButton().getSize();
        System.out.println("Width : "+dimesions.width);
        System.out.println("Height : "+dimesions.height);
        Assert.assertEquals(dimesions, dimesions.width(62)+dimesions.height(36));
        //Assert.assertEquals(LoginPageObject.colorLoginButton(),"rgba(37, 121, 169, 1)");

    }
}




