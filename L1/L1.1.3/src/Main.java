import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите количество строк");

        int count = 0;
        if (sc.hasNextInt()) {
            count = sc.nextInt();
        }

        sc.nextLine();

        System.out.println("Введите строку");
        String str = sc.nextLine();

        System.out.println("Строки с переходом на новую строку:");

        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }

        System.out.println("Строки без перехода на новую строку:");

        for (int i = 0; i < count; i++) {
            System.out.print(str);
        }

        sc.close();
    }
}