import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        var input = "Test. Cool dummy mock. Testing test. IKEA.";

        var words = input.trim().split("(?U)\\W++");

        var wordsByLength = new HashMap<Integer, ArrayList<WordWithInfo>>();

        for (var word : words) {
            var wordWithInfo = new WordWithInfo(word, word.length(), countVowels(word));

            if (!wordsByLength.containsKey(wordWithInfo.Length)) {
                wordsByLength.put(wordWithInfo.Length, new ArrayList<>());
            }

            wordsByLength.get(wordWithInfo.Length).add(wordWithInfo);
        }

        for (var length : wordsByLength.keySet().stream().sorted((l, r) -> r - l).toArray(Integer[]::new)) {
            var wordsWithSameLength = wordsByLength.get(length);
            wordsWithSameLength.sort(Comparator.comparingInt(l -> l.VowelCount));

            for (var word : wordsWithSameLength) {
                System.out.printf("%s ", word.Word);
            }
        }
    }

    private static int countVowels(String word) {
        var lowerCaseWord = word.toLowerCase();
        var count = 0;
        var vowels = getVowels();

        for (int i = 0; i < lowerCaseWord.length(); i++) {
            if (vowels.contains(lowerCaseWord.charAt(i))) {
                count++;
            }
        }

        return count;
    }

    private static HashSet<Character> getVowels() {
        var vowels = new HashSet<Character>();

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        vowels.add('å');
        vowels.add('û');
        vowels.add('à');
        vowels.add('î');
        vowels.add('ý');
        vowels.add('ÿ');
        vowels.add('è');
        vowels.add('þ');

        return vowels;
    }
}