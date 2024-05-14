public class Main {
    public static void main(String[] args) throws Exception {
        var vector1 = new Vector(2, 0);
        var vector2 = new Vector(-2, -4, 3);

        try {
            System.out.println(vector1.Subtract(vector2).toString());
        }
        catch (VectorOperationException exception) {
            System.out.printf("Operation failed. %s%n", exception.getMessage());
        }
    }
}