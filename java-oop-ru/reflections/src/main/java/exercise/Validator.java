package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Object object) {
        List<String> list = new ArrayList<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (var field: fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NotNull.class) && field.get(object) == null) {
                    list.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
// END
