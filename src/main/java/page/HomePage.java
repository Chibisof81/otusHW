package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage{
    private WebDriver driver;

    @FindBy(css = "[name=\"fromPort\"]")
    public static WebElement from;

    @FindBy(css = "[name=\"toPort\"]")
    public static WebElement to;

    @FindBy(css = "input")
   private WebElement input;


//    public void buttonClick(){
//        input.click();
//    }

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }
}