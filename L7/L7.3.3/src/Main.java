import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        var input = "Dummy test sentence. Second sentence to exclude word. It is funny word this 'dummy'.";

        var sentences = input.toLowerCase().split("(\\.\\.\\.)|\\.|!|\\?");

        var sentenceWords = new ArrayList<HashSet<String>>();

        for (var sentence : sentences) {
            var words = new HashSet<>(Arrays.asList(sentence.trim().split("(?U)\\W++")));

            sentenceWords.add(words);
        }

        var firstSentenceWords = sentenceWords.getFirst();

        for (int i = 1; i < sentenceWords.size(); i++) {
            firstSentenceWords.removeAll(sentenceWords.get(i));
        }

        for (var word : firstSentenceWords) {
            System.out.println(word);
        }
    }
}