import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new FileReader(args[0] + '/' + args[1]));

        var firstList = new LinkedList<MatrixElement>();

        String currentLine = reader.readLine();
        var y = 0;

        while (currentLine != null) {
            if (readMatrixLine(currentLine, y, firstList)) break;

            currentLine = reader.readLine();
            y++;
        }

        var secondList = new LinkedList<MatrixElement>();

        currentLine = reader.readLine();
        y = 0;

        while (currentLine != null) {
            if (readMatrixLine(currentLine, y, secondList)) break;

            currentLine = reader.readLine();
            y++;
        }

        var sum = new int[5][5];

        MatrixElement lastCheckedElement = null;

        for (var matrixElement : firstList) {
            int i = 0;
            int j = 0;

            if (lastCheckedElement != null) {
                i = lastCheckedElement.Y;
                j = lastCheckedElement.X + 1;
            }

            while (i <= matrixElement.Y) {
                var jUpperBound = i == matrixElement.Y ? matrixElement.X : 5;

                while (j < jUpperBound) {
                    sum[i][j] = 0;
                    j++;
                }

                i++;
            }

            sum[matrixElement.Y][matrixElement.X] = matrixElement.Value;

            lastCheckedElement = matrixElement;
        }

        for (var matrixElement : secondList) {
            sum[matrixElement.Y][matrixElement.X] += matrixElement.Value;
        }

        var product = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                product[i][j] = 0;
            }
        }

        for (var firstElement : firstList) {
            for (var secondElement : secondList) {
                if (secondElement.Y == firstElement.X) {
                    product[firstElement.Y][secondElement.X] += firstElement.Value * secondElement.Value;
                }
            }
        }
    }

    private static boolean readMatrixLine(String currentLine, int y, LinkedList<MatrixElement> list) {
        if (currentLine.isEmpty()) {
            return true;
        }

        var x = 0;

        var elements = currentLine.split(" ");

        for (var element : elements) {
            var value = Integer.parseInt(element);

            if (value != 0) {
                var matrixElement = new MatrixElement(value, x, y);

                list.add(matrixElement);
            }

            x++;
        }

        return false;
    }
}

