import java.util.Scanner;

public class StickGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество палочек n: ");
        long n = scanner.nextLong();

        boolean sashaTurn = true; // Ход Саши первый
        while (n > 0) {
            if (n % 2 == 1) {
                // Если количество палочек нечетное, игрок может взять только 1 палочку
                n -= 1;
            } else {
                // Если количество палочек четное, игрок может взять либо 1, либо половину
                if (n / 2 >= 1) {
                    n /= 2; // Берем половину, если можем
                } else {
                    n -= 1; // Если n = 2, берем 1 палочку
                }
            }

            // Переключаем ход игрока
            sashaTurn = !sashaTurn;
        }

        // Игра закончена, если последний ход был Саши, то Таня победила, и наоборот
        if (sashaTurn) {
            System.out.println("Таня победила!");
        } else {
            System.out.println("Саша победил!");
        }
    }
}