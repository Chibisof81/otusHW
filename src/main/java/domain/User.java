package domain;

public class User {

    private final String inputName;
    private final String address;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String cardType;
    private final String cardNumber;
    private final String cardMonth;
    private final String cardYear;
    private final String cardHolder;

    User( String inputName,
          String address,
          String city,
          String state,
          String zipCode,
          String cardType,
          String cardNumber,
          String cardMonth,
          String cardYear,
          String cardHolder){
        this.inputName = inputName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cardMonth = cardMonth;
        this.cardYear = cardYear;
        this.cardHolder = cardHolder;
    }

}
