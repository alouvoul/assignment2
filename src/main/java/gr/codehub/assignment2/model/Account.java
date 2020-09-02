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

    public Account(String owner, Double balance) {
        this.owner = owner;
        this.balance = balance;
        this.numberOfTransactions = 0;
    }

    public double withdraw(double withdrawValue){
        if (withdrawValue > balance && withdrawValue < 0)
            return -1;

        setNumberOfTransactions(getNumberOfTransactions() + 1);
        setBalance(getBalance() - withdrawValue);
        return withdrawValue;
    }

    public void deposit(double depositValue){
        setNumberOfTransactions(getNumberOfTransactions() + 1);
        setBalance(getBalance() + depositValue);
    }

}
