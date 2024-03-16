public class Main {
    public static void main(String[] args) throws Exception {
        var vector1 = new Vector(2, 0);
        var vector2 = new Vector(-2, -4);

        System.out.println(vector1.Subtract(vector2).toString());
    }
}