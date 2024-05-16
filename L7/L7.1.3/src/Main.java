import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String input = "“ри закона работехники в научной фантастике Ч об€зательные правила поведени€ дл€ работов, впервые сформулираванные јйзеком јзимовым в рассказе Ђ’ораводї";

        String result = input.replaceAll("ра", "ро");

        System.out.println("Input:  " +input);
        System.out.println("Result: " + result);
    }
}