import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        var input = "Test. Dummy mock. Testing test.";
        var wordsToFind = new ArrayList<String>();

        wordsToFind.add("test");
        wordsToFind.add("dummy");
        wordsToFind.add("mock");

        var wordsWithCount = new ArrayList<WordWithCount>();

        var words = input.toLowerCase().trim().split("(?U)\\W++");

        for (var word : wordsToFind) {
            var lowerCaseWord = word.toLowerCase();

            var count = Arrays.stream(words).filter(w -> w.equals(lowerCaseWord)).count();

            var wordWithCount = new WordWithCount(word, count);

            wordsWithCount.add(wordWithCount);
        }

        wordsWithCount.sort(Comparator.comparingLong(w -> -w.Count));

        for (var word : wordsWithCount) {
            System.out.printf("%s: %d\n", word.Word, word.Count);
        }
    }
}

