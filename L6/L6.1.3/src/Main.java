import java.util.HashSet;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        var n = 10;
        var random = new Random();

        var start = random.nextInt(0, 100);

        SortedSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            set.add(start + i);
        }

        System.out.println(set);

        while (set.size() > 1) {
            SortedSet<Integer> subSet = new TreeSet<>();
            var sum = 0;
            var isSecondElement = false;

            for (var x : set) {
                sum += x;

                if (isSecondElement) {
                    subSet.add(sum);

                    sum = 0;
                    isSecondElement = false;

                    continue;
                }

                isSecondElement = true;
            }

            if (isSecondElement) {
                subSet.add(sum);
            }

            System.out.println(subSet);
            set = subSet;
        }
    }
}