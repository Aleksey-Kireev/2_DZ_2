package org.skypro.skyshop.articles;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> search;

    public SearchEngine() {
        this.search = new ArrayList<>();
    }

    public void add(Searchable searchObject) {
        search.add(searchObject);
    }

    public List<Searchable> search(String query) {
        List<Searchable> result = new ArrayList<>();
        for (Searchable s : search) {
            if (s != null && s.getSearchTerm().contains(query)) {
                result.add(s);
            }
        }
        return result;
    }

    public Searchable bestSearchObj(String str) throws BestResultNotFound {
        System.out.println("Искомое слово - " + str);
        Searchable bestResult = null;
        int score = 0;
        for (Searchable s : search) {
            int numb = 0;
            int index = 0;
            if (s != null) {
                String subStr = s.getSearchTerm().toLowerCase();

                int indexSubStr = subStr.indexOf(str, index);
                while (indexSubStr != -1) {
                    numb++;
                    index = indexSubStr + str.length();
                    indexSubStr = subStr.indexOf(str, index);
                }
            }
            if (numb > score) {
                score = numb;
                bestResult = s;
            }

        }
        if (bestResult == null) {
            throw new BestResultNotFound(str + " - Объект с таким критерием поиска не найден.");
        }
        System.out.println("Искомое слово встречается - " + score + " раз.");
        return bestResult;
    }


}
