import Model.PaymentProcessor;
import Model.TransactionManager;
import Model.User;
import patterns.command.PaymentCommand;
import patterns.strategy.CreditCardPayment;
import patterns.strategy.PayPalPayment;

public class Main {
    public static void main(String[] args) {
        // Initialisation
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        TransactionManager transactionManager = new TransactionManager();

        // Création d'utilisateurs (observers)
        User user1 = new User("Moumi", "Moumi@gmail.com");
        User user2 = new User("Kamga", "Kamga@gmail.com");

        // Ajout des observateurs
        paymentProcessor.addObserver(user1);
        paymentProcessor.addObserver(user2);

        // Configuration des stratégies de paiement
        CreditCardPayment creditCard = new CreditCardPayment("1234567812345678", "12/25", "123");
        PayPalPayment paypal = new PayPalPayment("Moumi@gmail.com", "password");

        // Exemple de paiement par carte
        paymentProcessor.setPaymentStrategy(creditCard);
        PaymentCommand paymentCommand1 = new PaymentCommand(creditCard, 100, transactionManager);
        paymentCommand1.execute();

        // Exemple de paiement par PayPal
        paymentProcessor.setPaymentStrategy(paypal);
        PaymentCommand paymentCommand2 = new PaymentCommand(paypal, 50, transactionManager);
        paymentCommand2.execute();

        // Annulation de la dernière transaction
        System.out.println("\nAnnulation de la dernière transaction...");
        transactionManager.undoLastTransaction();

        // Réexécution de la transaction annulée
        System.out.println("\nRéexécution de la transaction annulée...");
        transactionManager.redoLastTransaction();

        //boolean a = paymentProcessor.processPayment(200);
    }
}