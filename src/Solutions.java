import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.stylesheets.LinkStyle;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

        @NotNull
        @Contract(pure = true)
        public static List<List<Integer>> threeSum(final int[] array) {
            // Using a set to remove duplicates for us later
            Set<List<Integer>> results = new HashSet<>();

            // Lookup hash map to avoid a third loop, lowering complexity to O(n^2)
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                map.put(array[i], i);
            }

            // We loop twice over the array, trying each combination
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    // For each combination, calculate the needed solution and check if it exists
                    int third = (array[i] + array[j]) * -1;
                    Integer index_of_third = map.get(third);
                    // If there is a solution, make sure it doesn't have the same index as i or j
                    // to prevent using a value twice
                    if (index_of_third != null && index_of_third != i && index_of_third != j) {
                        // Now we need to make sure not to include duplicates
                        // A duplicate has the same values
                        List<Integer> result = Arrays.asList(array[i], array[j], third);
                        Collections.sort(result);
                        results.add(result);
                    }
                }
            }

            // Need to convert the set back to a list. Note that the requirement to return a list of unique lists is
            // borderline stupid because that should actually be a set
            List<List<Integer>> result = new LinkedList<>();
            result.addAll(results);
            return result;
        }

        // This is the official solution which is far less readable but as efficient
        public static List<List<Integer>> threeSumOfficial(int[] num) {
            Arrays.sort(num);
            List<List<Integer>> res = new LinkedList<>();
            for (int i = 0; i < num.length-2; i++) {
                if (i == 0 || num[i] != num[i - 1]) {
                    int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                    while (lo < hi) {
                        if (num[lo] + num[hi] == sum) {
                            res.add(Arrays.asList(num[i], num[lo], num[hi]));
                            while (lo < hi && num[lo] == num[lo+1]) lo++;
                            while (lo < hi && num[hi] == num[hi-1]) hi--;
                            lo++;
                            hi--;
                        } else if (num[lo] + num[hi] < sum) {
                            lo++;
                        } else {
                            hi--;
                        }
                    }
                }
            }
            return res;
        }
    }
}
