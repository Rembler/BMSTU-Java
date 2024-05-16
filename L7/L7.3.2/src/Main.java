import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        var input = "В такой точно день охотился я однажды за тетеревами в Чернском уезде, Тульской губернии. Я нашел и настрелял довольно много дичи; наполненный ягдташ немилосердно резал мне плечо; но уже вечерняя заря погасала, и в воздухе, еще светлом, хотя не озаренном более лучами закатившегося солнца, начинали густеть и разливаться холодные тени, когда я решился, наконец, вернуться к себе домой. Быстрыми шагами прошел я длинную «площадь» кустов, взобрался на холм и, вместо ожиданной знакомой равнины с дубовым леском направо и низенькой белой церковью в отдалении, увидал совершенно другие, мне не известные места. У ног моих тянулась узкая долина; прямо, напротив, крутой стеной возвышался частый осинник.";

        var sentences = input.toLowerCase().split("(\\.\\.\\.)|\\.|!|\\?");

        var sentenceWords = new ArrayList<HashSet<String>>();

        for (var sentence : sentences) {
            var words = new HashSet<>(Arrays.asList(sentence.trim().split("(?U)\\W++")));

            sentenceWords.add(words);
        }

        var commonWordsFinder = new CommonWordsFinder(sentenceWords);
        commonWordsFinder.findSentencesWithCommonWords();

        System.out.println(commonWordsFinder.getMaxDepth());
    }
}

