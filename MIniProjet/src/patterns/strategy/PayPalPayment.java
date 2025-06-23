package patterns.strategy;

public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean pay(double amount) {
        System.out.printf("Paiement de %.2f€ effectué via PayPal (%s)%n",
                amount, email);
        return true;
    }
}