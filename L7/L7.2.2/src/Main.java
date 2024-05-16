import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        var input = "Олень-северное животное.В летнее время оленям в тайге жарко,а в горах даже в июле холодно.Олень как бы создан для северных просторов,жёсткого ветра,длинных морозных ночей.Олень легко бежит вперёд по тайге,подминает под себя кусты,переплывает быстрые реки.Олень не тонет,потому что каждая его шерстинка-это длинная трубочка,которую внутри наполняет воздух..Нос у оленя покрыт серебристой шёрсткой.Если бы шерсти на носу не было,олень бы его отморозил.";

        var words = input.split("(?U)\\W+");

        var wordCount = new HashMap<String, Integer>();

        for (var word : words) {
            var lowerCaseWord = word.toLowerCase();

            var count = wordCount.containsKey(lowerCaseWord)
                    ? wordCount.get(lowerCaseWord) + 1
                    : 1;

            wordCount.put(lowerCaseWord, count);
        }

        System.out.println(input);

        for (var word : wordCount.keySet()) {
            System.out.printf("%s: %d\n", word, wordCount.get(word));
        }
    }
}