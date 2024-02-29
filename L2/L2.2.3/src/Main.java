import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите размерность матрицы");

        int matrixSize = 0;
        if (sc.hasNextInt()) {
            matrixSize = sc.nextInt();
        }

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

        var maxIncreasingSequenceLength = 1;
        var currentIncreasingSequenceLength = 1;
        int previousElement = matrix[0][0];

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (matrix[i][j] > previousElement) {
                    currentIncreasingSequenceLength++;
                } else {
                    currentIncreasingSequenceLength = 1;
                }

                if (currentIncreasingSequenceLength > maxIncreasingSequenceLength) {
                    maxIncreasingSequenceLength = currentIncreasingSequenceLength;
                }

                previousElement = matrix[i][j];
            }
        }

        System.out.printf(
            "\nНаибольшее число элементов, идущих подряд и образующих возрастающую последовательность: %d",
            maxIncreasingSequenceLength);
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