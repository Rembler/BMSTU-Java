import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            var reader = new BufferedReader(new FileReader(args[0] + '/' + args[1]));
            var writer = new BufferedWriter(new FileWriter(args[0] + '/' + args[2]));

            String currentLine = reader.readLine();

            while (currentLine != null) {
                String newLine = currentLine.replace("пьян", "трезв");

                writer.write(newLine + '\n');

                currentLine = reader.readLine();
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}