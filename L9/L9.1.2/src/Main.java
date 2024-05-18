import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var strings = new String[] {
                "Top Gun: Maverick",
                "Dune",
                "Terminator",
                "Blade Runner",
                "The Lord of the Rings",
                "Fast & Furious"
        };

        var regex = "^\\w+ \\w++$";

        System.out.println(Arrays.stream(strings).findFirst().get());
        System.out.println(Arrays.stream(strings).anyMatch(str -> str.matches(regex)));
    }
}