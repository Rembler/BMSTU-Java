import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите длину массива");

        int arrSize = 0;
        if (sc.hasNextInt()) {
            arrSize = sc.nextInt();
        }

        int[] arr = new int[arrSize];

        System.out.println("Введите элементы массива");

        for (int i = 0; i < arrSize; i++) {
            if (sc.hasNextInt()) {
                arr[i] = sc.nextInt();
            }
        }

        sc.close();

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arrSize; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Минимальный элемент массива: " + min);
        System.out.println("Максимальный элемент массива: " + max);
    }
}