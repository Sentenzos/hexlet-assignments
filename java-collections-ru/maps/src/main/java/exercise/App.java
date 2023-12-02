package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        if (sentence.isEmpty()) return new HashMap<>();

        String[] words = sentence.split(" ");
        var map = new HashMap<String, Integer>();

        for (var word: words) {
            var count = map.getOrDefault(word, 0);
            map.put(word, count+1);
        }

        return map;
    }

    public static String toString(Map<String, Integer> map) {
        var string = new StringBuilder();
        var keys = map.keySet();

        if (map.isEmpty()) return "{}";

        string.append("{");

        for (var key: keys) {
            string.append("\n\s\s" + key + ":" + " " + map.get(key));
        }

        string.append("\n}");

        return string.toString();
    }
}
//END
