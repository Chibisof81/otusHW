package domain;

public class UserBuilder {
    private String inputName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String cardType;
    private String cardNumber;
    private String cardMonth;
    private String cardYear;
    private String cardHolder;

    public UserBuilder inputName(final String inputName){
        this.inputName = inputName;
        return this;
    }

    public UserBuilder address (final String address){
        this.address = address;
        return this;
    }

    public UserBuilder city (final String city){
        this.city = city;
        return this;
    }

    public UserBuilder state (final String state){
        this.state = state;
        return this;
    }

    public UserBuilder zipCode (final String zipCode){
        this.zipCode = zipCode;
        return this;
    }

    public UserBuilder cardType (final String cardType){
        this.cardType = cardType;
        return this;
    }

    public UserBuilder cardNumber (final String cardNumber){
        this.cardNumber = cardNumber;
        return this;
    }

    public UserBuilder cardMonth (final String cardMonth){
        this.cardMonth = cardMonth;
        return this;
    }

    public UserBuilder cardYear (final String cardYear){
        this.cardYear = cardYear;
        return this;
    }

    public UserBuilder cardHolder (final String cardHolder){
        this.cardHolder = cardHolder;
        return this;
    }

    public String getInputName() {
        return inputName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardMonth() {
        return cardMonth;
    }

    public String getCardYear() {
        return cardYear;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public User build(){
        return new User(this);
    }
}
