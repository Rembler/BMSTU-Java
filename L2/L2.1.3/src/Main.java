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

        var averageLength = GetAverageLength(strings);
        strings.removeIf(s -> s.length() <= averageLength);

        System.out.println("Отфильтрованные строки:");

        for (String string : strings) {
            System.out.println(string + " (" + string.length() + ")");
        }
    }

    private static int GetAverageLength(ArrayList<String> strings) {
        var sumLength = 0;

        for (String string : strings) {
            sumLength += string.length();
        }

        return sumLength / strings.size();
    }
}