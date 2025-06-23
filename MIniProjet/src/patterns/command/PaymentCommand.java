package patterns.command;

import patterns.strategy.PaymentStrategy;
import Model.TransactionManager;

public class PaymentCommand implements Command {
    private PaymentStrategy paymentStrategy;
    private double amount;
    private TransactionManager transactionManager;
    private boolean executed;

    public PaymentCommand(PaymentStrategy paymentStrategy, double amount,
                          TransactionManager transactionManager) {
        this.paymentStrategy = paymentStrategy;
        this.amount = amount;
        this.transactionManager = transactionManager;
        this.executed = false;
    }

    @Override
    public boolean execute() {
        boolean success = paymentStrategy.pay(amount);
        if (success) {
            transactionManager.addTransaction(this);
            executed = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean undo() {
        if (executed) {
            System.out.printf("Annulation du paiement de %.2f€%n", amount);
            executed = false;
            return true;
        }
        return false;
    }
}
