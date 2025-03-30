package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private final Product[] PRODUCTS = new Product[5];
    private int size = 0;

    public void addProduct(Product product) {
        if (size >= PRODUCTS.length) {
            System.out.println("Невозможно добавить продукт.");
            return;
        }
        PRODUCTS[size++] = product;
    }

    public int getSummBasket() {
        int summ = 0;
        for (Product prod : PRODUCTS) {
            if (prod != null) {
                summ += prod.getPrice();
            }
        }
        return summ;
    }

    public void allPrint() {
        if (size == 0) {
            System.out.println("- = В корзине пусто = -");
            return;
        }
        for (Product prod : PRODUCTS) {
            if (prod != null) {
                System.out.println(prod);
            }
        }
        System.out.println("Итого: " + getSummBasket() + " руб.");
    }

    public boolean getReq(String nameReq) {
        for (Product prod : PRODUCTS) {
            if (prod != null && prod.getProductName().equals(nameReq)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < PRODUCTS.length; i++) {
            PRODUCTS[i] = null;
        }
        size = 0;
    }
}


