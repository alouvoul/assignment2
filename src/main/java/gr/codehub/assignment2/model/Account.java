package gr.codehub.assignment2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private String owner;
    private Double balance;
    private int numberOfTransactions;

    /**
     * Constructor which doesn't has the number of transactions which usually starts from 0;
     *
     * @param owner Name of the owner
     * @param balance The amount which can be stored
     */
    public Account(String owner, Double balance) {
        this.owner = owner;
        this.balance = balance;
        this.numberOfTransactions = 0;
    }

    /**
     * Method that abstracts the given value from the available in the account. If the value exceeds the current available
     * or is a negative value then -1 returned as an error.
     * If the value can be retrieved from the account then the numberOfTransactions value increased by one calling the
     * increaseTransactionsByOne method. Sets the new balance to account and returns the positive value as a success.
     *
     * @param withdrawValue Value that will be removed from the balance.
     * @return -1 if the value is negative or exceeds the amount that is available, else returns withdrawValue
     */
    public double withdraw(double withdrawValue){
        if (withdrawValue > balance && withdrawValue < 0)
            return -1;

        increaseTransactionsByOne();
        setBalance(getBalance() - withdrawValue);
        return withdrawValue;
    }

    /**
     * Method that adds the given value in the available balance. The numberOfTransactions value increased by one calling
     * the increaseTransactionsByOne method. Sets the new balance to account.
     *
     * @param depositValue Value to add in the current balance.
     */
    public void deposit(double depositValue){
        increaseTransactionsByOne();
        setBalance(getBalance() + depositValue);
    }

    /**
     * Method to increase the number of transactions by +1. Used by the methods deposit and withdraw.
     */
    private void increaseTransactionsByOne(){
        setNumberOfTransactions(getNumberOfTransactions() + 1);
    }
}
