package gr.codehub.assignment2.service;

import gr.codehub.assignment2.model.Product;

import java.util.List;

public interface IStore {

    void buy(Product product);
    void sell(Product product);
    double getRevenue();

    default List<Product> getInventory() {
        return null;
    }

    default void reset() {

    }

}
