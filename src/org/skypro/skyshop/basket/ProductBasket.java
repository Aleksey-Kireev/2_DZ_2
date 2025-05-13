package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    private final TreeMap<String, Product> products = new TreeMap<>();
    private int size = 0;

    public void addProduct(Product product) {
        products.put(product.getProductName(), product);
        size++;

    }

    public int getSummBasket() {
        int summ = 0;
        for (Map.Entry<String, Product> prod : products.entrySet()) {

            summ += prod.getValue().getPrice();

        }
        return summ;
    }

    public void printBasket() {
        int summ = 0;
        int count = 0;
        for (Map.Entry<String, Product> prod : products.entrySet()) {
            if (prod != null && prod.getValue().isSpecial()) {
                count++;
            }

            if (prod != null) {
                System.out.println(prod);
                summ += prod.getValue().getPrice();
            }
        }
        if (size == 0 || summ == 0) {
            System.out.println("- = В корзине пусто = -");
            return;
        }
        System.out.println("Итого: " + summ + " руб.");
        System.out.println("Специальных товаров: " + count + " шт.");
    }

    public boolean getCompairProduct(String nameReq) {
        for (Map.Entry<String, Product> prod : products.entrySet()) {
            if (prod != null && prod.getValue().getProductName().equals(nameReq)) {
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

        Iterator<Map.Entry<String, Product>> iter = products.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry<String, Product> prod = iter.next();

            Product tempProd = prod.getValue();

            if (tempProd.getProductName().equals(name)) {
                System.out.printf("- Продукт <<  %s  >> добавлен в удаленные %n", tempProd.getProductName());
                productRemove.add(tempProd);
                iter.remove();
            }

        }
        if (productRemove.isEmpty()) {
            System.out.printf("- %s такого продукта нет %n", name);
        }
        return productRemove;
    }

    public void clearBasket() {
        products.clear();
        size = 0;
    }
}


