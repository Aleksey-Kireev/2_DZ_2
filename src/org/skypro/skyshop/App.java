package org.skypro.skyshop;

import org.skypro.skyshop.articles.SearchEngine;
import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.articles.Searchable;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.basket.ProductBasket;

public class App {


    public static void print(String find, Searchable[] result) {
        System.out.printf(" === Поиск по магазину === %n Ключевое слово - %s %n ", find);
        for (Searchable s : result) {
            if (s != null) {
                System.out.println(s.getStringRepresentation());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("---- ==== org.skypro.skyshop.App.main ==== ----\n");

        ProductBasket basket = new ProductBasket();

//    Печать пустой корзины
        System.out.println("Содержимое пустой корзины:");
        basket.printBasket();
        System.out.println();

        SimpleProduct banana = new SimpleProduct("Банан", 320);
        DiscountedProduct apple = new DiscountedProduct("Яблоко", 410, 5);
        SimpleProduct bread = new SimpleProduct("Хлеб", 54);
        DiscountedProduct meat = new DiscountedProduct("Мясо", 650, 12);
        FixPriceProduct sugar = new FixPriceProduct("Сахар");
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

        System.out.println("Стоимость пустой корзины: " + basket.getSummBasket() + " руб.");
        System.out.println();
        System.out.println("Есть ли Хлеб в пустой корзине: " + basket.getCompairProduct("Хлеб"));

        System.out.println();

        System.out.println("\n======= Реализуем ДЗ № 3 - ИНТЕРФЕЙСЫ - =======\n");

        SearchEngine searchEngine = new SearchEngine(10);

        searchEngine.add(banana);
        searchEngine.add(apple);
        searchEngine.add(milk);
        searchEngine.add(sugar);

        Article buckwheat = new Article("Как варить гречку", "Статья про приготовление блюд из гречневой крупы.");
        Article wallpaper = new Article("Поклейка обоев своими руками", "Статья о самостоятельном наклеивание " +
                "рулонных обоев.");
        Article rice = new Article("Как сварить рисовую крупу", "Статья про приготовление блюд из рисовой крупы.");
        Article salo = new Article("Как засолить сало в домашних условиях", "Несколько простых рецептов по засолке " +
                "сала.");

        searchEngine.add(buckwheat);
        searchEngine.add(wallpaper);
        searchEngine.add(salo);
        searchEngine.add(rice);

        String findArticle = "Яблок";
        Searchable[] results = searchEngine.Search(findArticle);
        print(findArticle, results);

        System.out.println();

        findArticle = "круп";
        results = searchEngine.Search(findArticle);
        print(findArticle, results);

    }


}



