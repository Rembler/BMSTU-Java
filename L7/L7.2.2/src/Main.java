import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        var input = "�����-�������� ��������.� ������ ����� ������ � ����� �����,� � ����� ���� � ���� �������.����� ��� �� ������ ��� �������� ���������,������� �����,������� �������� �����.����� ����� ����� ����� �� �����,��������� ��� ���� �����,����������� ������� ����.����� �� �����,������ ��� ������ ��� ���������-��� ������� ��������,������� ������ ��������� ������..��� � ����� ������ ����������� ��������.���� �� ������ �� ���� �� ����,����� �� ��� ���������.";

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