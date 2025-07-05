package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    private final Map<String, List<Product>> products = new TreeMap<>();

    public void addProduct(Product product) {

        products.computeIfAbsent(product.getProductName(), k -> new ArrayList<>()).add(product);

    }

    public int getSummBasket() {

        return products.values().stream()
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .mapToInt(Product::getPrice)
                .sum();

    }

    public void printBasket() {

        products.values().stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

        int summ = getSummBasket();
        int count = (int) products.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();

        if (summ == 0) {
            System.out.println("- = В корзине пусто = -");
            return;
        }
        System.out.println("Итого: " + summ + " руб.");
        System.out.println("Специальных товаров: " + count + " шт.");
    }

    public boolean getCompairProduct(String nameReq) {
        if (nameReq == null) {
            return false;
        }
        for (Map.Entry<String, List<Product>> prod : products.entrySet()) {
            for (Product p : prod.getValue()) {
                if (p != null && p.getProductName().equals(nameReq)) {
                    return true;
                }
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
        List<Product> productRemove = new ArrayList<>();

        for (Map.Entry<String, List<Product>> iter : products.entrySet()) {
            List<Product> prodList = iter.getValue();
            Iterator<Product> productIterator = prodList.iterator();

            while (productIterator.hasNext()) {
                Product prod = productIterator.next();

                if (prod != null && prod.getProductName().equals(name)) {
                    productIterator.remove();
                    productRemove.add(prod);
                    System.out.printf("- Продукт <<  %s  >> добавлен в удаленные %n", prod.getProductName());
                }
            }
        }

        if (productRemove.isEmpty()) {
            System.out.printf("- %s такого продукта нет %n", name);
        }
        return productRemove;
    }

    public void clearBasket() {
        products.clear();
    }
}


