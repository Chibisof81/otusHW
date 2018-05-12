package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ReservePage {
    private WebDriver driver;

    @FindBy(css = "h3")
    private static WebElement header;

    public static String Header() {
        Assert.assertTrue(header.isDisplayed());
        return header.getText();
    }

    @FindBy(xpath = "/html/body//table[@class='table']//td[.='9696']")
    private static WebElement flight;

    public static String Flight() {
        return flight.getText();
    }

    @FindBy(xpath = "/html/body//table[@class='table']//td[.='Aer Lingus']")
    private static WebElement airline;

    public static String Airline() {
        return airline.getText();
    }

    @FindBy(xpath = "/html/body//table[@class='table']//td[.='$200.98']")
    private static WebElement price;

    public static String Price() {
        return price.getText().substring(1);
    }

    @FindBy(xpath = "/html/body//table[@class='table']/tbody/tr[3]/td[1]/input[@value='Choose This Flight']")
    private static WebElement buttonReserve;

    public static void  ButtonRes() {
        buttonReserve.click();
    }

    public ReservePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}
