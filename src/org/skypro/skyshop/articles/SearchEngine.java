package org.skypro.skyshop.articles;

public class SearchEngine {
    private final Searchable[] search;
    private int num = 0;

    public SearchEngine(int item) {
        this.search = new Searchable[item];
    }

    public void add(Searchable searchObject) {
        if (num < search.length) {
            search[num++] = searchObject;
        } else {
            System.out.println("Нет свободного места.");
        }
    }

    public Searchable[] Search(String query) {
        Searchable[] result = new Searchable[5];
        int size = 0;
        for (Searchable s : search) {
            if (size >= 5) {
                break;
            }
            if (s != null && s.getSearchTerm().contains(query)) {
                result[size++] = s;

            }
        }
        return result;
    }


}
