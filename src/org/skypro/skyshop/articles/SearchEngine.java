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
