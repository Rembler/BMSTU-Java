import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            var reader = new BufferedReader(new FileReader(args[0] + "/src/" + "Main.java"));
            var writer = new BufferedWriter(new FileWriter(args[0] + '/' + args[1]));

            String currentLine = reader.readLine();

            while (currentLine != null) {
                StringBuilder newLine = new StringBuilder();

                for (int i = currentLine.length() - 1; i >= 0; i--) {
                    newLine.append(currentLine.charAt(i));
                }

                writer.write(newLine.toString() + '\n');

                currentLine = reader.readLine();
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}