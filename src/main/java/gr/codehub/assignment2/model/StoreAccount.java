package gr.codehub.assignment2.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreAccount extends Account {

    private String storeName;
    private String accountCategory;

    public StoreAccount(String owner, Double balance, String storeName, String accountCategory) {
        super(owner, balance);
        this.storeName = storeName;
        this.accountCategory = accountCategory;
    }

    public StoreAccount(String owner, Double balance, int numberOfTransactions, String storeName, String accountCategory) {
        super(owner, balance, numberOfTransactions);
        this.storeName = storeName;
        this.accountCategory = accountCategory;
    }

    public boolean changeCategory(String category){
        // Check if the given category is valid.
        if (!category.equals("basic") & !category.equals("mid") & !category.equals("extra") & !category.equals("premium"))
            return false;

        setAccountCategory(category);
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " || StoreAccount{" +
                "storeName='" + storeName + '\'' +
                ", accountCategory='" + accountCategory + '\'' +
                '}';
    }
}
