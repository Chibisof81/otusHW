package page;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
    private static WebDriver driver;

    @FindBy(css = "[type='submit']")
    private static WebElement loginButton;

    public static WebElement getLoginButton(){
        return loginButton;
    }

    public static WebElement colorLoginButton() {
        loginButton.getCssValue("background-color");
        return loginButton;
    }


    public LoginPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }


}
