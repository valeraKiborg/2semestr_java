import java.util.ArrayList;
import java.util.List;

public class Combinations {

    // Функция для генерации всех комбинаций из k элементов множества n
    public static List<List<Integer>> generateCombinations(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinationsHelper(1, n, k, new ArrayList<>(), result);
        return result;
    }

    // Вспомогательная рекурсивная функция для генерации комбинаций
    private static void generateCombinationsHelper(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // Если размер текущей комбинации равен k, добавляем её в результат
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Генерируем комбинации, начиная с числа start до n
        for (int i = start; i <= n; i++) {
            current.add(i); // Добавляем элемент в текущую комбинацию
            generateCombinationsHelper(i + 1, n, k, current, result); // Рекурсивный вызов для следующего элемента
            current.remove(current.size() - 1); // Удаляем последний элемент, чтобы попробовать следующую комбинацию
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        List<List<Integer>> result = generateCombinations(n, k);

        // Вывод всех комбинаций
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}