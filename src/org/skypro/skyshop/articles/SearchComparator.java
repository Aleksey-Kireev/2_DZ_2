package org.skypro.skyshop.articles;

import java.util.Comparator;


public class SearchComparator implements Searchable {
    @Override
    public String getSearchTerm() {
        return "";
    }

    @Override
    public String getContentType() {
        return "";
    }

    @Override
    public String getName() {
        return "";
    }

    public static class SearchComparators implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            int searchCompare = Integer.compare(s2.getSearchTerm().length(), s1.getSearchTerm().length());
            if (searchCompare == 0) {
                return s1.getSearchTerm().compareTo(s2.getSearchTerm());
            }
            return searchCompare;
        }
    }
}
