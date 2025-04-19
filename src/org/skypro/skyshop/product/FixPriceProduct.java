package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private static final int FIX_PRICE = 100;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public String toString() {
        return String.format("< %s c фиксированной ценой : Фиксированная цена  %d руб.", getProductName(), getPrice());
    }

    @Override
    public Boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String getSearchTerm() {
        return getProductName();
    }

    @Override
    public String getContentType() {
        return "Product FixPrice";
    }

    @Override
    public String getName() {
        return getProductName();
    }

}
