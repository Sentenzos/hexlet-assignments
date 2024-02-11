package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int elementNumber) {
        if (apartments.isEmpty()) return new ArrayList<>();
        List<Home> copy = new ArrayList<>(apartments.subList(0, elementNumber));
        copy.sort(Comparator.comparingDouble(Home::getArea));
        return copy.stream().map(Object::toString).toList();
    }
}
// END
