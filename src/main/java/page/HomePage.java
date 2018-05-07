package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static domain.UserData.*;


public class HomePage{
    private WebDriver driver;

    @FindBy(css = "[name=\"fromPort\"]")
    private static WebElement from;

    @FindBy(css = "[name=\"toPort\"]")
    private static WebElement to;

    @FindBy(css = "input")
    private WebElement input;

    public static void select_list1(String fromPort){
        Select statusDropdown=new Select(from);
        statusDropdown.selectByValue(fromPort);
    }

    public static void select_list2(String toPort){
        Select statusDropdown=new Select(to);
        statusDropdown.selectByValue(toPort);
    }

//    public void buttonClick(){
//        input.click();
//    }

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }
}