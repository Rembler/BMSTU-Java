import java.util.ArrayList;
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

        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            strings.add(sc.nextLine());
        }

        sc.close();

        strings.sort(new CustomStringComparator());

        System.out.println("Отсортированные строки:");

        for (String string : strings) {
            System.out.println(string);
        }
    }
}