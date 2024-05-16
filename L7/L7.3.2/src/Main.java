import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        var input = "� ����� ����� ���� �������� � ������� �� ���������� � �������� �����, �������� ��������. � ����� � ��������� �������� ����� ����; ����������� ������ ������������ ����� ��� �����; �� ��� �������� ���� ��������, � � �������, ��� �������, ���� �� ��������� ����� ������ ������������� ������, �������� ������� � ����������� �������� ����, ����� � �������, �������, ��������� � ���� �����. �������� ������ ������ � ������� ��������� ������, ��������� �� ���� �, ������ ��������� �������� ������� � ������� ������ ������� � ��������� ����� �������� � ���������, ������ ���������� ������, ��� �� ��������� �����. � ��� ���� �������� ����� ������; �����, ��������, ������ ������ ���������� ������ �������.";

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

