package org.skypro.skyshop;

import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.basket.ProductBasket;

public class App {


    public static void main(String[] args) {
        System.out.println("---- ==== org.skypro.skyshop.App.main ==== ----\n");

        ProductBasket basket = new ProductBasket();

//    Печать пустой корзины
        System.out.println("Содержимое пустой корзины:");
        basket.printBasket();
        System.out.println();

        SimpleProduct banana = new SimpleProduct("Банан", 320);
        SimpleProduct apple = new SimpleProduct("Яблоко", 410);
        SimpleProduct bread = new SimpleProduct("Хлеб", 54);
        SimpleProduct meat = new SimpleProduct("Мясо", 650);
        SimpleProduct sugar = new SimpleProduct("Сахор", 89);
        SimpleProduct milk = new SimpleProduct("Молоко", 132);
        SimpleProduct fish = new SimpleProduct("Рыба", 740);

//    Добавляем продукты в корзину
        basket.addProduct(banana);
        basket.addProduct(apple);
        basket.addProduct(bread);

//      Печатаем не полную корзину с продуктами
        System.out.println("Содержимое не полной корзины:");
        basket.printBasket();
        basket.addProduct(meat);
        basket.addProduct(sugar);
        System.out.println();
//    --- Попытка добавить еще один продукт
        basket.addProduct(milk);
        System.out.println();

//      Печатаем всю корзину с продуктами
        System.out.println("Содержимое корзины:");
        basket.printBasket();

        System.out.println();
        System.out.println("Общая стоимость продуктов в корзине: " + basket.getSummBasket() + " руб.");

        System.out.println();
        System.out.println("Поиск Хлеба в корзине:");
        String nameReq = "Хлеб";
        String find = basket.getCompairProduct(nameReq) ? "Продукт найден." : "Такого продукта нет.";
        System.out.println(find);
        System.out.println();
        System.out.println("Поиск Молока в корзине:");
        nameReq = "Молоко";
        find = basket.getCompairProduct(nameReq) ? "Продукт найден." : "Такого продукта нет.";
        System.out.println(find);

        System.out.println();
        basket.clearBasket();
        System.out.println("Содержимое корзины после очистки:");
        basket.printBasket();

        System.out.println("Сьоимость пустой корзины: " + basket.getSummBasket() + " руб.");
        System.out.println();
        System.out.println("Есть ли Хлеб в пустой корзине: " + basket.getCompairProduct("Хлеб"));

        System.out.println();

    }


}
