import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        try {
            var reader = new BufferedReader(new FileReader(args[0] + '/' + args[1]));
            var writer = new BufferedWriter(new FileWriter(args[0] + '/' + args[2]));

            String currentLine = reader.readLine();

            var vowels = getVowels();

            while (currentLine != null) {
                StringBuilder newLine = new StringBuilder();

                var words = currentLine.split(" ");

                for (var word : words) {
                    if (vowels.contains(Character.toLowerCase(word.charAt(0)))) {
                        newLine.append(word).append(' ');
                    }
                }

                if (!newLine.toString().equals("")) {
                    writer.write(newLine.toString() + '\n');
                }

                currentLine = reader.readLine();
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static HashSet<Character> getVowels() {
        var vowels = new HashSet<Character>();

        vowels.add('а');
        vowels.add('о');
        vowels.add('у');
        vowels.add('е');
        vowels.add('ы');
        vowels.add('э');
        vowels.add('я');
        vowels.add('и');
        vowels.add('ю');

        return vowels;
    }
}