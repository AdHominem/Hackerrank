import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionsTest {

    @Test
    void measurePerformance() {
        final int[] hugeArray = IntStream.range(0, 100000).toArray();
        Instant start = Instant.now();
        Solutions.ArraysSolutions.sumTwoSlow(hugeArray, Integer.MAX_VALUE);
        Instant end = Instant.now();
        System.out.printf("Slow solution: %s%n", Duration.between(start, end));

        start = Instant.now();
        Solutions.ArraysSolutions.sumTwo(hugeArray, Integer.MAX_VALUE);
        end = Instant.now();
        System.out.printf("Fast solution: %s%n", Duration.between(start, end));
    }

    @Test
    void twoSumTest() {
        int[] array = {2, 7, 11, 15};
        int target = 9;
        int[] solution = {0, 1};
        assertArrayEquals(solution, Solutions.ArraysSolutions.sumTwo(array, target));
    }

    @Test
    void twoSumTestDouble() {
        int[] array = {4, 4};
        int target = 8;
        int[] solution = {0, 1};
        assertArrayEquals(solution, Solutions.ArraysSolutions.sumTwo(array, target));
    }
}
