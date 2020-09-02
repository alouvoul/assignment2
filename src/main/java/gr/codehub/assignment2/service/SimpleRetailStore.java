package gr.codehub.assignment2.service;

import gr.codehub.assignment2.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleRetailStore implements IStore {
    private double totalBuyBalance;
    private double totalSellBalance;

    /**
     * Adds the buyd price to the totalBuyBalance of the store
     *
     * @param product
     */
    @Override
    public void buy(Product product) {
        setTotalBuyBalance(getTotalBuyBalance() + product.getPriceWhenBuy());
    }

    /**
     * Adds the sell price to the totalSellBalance of the store
     *
     * @param product
     */
    @Override
    public void sell(Product product) {
        setTotalSellBalance(getTotalSellBalance() + product.getPriceWhenSell());
    }


    /**
     * Returns the amount of money that increased by the transactions abstracts expenditure from incomes.
     *
     * @return The value of revenue
     */
    @Override
    public double getRevenue(){
        return totalSellBalance - totalBuyBalance;
    }
}
