package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {


    public static void main(String[] args) {
        System.out.println("---- ==== org.skypro.skyshop.App.main ==== ----\n");

        ProductBasket basket = new ProductBasket();

//    Печать пустой корзины
        System.out.println("Содержимое пустой корзины:");
        basket.allPrint();
        System.out.println();

        Product banana = new Product("Банан", 320);
        Product apple = new Product("Яблоко", 410);
        Product bread = new Product("Хлеб", 54);
        Product meat = new Product("Мясо", 650);
        Product sugar = new Product("Сахор", 89);
        Product milk = new Product("Молоко", 132);
        Product fish = new Product("Рыба", 740);

//    Добавляем продукты в корзину
        basket.addProduct(banana);
        basket.addProduct(apple);
        basket.addProduct(bread);

//      Печатаем не полную корзину с продуктами
        System.out.println("Содержимое не полной корзины:");
        basket.allPrint();
        basket.addProduct(meat);
        basket.addProduct(sugar);
//    --- Попытка добавить еще один продукт
        basket.addProduct(milk);
        System.out.println();

//      Печатаем всю корзину с продуктами
        System.out.println("Содержимое корзины:");
        basket.allPrint();

        System.out.println();
        System.out.println("Общая стоимость продуктов в корзине: " + basket.getSummBasket() + " руб.");

        System.out.println();
        System.out.println("Поиск Хлеба в корзине:");
        String nameReq = "Хлеб";
        String find = basket.getReq(nameReq) ? "Продукт найден." : "Такого продукта нет.";
        System.out.println(find);
        System.out.println();
        System.out.println("Поиск Молока в корзине:");
        nameReq = "Молоко";
        find = basket.getReq(nameReq) ? "Продукт найден." : "Такого продукта нет.";
        System.out.println(find);

        System.out.println();
        basket.clearBasket();
        System.out.println("Содержимое корзины после очистки:");
        basket.allPrint();

        System.out.println("Сьоимость пустой корзины: " + basket.getSummBasket() + " руб.");
        System.out.println();
        System.out.println("Есть ли Хлеб в пустой корзине: " + basket.getReq("Хлеб"));

        System.out.println();

    }


}
