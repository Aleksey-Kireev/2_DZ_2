package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String productName, int basePrice, int discount) {
        super(productName);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public Boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {

        return String.format("< %s со скидкой : %d руб. (скидка %d %%)", getProductName(), getPrice(), discount);
    }

    @Override
    public int getPrice() {
        return basePrice - (basePrice * discount / 100);
    }
}
