import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        var input = "Олень-северное животное.В летнее время оленям в тайге жарко,а в горах даже в июле холодно.Олень как бы создан для северных просторов,жёсткого ветра,длинных морозных ночей.Олень легко бежит вперёд по тайге,подминает под себя кусты,переплывает быстрые реки.Олень не тонет,потому что каждая его шерстинка-это длинная трубочка,которую внутри наполняет воздух..Нос у оленя покрыт серебристой шёрсткой.Если бы шерсти на носу не было,олень бы его отморозил.";
        var lowerCaseInput = input.replace(" ", "").toLowerCase();

        var characterCount = new HashMap<Character, Integer>();
        var maxCount = 0;

        for (int i = 0; i < lowerCaseInput.length(); i++) {
            var character = lowerCaseInput.charAt(i);

            var count = characterCount.containsKey(character)
                    ? characterCount.get(character) + 1
                    : 1;

            if (count > maxCount) {
                maxCount = count;
            }

            characterCount.put(character, count);
        }

        var maxCountCharacters = new ArrayList<Character>();

        for (var character : characterCount.keySet()) {
            var count = characterCount.get(character);

            if (count == maxCount) {
                maxCountCharacters.add(character);
            }
        }

        System.out.println(input);

        for (var character : maxCountCharacters) {
            System.out.printf("%c: %d\n", character, characterCount.get(character));
        }
    }
}