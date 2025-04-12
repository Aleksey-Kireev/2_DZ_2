package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String productName, int price) {
        super(productName);
        this.price = price;
    }

    @Override
    public Boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int getPrice() {
        return price;
    }
}
