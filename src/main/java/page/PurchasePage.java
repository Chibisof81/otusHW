package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static domain.UserData.*;

public class PurchasePage {
    private WebDriver driver;

    @FindBy(id = "inputName")
    private static WebElement inputName;

    public static void FirstName() {
        inputName.sendKeys(USER_1.getInputName());
    }


    public PurchasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;


    }
}