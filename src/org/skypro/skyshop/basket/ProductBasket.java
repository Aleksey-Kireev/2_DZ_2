package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    private final List<Product> products = new LinkedList<>();
    private int size = 0;

    public void addProduct(Product product) {
        products.add(product);
        size++;

    }

    public int getSummBasket() {
        int summ = 0;
        for (Product prod : products) {
            if (prod != null) {
                summ += prod.getPrice();
            }
        }
        return summ;
    }

    public void printBasket() {
        if (size == 0) {
            System.out.println("- = В корзине пусто = -");
            return;
        }
        int summ = 0;
        int count = 0;
        for (Product prod : products) {
            if (prod != null && prod.isSpecial()) {
                count++;
            }
            if (prod != null) {
                System.out.println(prod);
                summ += prod.getPrice();
            }
        }
        System.out.println("Итого: " + summ + " руб.");
        System.out.println("Специальных товаров: " + count + " шт.");
    }

    public boolean getCompairProduct(String nameReq) {
        for (Product prod : products) {
            if (prod != null && prod.getProductName().equals(nameReq)) {
                return true;
            }
        }
        return false;
    }

    public void printRemovedList(List<Product> productRemove) {
        if (productRemove.isEmpty()) {
            System.out.println(" Удаленных продуктов нет. ");
        } else {
            System.out.println("Список удаленных продуктов: ");
            for (Product prod : productRemove) {
                System.out.println(prod);
            }
        }
    }

    public List<Product> removeProduct(String name) {
        List<Product> productRemove = new LinkedList<>();
        Iterator<Product> prod = products.iterator();

        while (prod.hasNext()) {
            Product tempProd = prod.next();

            if (tempProd != null && tempProd.getProductName().equals(name)) {
                System.out.printf("- Продукт <<  %s  >> добавлен в удаленные %n", tempProd.getProductName());
                productRemove.add(tempProd);
                prod.remove();
            }
        }
        if (productRemove.isEmpty()) {
            System.out.printf("- %s такого продукта нет %n", name);
        }

        return productRemove;
    }

    public void clearBasket() {
        Iterator<Product> prod = products.iterator();
        while (prod.hasNext()) {
            prod.next();
            prod.remove();
        }
        size = 0;
    }
}


