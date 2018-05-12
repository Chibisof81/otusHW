package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static domain.UserData.USER_1;

public class PurchasePage {
    private WebDriver driver;

    @FindBy(xpath = "/html//p[.='Flight Number: 9696']")
    private static WebElement flightNumber;

    public static String FlightNumber() {
        return flightNumber.getText().substring(15);
    }

    @FindBy(xpath = "/html//p[.='Airline: Aer Lingus']")
    private static WebElement airlane2;

    public static String AirlineText() {
        return airlane2.getText().substring(9);
    }

    @FindBy(xpath = "/html//p[.='Price: 200.98']")
    private static WebElement price2;

    public static String Price2() {
        return price2.getText().substring(7);
    }

    @FindBy(xpath = "/html//p[.='Arbitrary Fees and Taxes: 514.76']")
    private static WebElement taxes;

    public static String StrTaxes() {
        return taxes.getText().substring(26);
    }

    @FindBy(xpath = "/html/body//em[.='715.74 ']")
    private static WebElement totalCost;

    public static String TotalCost() {
        return totalCost.getText().substring(0, 6);
    }

    @FindBy(id = "inputName")
    private static WebElement inputName;

    public static void FirstName() {
        inputName.sendKeys(USER_1.getInputName());
    }

    @FindBy(id = "address")
    private static WebElement inputAdress;

    public static void Adress() {
        inputAdress.sendKeys(USER_1.getAddress());
    }

    @FindBy(id = "city")
    private static WebElement inputSity;

    public static void Sity() {
        inputSity.sendKeys(USER_1.getCity());
    }

    @FindBy(id = "state")
    private static WebElement inputState;

    public static void State() {
        inputState.sendKeys(USER_1.getState());
    }

    @FindBy(id = "zipCode")
    private static WebElement inputZip;

    public static void ZipCode() {
        inputZip.sendKeys(USER_1.getZipCode());
    }

    @FindBy(id = "cardType")
    private static WebElement setCardType;

    public static void CardType(String cardType) {
        Select statusDropdown = new Select(setCardType);
        statusDropdown.selectByValue(cardType);
    }

    @FindBy(id = "creditCardNumber")
    private static WebElement creditCardNumber;

    public static void CardNumber() {
        creditCardNumber.sendKeys(USER_1.getCardNumber());
    }

    @FindBy(id = "creditCardMonth")
    private static WebElement cardMonth;

    public static void CardMonth() {
        cardMonth.clear();
        cardMonth.sendKeys(USER_1.getCardMonth());
    }

    @FindBy(id = "creditCardYear")
    private static WebElement cardYear;

    public static void CardYear() {
        cardYear.clear();
        cardYear.sendKeys(USER_1.getCardYear());
    }

    @FindBy(id = "nameOnCard")
    private static WebElement nameOnCard;

    public static void CardHolder() {
        nameOnCard.sendKeys(USER_1.getCardHolder());
    }

    @FindBy(id = "rememberMe")
    private static WebElement galka;

    public static void Galka() {
        galka.click();
    }

    @FindBy(css = ".btn-primary")
    private static WebElement knopka;

    public static void KnopkaClick() {
        knopka.click();
    }

    public PurchasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}