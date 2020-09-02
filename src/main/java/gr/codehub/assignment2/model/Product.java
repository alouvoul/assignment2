package gr.codehub.assignment2.model;

public class Product {

    private  int id;
    private String name;
    private double priceWhenBuy;
    private double priceWhenSell;

    public Product(){

    }

    public Product(int id, String name, double priceWhenBuy, double priceWhenSell) {
        this.id = id;
        this.name = name;
        this.priceWhenBuy = priceWhenBuy;
        this.priceWhenSell = priceWhenSell;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceWhenBuy() {
        return priceWhenBuy;
    }

    public void setPriceWhenBuy(double priceWhenBuy) {
        this.priceWhenBuy = priceWhenBuy;
    }

    public double getPriceWhenSell() {
        return priceWhenSell;
    }

    public void setPriceWhenSell(double priceWhenSell) {
        this.priceWhenSell = priceWhenSell;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priceWhenBuy=" + priceWhenBuy +
                ", priceWhenSell=" + priceWhenSell +
                '}';
    }
}
