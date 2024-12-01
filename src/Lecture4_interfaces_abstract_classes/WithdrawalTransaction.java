package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    public WithdrawalTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    private boolean checkDepositAmount(int amt) {
        if (amt < 0) {
            return false;
        } else {
            return true;
        }
    }

    // Method to reverse the transaction
    public boolean reverse() {
        return true;
    } // return true if reversal was successful

    // Method to print a transaction receipt or details
    public void printTransactionDetails() {
        System.out.println("Deposit Trasaction: " + this.toString());
    }

    /*
    Oportunity for assignment: implementing different form of withdrawal
     */
    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        if (ba.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        ba.withdraw(amount);
    }

    /*
    Assignment 1 Q3: Write the Reverse method - a method unique to the WithdrawalTransaction Class
     */
    public boolean reverse(BankAccount ba) {
        if (!reversed) {
            ba.deposit(getAmount());
            reversed = true;
            throw new InsufficientFundsException("Transaction reversed");
            return true;
        }
        return false;
    }
}
