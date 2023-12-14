package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String config) {
        var arr = Arrays.stream(config.split("\n"))
                .filter(str -> str.startsWith("environment="))
                .map(str -> str.split(","))
                .flatMap(Arrays::stream)
                .map(str -> str.replace("environment=", ""))
                .map(str -> str.replaceAll("\"", ""))
                .filter(str -> !str.trim().isEmpty())
                .filter(str -> str.startsWith("X_FORWARDED"))
                .map(str -> str.replace("X_FORWARDED_", ""))
                .toArray();

        return Arrays.toString(arr)
                .replace("[", "")
                .replace("]", "")
                .replaceAll(" ", "");
    }
}
//END
