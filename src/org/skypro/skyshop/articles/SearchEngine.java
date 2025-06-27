package org.skypro.skyshop.articles;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> search;

    public SearchEngine() {
        this.search = new HashSet<>();
    }

    public void add(Searchable searchObject) {
        search.add(searchObject);
    }

    public Set<Searchable> search(String query) throws BestResultNotFound {
        Set<Searchable> result = new TreeSet<>(new Article.SearchComparator());

        for (Searchable s : search) {
            if (s != null && s.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                result.add(s);
            }
        }
        if (result.isEmpty()) {
            throw new BestResultNotFound("Нет соответствующих запросу элементов");
        }
        System.out.println(result);
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

                int indexSubStr = subStr.indexOf(str.toLowerCase(), index);
                while (indexSubStr != -1) {
                    numb++;
                    index = indexSubStr + str.length();
                    indexSubStr = subStr.indexOf(str.toLowerCase(), index);
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
