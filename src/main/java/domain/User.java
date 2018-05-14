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

    User(UserBuilder userBuilder){
        this.inputName = userBuilder.getInputName();
        this.address = userBuilder.getAddress();
        this.city = userBuilder.getCity();
        this.state = userBuilder.getState();
        this.zipCode = userBuilder.getZipCode();
        this.cardType = userBuilder.getCardType();
        this.cardNumber = userBuilder.getCardNumber();
        this.cardMonth = userBuilder.getCardMonth();
        this.cardYear = userBuilder.getCardYear();
        this.cardHolder = userBuilder.getCardHolder() ;
    }

}
