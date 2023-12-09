package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> actual1 = App.take(list, 3);
        List<Integer> actual2 = App.take(list, 0);

        List<Integer> expected1 = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> expected2 = new ArrayList<>();

        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);
        // END
    }
}
