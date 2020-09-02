package gr.codehub.assignment2.service;

import gr.codehub.assignment2.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class InventoryRetailStore implements IStore {

    // Probably is unnecessary for the exercise !!!
    private double revenue;
    List<Product> inventory;

    /**
     * No argument constructor
     */
    public InventoryRetailStore(){
        revenue = 0.0;
        inventory = new ArrayList<>();
    }

    /**
     * Only a starting revenue added in the construction
     * @param revenue The available amount of money
     */
    public InventoryRetailStore(double revenue){
        this.revenue = revenue;
        inventory = new ArrayList<>();
    }


    @Override
    public void buy(Product product) {
        setRevenue(getRevenue() - product.getPriceWhenBuy());
        inventory.add(product);
    }

    @Override
    public void sell(Product product) {
        setRevenue(getRevenue() + product.getPriceWhenSell());
        inventory.remove(product);
    }

    @Override
    public void reset() {
        this.setInventory(new ArrayList<Product>());
    }
}
