package Model;

import patterns.observer.Observable;
import patterns.strategy.PaymentStrategy;

public class PaymentProcessor extends Observable {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public boolean processPayment(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Aucune méthode de paiement sélectionnée");
        }

        boolean success = paymentStrategy.pay(amount);
        if (success) {
            notifyObservers(String.format("Paiement réussi de %.2f€", amount));
        } else {
            notifyObservers(String.format("Échec du paiement de %.2f€", amount));
        }
        return success;
    }
}
