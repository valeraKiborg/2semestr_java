import java.util.HashSet;
import java.util.Set;

public class PairSum {

    public static Set<int[]> findPairsWithSum(int[] arr, int targetSum) {
        // Множество для хранения уникальных пар
        Set<int[]> pairs = new HashSet<>();
        // Множество для отслеживания посещенных чисел
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = targetSum - num;
            if (seen.contains(complement)) {
                // Создаем пару и добавляем в множество (меньшее число всегда будет первым)
                pairs.add(new int[]{Math.min(num, complement), Math.max(num, complement)});
            }
            seen.add(num);
        }

        return pairs;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5, 3, 3, 2, 4};
        int targetSum = 6;

        Set<int[]> result = findPairsWithSum(arr, targetSum);

        for (int[] pair : result) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
    }
}