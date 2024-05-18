import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        System.out.println(Arrays.stream(numbers).filter(num -> num % 2 != 0).sum());
    }
}