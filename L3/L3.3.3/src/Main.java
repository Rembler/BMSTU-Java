public class Main {
    public static void main(String[] args) {
        var fraction1 = new SimpleFraction(-5, 12);
        var fraction2 = new SimpleFraction(3, 4);

        var sum = fraction1.sum(fraction2);
        var difference = fraction1.subtract(fraction2);
        var product = fraction1.multiply(fraction2);
        var quotient = fraction1.divide(fraction2);

        System.out.printf("%s + %s = %s (%s)\n", fraction1, fraction2, sum, sum.simplify());
        System.out.printf("%s - %s = %s (%s)\n", fraction1, fraction2, difference, difference.simplify());
        System.out.printf("%s * %s = %s (%s)\n", fraction1, fraction2, product, product.simplify());
        System.out.printf("%s / %s = %s (%s)\n", fraction1, fraction2, quotient, quotient.simplify());
    }
}