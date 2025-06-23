package Model;

import patterns.command.Command;
import java.util.Stack;

public class TransactionManager {
    private Stack<Command> transactions = new Stack<>();
    private Stack<Command> undoneTransactions = new Stack<>();

    public void addTransaction(Command transaction) {
        transactions.push(transaction);
        undoneTransactions.clear();
    }

    public boolean undoLastTransaction() {
        if (transactions.isEmpty()) {
            return false;
        }

        Command transaction = transactions.pop();
        if (transaction.undo()) {
            undoneTransactions.push(transaction);
            return true;
        }
        return false;
    }

    public boolean redoLastTransaction() {
        if (undoneTransactions.isEmpty()) {
            return false;
        }

        Command transaction = undoneTransactions.pop();
        if (transaction.execute()) {
            transactions.push(transaction);
            return true;
        }
        return false;
    }
}
