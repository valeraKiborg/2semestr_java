public class LCS {

    // Функция для нахождения длины и самой наибольшей общей подпоследовательности
    public static String lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        // Создаем таблицу для хранения длин LCS для подстрок
        int[][] dp = new int[m + 1][n + 1];

        // Строим таблицу dp[][] снизу вверх
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Длина LCS находится в dp[m][n], теперь нужно восстановить саму подпоследовательность
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;

        // Проходим по таблице dp с конца, чтобы восстановить LCS
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                // Если символы совпадают, добавляем их в результат
                lcs.append(X.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--; // Двигаемся по направлению большего значения
            } else {
                j--;
            }
        }

        // Поскольку мы строили LCS с конца, нужно его развернуть
        return lcs.reverse().toString();
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        String result = lcs(X, Y);
        System.out.println("Наибольшая общая подпоследовательность: " + result);
    }
}