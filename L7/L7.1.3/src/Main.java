import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String input = "��� ������ ����������� � ������� ���������� � ������������ ������� ��������� ��� �������, ������� ���������������� ������� �������� � �������� ��������";

        String result = input.replaceAll("��", "��");

        System.out.println("Input:  " +input);
        System.out.println("Result: " + result);
    }
}