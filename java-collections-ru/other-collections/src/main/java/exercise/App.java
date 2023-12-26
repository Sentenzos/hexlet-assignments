package exercise;

import java.util.*;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> set = new HashSet<>(data1.keySet());
        set.addAll(data2.keySet());
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        for (var key: set) {
            Object val1 = data1.get(key);
            Object val2 = data2.get(key);
            if (!data1.containsKey(key) && data2.containsKey(key)) {
                map.put(key, "added");
            } else if (data1.containsKey(key) && !data2.containsKey(key)) {
                map.put(key, "deleted");
            } else if (val1 != val2) {
                map.put(key, "changed");
            } else {
                map.put(key, "unchanged");
            }
        }

        return map;
    }

    public static void main(String[] args) {

    }
}
//END
