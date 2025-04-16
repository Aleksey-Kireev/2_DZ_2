package org.skypro.skyshop.articles;

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
        return titleName + "\n" + text;
    }

    @Override
    public String getSearchTerm() {
        return getTitleName() + getText();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return titleName;
    }

   /* @Override
    public String getStringRepresentation() {
        return getTitleName() + " - " + getContentType();
    }*/
}
