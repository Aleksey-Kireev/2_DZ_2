package org.skypro.skyshop;

import org.skypro.skyshop.articles.BestResultNotFound;
import org.skypro.skyshop.articles.SearchEngine;
import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.articles.Searchable;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.basket.ProductBasket;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class App {

    public static void print(String find, TreeMap<String, Searchable> result) {
        System.out.printf(" === Поиск по магазину === %n Ключевое слово - %s %n ", find);
//        for (Searchable s : result) {
        for (Map.Entry<String, Searchable> s : result.entrySet()) {
            if (s != null) {
                System.out.println(s.getValue().getStringRepresentation());
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
        basket.addProduct(fish);
        System.out.println();

//      Печатаем всю корзину с продуктами
        System.out.println("Содержимое корзины:");
        basket.printBasket();

        System.out.println();
        System.out.println("Общая стоимость продуктов в корзине: " + basket.getSummBasket() + " руб.");

//        - - - = = =  Задание № 5    ( List )  = = = - - -

        System.out.println("\n  - - - = = =  Задание № 5    ( List )  = = = - - - \n");

//        Удаляем один продукт
        List<Product> deleteBasket = basket.removeProduct("Молоко");
        basket.printRemovedList((deleteBasket));

        System.out.println();

//        Удаляем еще один продукт
        deleteBasket.addAll(basket.removeProduct("Яблоко"));
        basket.printRemovedList((deleteBasket));
        System.out.println();

//        Удаляем не существующий продукт
        deleteBasket.addAll(basket.removeProduct("Соль"));
        basket.printRemovedList((deleteBasket));
        System.out.println();

//      Печатаем всю корзину с продуктами
        System.out.println("Содержимое корзины:");
        basket.printBasket();
        System.out.println();


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

        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(banana);
        searchEngine.add(apple);
        searchEngine.add(milk);
        searchEngine.add(sugar);

        Article buckwheat = new Article("Как варить гречку", "Статья про приготовление блюд из гречневой крупы. \n " +
                "Для проверки мы дабавим слово крупа еще раз, а затем еще раз укрупненно");
        Article wallpaper = new Article("Поклейка обоев своими руками", "Статья о самостоятельном наклеивание " +
                "рулонных обоев.\n" +
                "570 рублей за квадратный метр. Да-да, именно столько придется заплатить, чтобы рабочие из ремонтной " +
                " фирмы поклеили обои в комнате по стандартной схеме с удалением старых, нанесением грунтовки и  " +
                "шпаклевки и выравниванием стен. А теперь подсчитайте, во сколько обойдется вся квартира!  И это без " +
                "стоимости обоев!\n" +
                "Предлагаем вам сэкономить и поклеить обои самостоятельно. Мы подробно расскажем вам, как сделать " +
                "так, чтобы оклейка обоев прошла на ура и с результатом 100%.");
        Article rice = new Article("Как сварить рисовую крупу", "Статья про приготовление блюд из рисовой крупы. ведь" +
                " рисовая крупа всем крупам крупа");
        Article salo = new Article("Как засолить сало в домашних условиях", "Несколько простых рецептов по засолке " +
                "сала.");

        searchEngine.add(buckwheat);
        searchEngine.add(wallpaper);
        searchEngine.add(salo);
        searchEngine.add(rice);

//        - - - -  = = = = Задание № 6 ---- Реализуем проверку MAP  и Интерфейсы = = = =  - - - - -

        System.out.println("\n======= Реализуем ДЗ № 6 - MAP - =======\n");

        SimpleProduct appleGold = new SimpleProduct("Яблоко Gold", 600);
        FixPriceProduct milkDiscont = new FixPriceProduct("Молоко Эконом");

        searchEngine.add(appleGold);
        searchEngine.add(milkDiscont);

        Article apples = new Article("Длительное хранение яблок в условиях городских квартир", "Лучшим местом для " +
                "хранения яблок в городской квартире всегда был и остается застекленный балкон или лоджияю Потому что" +
                " яблоки требуют прохлады, идеальная температура хранения для них от -2°С до +5°С.");
        searchEngine.add(apples);

        String findArticle = "Яблок";

//        List<Searchable> resultList = searchEngine.search(findArticle);
        TreeMap<String, Searchable> resultList = searchEngine.search(findArticle);
        print(findArticle, resultList);

        System.out.println();

        findArticle = "круп";
        resultList = searchEngine.search(findArticle);
        print(findArticle, resultList);

        System.out.println();

        findArticle = "Молоко";
        resultList = searchEngine.search(findArticle);
        print(findArticle, resultList);


//        - - - -  = = = = Задание № 4 ---- Исключения = = = =  - - - - -

//        Exception проверки
        System.out.println("\n - - - -  = = = = Задание № 4 ---- Исключения = = = =  - - - - - \n");

        try {
            SimpleProduct eggs = new SimpleProduct(null, 54);
            basket.addProduct(eggs);
        } catch (IllegalArgumentException exc) {
            System.out.println("Добавление SimpleProduct");
            System.out.println(exc.getMessage() + "\n");
        }

        try {
            SimpleProduct eggs = new SimpleProduct("Яйцо", -54);
            basket.addProduct(eggs);
        } catch (IllegalArgumentException exc) {
            System.out.println("Добавление SimpleProduct");
            System.out.println(exc.getMessage() + "\n");
        }

        try {
            DiscountedProduct onion = new DiscountedProduct("Лук", -650, 120);
            basket.addProduct(onion);
        } catch (IllegalArgumentException exc) {
            System.out.println("Добавление DiscountedProduct");
            System.out.println(exc.getMessage() + "\n");
        }

        try {
            DiscountedProduct onion = new DiscountedProduct("Лук", 650, 120);
            basket.addProduct(onion);

        } catch (IllegalArgumentException exc) {
            System.out.println("Добавление DiscountedProduct");
            System.out.println(exc.getMessage() + "\n");
        }

        try {
            FixPriceProduct lemon = new FixPriceProduct("");
            basket.addProduct(lemon);
        } catch (IllegalArgumentException exc) {
            System.out.println("Добавление FixPriceProduct");
            System.out.println(exc.getMessage() + "\n");
        }

        basket.printBasket();

//        Проверка поиска наиболее подходящего объекта критериям поиска
        try {
            String findString = "круп";
            Searchable indexSubStr1 = searchEngine.bestSearchObj(findString);
            System.out.println("Наиболее подходящее = " + indexSubStr1);
        } catch (BestResultNotFound exc) {
            System.out.println("exc = " + exc);
        }

        System.out.println();

        try {
            String findString = "Обо";
            Searchable indexSubStr2 = searchEngine.bestSearchObj(findString);
            System.out.println("Наиболее подходящее = " + indexSubStr2);
        } catch (BestResultNotFound ext) {
            System.out.println("По запросу " + ext.getMessage());
        }


        System.out.println();

        try {
            String findString = "яблок";
            Searchable indexSubStr2 = searchEngine.bestSearchObj(findString);
            System.out.println("Наиболее подходящее = " + indexSubStr2);
        } catch (BestResultNotFound ext) {
            System.out.println("По запросу " + ext.getMessage());
        }

        System.out.println();

//        Поиск несуществующего объекта
        try {
            String findString = "водка";
            Searchable indexSubStr2 = searchEngine.bestSearchObj(findString);
            System.out.println("Наиболее подходящее = " + indexSubStr2);
        } catch (BestResultNotFound ext) {
            System.out.println("По запросу " + ext.getMessage());
        }

        System.out.println();


    }


}



