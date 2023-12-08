package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> matchList = new ArrayList<>();
        var whereKeySet = where.keySet();
        var whereValues = where.values();

        for (var book: books) {
            var bookKeySet = book.keySet();
            var bookValues = book.values();
            if (bookKeySet.containsAll(whereKeySet) && bookValues.containsAll(whereValues)) {
                matchList.add(book);
            }
        }

        return matchList;
    }
}
//END
