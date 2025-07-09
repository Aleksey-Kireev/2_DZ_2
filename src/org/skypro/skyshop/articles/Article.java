package org.skypro.skyshop.articles;


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


}
