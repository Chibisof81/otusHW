package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static domain.UserData.*;

public class PurchasePage {
    private WebDriver driver;

    @FindBy(id = "inputName")
    private static WebElement inputName;
    public static void FirstName() {inputName.sendKeys(USER_1.getInputName());}

    @FindBy(id = "address")
    private static WebElement inputAdress;
    public static void Adress(){inputAdress.sendKeys(USER_1.getAddress());}

    @FindBy (id = "city")
    private static WebElement inputSity;
    public static void Sity(){inputSity.sendKeys(USER_1.getCity());}

    @FindBy(id = "state")
    private static WebElement inputState;
    public static void State(){inputState.sendKeys(USER_1.getState());}

    @FindBy(id = "zipCode")
    private static WebElement inputZip;
    public static void ZipCode(){inputZip.sendKeys(USER_1.getZipCode());}

    @FindBy(id = "cardType")
    private static WebElement setCardType;
    public static void CardType(String cardType){
        Select statusDropdown=new Select(setCardType);
        statusDropdown.selectByValue(cardType);}



    public PurchasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;


    }
}