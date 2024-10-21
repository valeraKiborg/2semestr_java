import java.util.HashSet;
import java.util.Set;

public class PairSum {

    public static Set<String> findPairsWithSum(int[] arr, int targetSum) {
        // Множество для хранения уникальных пар
        Set<String> pairs = new HashSet<>();
        // Множество для отслеживания посещенных чисел
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = targetSum - num;
            if (seen.contains(complement)) {
                // Создаем пару и сортируем, чтобы избежать дубликатов
                int min = Math.min(num, complement);
                int max = Math.max(num, complement);
                pairs.add(min + "," + max);
            }
            seen.add(num);
        }

        return pairs;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5, 3, 3, 2, 4};
        int targetSum = 6;

        Set<String> result = findPairsWithSum(arr, targetSum);

        // Вывод всех уникальных пар
        for (String pair : result) {
            System.out.println("Пара: (" + pair.replace(",", ", ") + ")");
        }
    }
}