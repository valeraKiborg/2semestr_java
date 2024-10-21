public class Matrix {
    private int[][] data;
    private int rows;
    private int cols;

    // Конструктор для создания матрицы
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new int[rows][cols];
    }

    // Установка значения элемента матрицы
    public void setValue(int row, int col, int value) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            data[row][col] = value;
        } else {
            System.out.println("Индекс за пределами матрицы.");
        }
    }

    // Получение значения элемента матрицы
    public int getValue(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return data[row][col];
        } else {
            throw new IndexOutOfBoundsException("Индекс за пределами матрицы.");
        }
    }

    // Сложение двух матриц
    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Матрицы должны иметь одинаковый размер для сложения.");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setValue(i, j, this.getValue(i, j) + other.getValue(i, j));
            }
        }
        return result;
    }

    // Вычитание двух матриц
    public Matrix subtract(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Матрицы должны иметь одинаковый размер для вычитания.");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setValue(i, j, this.getValue(i, j) - other.getValue(i, j));
            }
        }
        return result;
    }

    // Умножение двух матриц
    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Число столбцов первой матрицы должно быть равно числу строк второй матрицы для умножения.");
        }
        Matrix result = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                int sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.getValue(i, k) * other.getValue(k, j);
                }
                result.setValue(i, j, sum);
            }
        }
        return result;
    }

    // Метод для вывода матрицы на консоль
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Пример использования
    public static void main(String[] args) {
        // Создание двух матриц 2x2
        Matrix matrix1 = new Matrix(2, 2);
        Matrix matrix2 = new Matrix(2, 2);

        // Заполнение первой матрицы
        matrix1.setValue(0, 0, 1);
        matrix1.setValue(0, 1, 2);
        matrix1.setValue(1, 0, 3);
        matrix1.setValue(1, 1, 4);

        // Заполнение второй матрицы
        matrix2.setValue(0, 0, 5);
        matrix2.setValue(0, 1, 6);
        matrix2.setValue(1, 0, 7);
        matrix2.setValue(1, 1, 8);

        // Сложение
        Matrix resultAdd = matrix1.add(matrix2);
        System.out.println("Сложение:");
        resultAdd.print();

        // Вычитание
        Matrix resultSub = matrix1.subtract(matrix2);
        System.out.println("Вычитание:");
        resultSub.print();

        // Умножение
        Matrix resultMul = matrix1.multiply(matrix2);
        System.out.println("Умножение:");
        resultMul.print();
    }
}