import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String input = "Не пора ль нам, братия начать";

        StringBuilder result1 = new StringBuilder();
        StringBuilder result2 = new StringBuilder();

        Pattern pattern = Pattern.compile("(?U)\\w");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            result1.append(String.format("%c  ", input.charAt(matcher.start())));
            result2.append(String.format("%d  ", (int) input.charAt(matcher.start())));
        }

        System.out.println(input);
        System.out.println("Result 1: " + result1.toString());
        System.out.println("Result 2: " + result2.toString());
    }
}