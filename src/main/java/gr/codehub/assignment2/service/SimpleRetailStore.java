package gr.codehub.assignment2.service;

import gr.codehub.assignment2.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleRetailStore extends Store implements IStore {
    private double totalBuyBalance;
    private double totalSellBalance;

    @Override
    public void buy(Product product) {
        setRevenue(getRevenue() - product.getPriceWhenBuy());
    }

    @Override
    public void sell(Product product) {
        setRevenue(getRevenue() + product.getPriceWhenSell());
    }

}
