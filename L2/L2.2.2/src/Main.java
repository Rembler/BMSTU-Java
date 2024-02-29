import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите размерность матрицы");

        int matrixSize = 0;
        if (sc.hasNextInt()) {
            matrixSize = sc.nextInt();
        }

        sc.nextLine();

        System.out.println("Введите величину сдвига");

        int offset = 0;
        if (sc.hasNextInt()) {
            offset = sc.nextInt();
        }

        sc.nextLine();

        sc.close();

        var matrix = new int[matrixSize][matrixSize];

        Random random = new Random();
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = random.nextInt(-matrixSize, matrixSize + 1);
            }
        }

        System.out.println("\nИсходная матрица:");
        PrintMatrix(matrix);

        var newMatrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                int newJ = j + offset;
                int newI = i;

                while (newJ >= matrixSize) {
                    newJ -= matrixSize;
                    newI = newI + 1;

                    if (newI == matrixSize) {
                        newI = 0;
                    }
                }

                newMatrix[newI][newJ] = matrix[i][j];
            }
        }

        System.out.printf("\nИсходная матрица, циклически сдвинутая на %d\n", offset);
        PrintMatrix(newMatrix);
    }

    private static void PrintMatrix(int[][] matrix) {
        for (int[] line : matrix) {
            for (int element : line)
            {
                System.out.printf("%4d", element);
            }

            System.out.println();
        }
    }
}