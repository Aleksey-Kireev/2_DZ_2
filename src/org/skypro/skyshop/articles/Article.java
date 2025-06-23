package org.skypro.skyshop.articles;

import java.util.Comparator;
import java.util.Objects;

public class Article implements Searchable {
    private final String titleName;
    private final String text;


    public Article(String titleName, String text) {
        this.titleName = titleName;
        this.text = text;
    }

    public String getTitleName() {
        return titleName;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return titleName;
    }

    @Override
    public String getSearchTerm() {
        return getTitleName() + ". " + getText();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(titleName, article.titleName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titleName);
    }

    @Override
    public String getName() {
        return titleName;
    }

    public static class SearchComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            System.out.println("Сравниваем: " + s1.getName() + " и " + s2.getName());
            int searchCompare = Integer.compare(s2.getSearchTerm().length(), s1.getSearchTerm().length());
            if (searchCompare == 0) {
                int result = s1.getSearchTerm().compareTo(s2.getSearchTerm());
                System.out.println("Результат сравнивнения: " + result);
                return result;
            }
            System.out.println("Результат сравнения по длине: " + searchCompare);
            return searchCompare;
        }
    }

}
