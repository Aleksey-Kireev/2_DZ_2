package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String productName, int basePrice, int discount) throws IllegalArgumentException {
        super(productName);
        if (basePrice < 0) {
            throw new IllegalArgumentException("Цена должна быть больше `0`");
        } else if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть в диапазоне от 0 до 100 %");
        }
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

    @Override
    public String getSearchTerm() {
        return getProductName();
    }

    @Override
    public String getContentType() {
        return "Product Discount";
    }

    @Override
    public String getName() {
        return getProductName();
    }

}
