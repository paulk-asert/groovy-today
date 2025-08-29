import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortNumericStrings {
    private static final Map<String, Integer> WORD_NUMBERS = Map.of(
        "ZERO", 0, "ONE", 1, "TWO", 2,
        /* ...add more... */
        "TEN", 10
    );

    public static void main(String[] args) {
        List<String> nums = Arrays.asList("222", "ZERO", "4", "33", "PI", "TWO");

        nums.sort(Comparator.comparing(SortNumericStrings::isInteger));

        int pp = partitionPoint(nums, s -> !isInteger(s));
        nums.subList(0, pp).sort(Comparator.reverseOrder());
        nums.subList(pp, nums.size()).sort(Comparator.comparingInt(Integer::parseInt));

        if (!nums.equals(List.of("ZERO", "TWO", "PI", "4", "33", "222"))) {
            throw new AssertionError("Sort mismatch: " + nums);
        }

        List<Number> result = nums.stream().map(s -> {
            if (isInteger(s)) {
                return Integer.parseInt(s);
            } else if ("PI".equals(s)) {
                return java.lang.Math.PI;
            } else if ("E".equals(s)) {
                return java.lang.Math.E;
            } else if (WORD_NUMBERS.containsKey(s)) {
                return WORD_NUMBERS.get(s);
            } else {
                throw new IllegalArgumentException("Unknown literal: " + s);
            }
        }).collect(Collectors.toList());

        List<Number> expected = List.of(0, 2, Math.PI, 4, 33, 222);
        if (!result.equals(expected)) {
            throw new AssertionError("Transformation mismatch: " + result);
        }
    }

    private static boolean isInteger(String s) {
        return s.matches("-?\\d+");
    }

    private static int partitionPoint(List<String> list, Predicate<String> predicate) {
        for (int i = 0; i < list.size(); i++) {
            if (!predicate.test(list.get(i))) {
                return i;
            }
        }
        return list.size();
    }
}
