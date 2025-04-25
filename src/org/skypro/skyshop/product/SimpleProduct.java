package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String productName, int price) throws IllegalArgumentException {
        super(productName);
        if (price < 0) {
            throw new IllegalArgumentException("Цена должна быть больше  `0`");
        }
        this.price = price;
    }

    @Override
    public String getSearchTerm() {
        return getProductName();
    }

    @Override
    public String getContentType() {
        return "Product Simple";

    }

    @Override
    public String getName() {
        return getProductName();
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
