package models;

public class Card {
    String cardNumber;
    String dateMonth;
    String dateYear;
    String cardHolderName;

    public Card(String cartNumber, String dateMonth, String dateYear, String cardHolderName) {
        this.cardNumber = cartNumber;
        this.dateMonth = dateMonth;
        this.dateYear = dateYear;
        this.cardHolderName = cardHolderName;
    }

    public String getCartNumber() {
        return cardNumber;
    }

    public String getDateMonth() {
        return dateMonth;
    }

    public String getDateYear() {
        return dateYear;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCartNumber(String cartNumber) {
        this.cardNumber = cartNumber;
    }

    public void setDateMonth(String dateMonth) {
        this.dateMonth = dateMonth;
    }

    public void setDateYear(String dateYear) {
        this.dateYear = dateYear;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
}
