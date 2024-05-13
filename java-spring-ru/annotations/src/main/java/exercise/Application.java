package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for (Method method : Address.class.getDeclaredMethods()) {

            if (method.isAnnotationPresent(Inspect.class)) {
//                var startTime = System.currentTimeMillis();
//
//                try {
//                    // Выполняем метод с аннотацией LogExecutionTime
//                    method.invoke(address).;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }

                System.out.printf("Method %s returns a value of type %s.%n",
                        method.getName(),
                        method.getReturnType().toString().equals("class java.lang.String") ?
                                "String" : method.getReturnType());
//                System.out.println("Execution time: " + executionTime + " milliseconds");
            }
        }
        // END
    }
}
