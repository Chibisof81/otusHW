package domain;

import lombok.Data;

@Data
public class UserData {
    public static final UserData USER_1 = new UserData(
            "Вася Петрович",
            "улица, дом, квартира",
            "Moscow",
            "Idaho",
            "123456",
            "dinersclub",
            "987654321",
            "8",
            "2018",
            "Vasia Petrovich");

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
}
