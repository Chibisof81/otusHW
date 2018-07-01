package com.BlazeDemo.tests;

import com.BlazeDemo.AbstractTest;
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
        String size = LoginPageObject.getLoginButton().getSize().toString();
        Assert.assertEquals(size,"(62, 36)");
        //Assert.assertEquals(LoginPageObject.colorLoginButton(),"rgba(37, 121, 169, 1)");

    }
}




