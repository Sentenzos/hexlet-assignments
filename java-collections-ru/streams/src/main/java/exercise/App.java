package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        return emails.stream()
                .filter(x -> x.endsWith("gmail.com") || x.endsWith("yandex.ru") || x.endsWith("hotmail.com"))
                .count();
    }
}
// END
