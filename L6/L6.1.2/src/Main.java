import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var I = new ArrayList<Double>();
        var U = new ArrayList<Double>();

        var n = 5;

        var random = new Random();

        for (int i = 0; i < n; i++) {
            I.add(random.nextInt(1, 10) + (double) random.nextInt(0, 10) / 10);
            U.add((double) random.nextInt(100, 220));
        }

        System.out.print("I: ");

        for (Double entry : I) {
            System.out.printf("%s ", entry);
        }

        System.out.println();
        System.out.print("U: ");

        for (Double entry : U) {
            System.out.printf("%s ", entry);
        }

        System.out.println();
        System.out.printf("R: %s", getR(I, U));
    }

    private static double getR(ArrayList<Double> I, ArrayList<Double> U) {
        var top = IntStream
                .range(0, I.size())
                .mapToObj(i -> I.get(i) * U.get(i))
                .mapToDouble(x -> x)
                .sum();

        var bottom = I.stream()
                .mapToDouble(x -> x * x)
                .sum();

        return top / bottom;
    }
}
