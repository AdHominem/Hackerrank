import java.util.HashMap;
import java.util.Map;

public class Solutions {

    static class ArraysSolutions {

        // Naive solution solves the problem in O(n^2)
        public static int[] sumTwoSlow(final int[] array, final int target) {
            int[] result = new int[2];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (i != j && array[i] + array[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
            return result;
        }

        // The inner loop can be replaced with a hash map to reduce complexity to O(n)
        public static int[] sumTwo(final int[] array, final int target) {
            int[] result = new int[2];

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < array.length; i++) {
                Integer value = map.get(target - array[i]);
                if (value == null) {
                    map.put(array[i], i);
                } else {
                    result[0] = value;
                    result[1] = i;
                    break;
                }
            }

            return result;
        }
    }
}
