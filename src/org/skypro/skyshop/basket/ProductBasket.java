package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    //        private final List<Product> products = new LinkedList<>();
//    private final TreeMap<Integer, Product> products = new TreeMap<>();
    private final TreeMap<String, Product> products = new TreeMap<>();
    //    private TreeMap<String, List<Product>> productsMap = new TreeMap<>();
    private int id = 0;
    private int size = 0;

    public void addProduct(Product product) {
//        products.add(product);
        id++;
        products.put(product.getProductName(), product);
        size++;

    }

    public int getSummBasket() {
       /* int summ = 0;
        for (Product prod : products) {
            if (prod != null) {
                summ += prod.getPrice();
            }
        }*/
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
//        for (Product prod : products) {
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
//        for (Product prod : products) {
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
//        List<Integer> idRemove = new LinkedList<>();
//       Iterator<Product> prod = products.iterator();
//    public Map<Integer, Product> removeProduct(String name) {
//        Map<Integer, Product> productRemove = new HashMap<>();
        Iterator<Map.Entry<String, Product>> iter = products.entrySet().iterator();

//        for (Map.Entry<String, Product> prod : products.entrySet()) {
//        for (int i = 0; i <= products.size().){

        while (iter.hasNext()) {
            Map.Entry<String, Product> prod = iter.next();

            Product tempProd = prod.getValue();
//            Integer id = prod.getKey();

            if (tempProd.getProductName().equals(name)) {
                System.out.printf("- Продукт <<  %s  >> добавлен в удаленные %n", tempProd.getProductName());
                productRemove.add(tempProd);
//            idRemove.add(id);
                iter.remove();
            }

        }
        if (productRemove.isEmpty()) {
            System.out.printf("- %s такого продукта нет %n", name);
        }
      /*  for (
                Product prod : productRemove) {
            products.remove(prod.getProductName());
        }*/
        return productRemove;
    }

    public void clearBasket() {
//        Iterator<Product> prod = products.iterator();

        products.clear();
//            prod.next();
//            prod.remove();

        size = 0;
    }
}


