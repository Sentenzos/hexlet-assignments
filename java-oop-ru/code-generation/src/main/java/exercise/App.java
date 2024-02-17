package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

// BEGIN
public class App {
    public static void save(Path path, Car car) {
        try {
            Files.writeString(path, car.serialize());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Car extract(Path path) {
        try {
            var r = Car.unserialize(Files.readString(path));
            System.out.println(r);
            return r;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
// END
