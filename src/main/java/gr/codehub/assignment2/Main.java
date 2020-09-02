package gr.codehub.assignment2;

import gr.codehub.assignment2.model.Account;
import gr.codehub.assignment2.model.Product;
import gr.codehub.assignment2.model.StoreAccount;
import gr.codehub.assignment2.service.IStore;
import gr.codehub.assignment2.service.InventoryRetailStore;
import gr.codehub.assignment2.service.SimpleRetailStore;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        testExercise1();
        testExercise2();
    }

    private static void testExercise2() {
        System.out.println("\n\n ================= Exercise 2 ===================== \n\n");
        Product x1 = new Product(1, "Painting Picasso. Guernica", 100, 1000);
        Product x2 = new Product(2, "Painting Tsarouxis. Naftis A", 200, 2000);
        Product x4 = new Product(3, "Chair. Luis XV", 100, 1000);
        IStore simple= new SimpleRetailStore();
        simple.buy(x1);
        simple.buy(x4);
        simple.sell(x1);
        System.out.println( "The revenue is: " + simple.getRevenue());
        System.out.println("\n\n ============================================================= \n\n");

        Product xx1 = new Product(1, "Painting Picasso. Guernica", 100, 1000);
        Product xx2 = new Product(2, "Painting Tsarouxis. Naftis A", 200, 2000);
        Product xx4 = new Product(3, "Chair. Luis XV", 100, 1000);
        IStore invStore = new InventoryRetailStore();
        invStore.buy(xx1);
        invStore.buy(xx4);
        invStore.sell(xx1);
        System.out.println(invStore.getRevenue());
        invStore.sell(xx2);
        List<Product> productList = invStore.getInventory();
        System.out.println("The products list are:");
        productList.stream().forEach(System.out::println);


    }


    private static void testExercise1() {
        System.out.println("\n\n ================= Exercise 1 - Account ===================== \n\n");
        Account account = new Account("Tasos", 1000.0);
        System.out.println("Value to Deposit: 500");
        account.deposit(500.0);
        System.out.println("Value to withdraw: 700");
        double testValue1 = 700;
        if (checkAvailability(account , testValue1)){
            account.withdraw(700);
        }
        System.out.println("Value to withdraw: 1000");
        testValue1 = 1000;
        if (checkAvailability(account , testValue1)){
            account.withdraw(700);
        }
        System.out.println("Account details: " + account);

        System.out.println("\n\n ================== Exercise 1 - StoreAccount ========================= \n\n");

        StoreAccount storeAccount = new StoreAccount("Dimitris", 100.0, "Mpakaliko", "mid");
        System.out.println("Account details:" + storeAccount);
        String temp = "extra";
        if (storeAccount.changeCategory(temp))
            System.out.println("Category changed to: " + temp);
        else System.out.println(temp + " It's not a valid category");

        System.out.println("Value to Deposit: 200");
        storeAccount.deposit(200.0);
        storeAccount.withdraw(100);
        storeAccount.withdraw(300);
        System.out.println("Account details:" + storeAccount);

    }

    private static boolean checkAvailability(Account account, double value) {
        if (account.getBalance() >= value){
            System.out.println("Valid transaction");
            return true;
        }
        else{
            System.out.println("There are no sufficient funds!");
            return false;
        }

    }

}
