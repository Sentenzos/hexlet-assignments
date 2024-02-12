package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> base = storage.toMap();
        Map<String, String> newBase = new HashMap<>();

        for (String key: base.keySet()) {
            String value = base.get(key);
            newBase.put(value, key);
        }

        for (String key: base.keySet()) {
            storage.unset(key);
        }

        for (String key: newBase.keySet()) {
            String value = newBase.get(key);
            storage.set(key, value);
        }

        base.putAll(newBase);
    }
}
// END
