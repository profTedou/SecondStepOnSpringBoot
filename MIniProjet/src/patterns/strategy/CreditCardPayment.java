package patterns.strategy;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean pay(double amount) {
        System.out.printf("Paiement de %.2f€ effectué par carte %s%n",
                amount, cardNumber.substring(cardNumber.length() - 4));
        return true;
    }
}
