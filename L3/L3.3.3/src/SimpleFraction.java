public class SimpleFraction extends Number {
    public final int Numerator;
    public final int Denominator;

    public SimpleFraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator can not be 0");
        }

        var numeratorFactor = numerator * denominator > 0 ? 1 : -1;

        Numerator = numeratorFactor * Math.abs(numerator);
        Denominator = Math.abs(denominator);
    }

    public SimpleFraction sum(SimpleFraction simpleFraction) {
        var resultNumerator = Numerator * simpleFraction.Denominator + simpleFraction.Numerator * Denominator;
        var resultDenominator = Denominator * simpleFraction.Denominator;

        return new SimpleFraction(resultNumerator, resultDenominator);
    }

    public SimpleFraction subtract(SimpleFraction simpleFraction) {
        var resultNumerator = Numerator * simpleFraction.Denominator - simpleFraction.Numerator * Denominator;
        var resultDenominator = Denominator * simpleFraction.Denominator;

        return new SimpleFraction(resultNumerator, resultDenominator);
    }

    public SimpleFraction multiply(SimpleFraction simpleFraction) {
        var resultNumerator = Numerator * simpleFraction.Numerator;
        var resultDenominator = Denominator * simpleFraction.Denominator;

        return new SimpleFraction(resultNumerator, resultDenominator);
    }

    public SimpleFraction divide(SimpleFraction simpleFraction) {
        var resultNumerator = Numerator * simpleFraction.Denominator;
        var resultDenominator = Denominator * simpleFraction.Numerator;

        return new SimpleFraction(resultNumerator, resultDenominator);
    }

    @Override
    public int intValue() {
        return Numerator / Denominator;
    }

    @Override
    public long longValue() {
        return (long) Numerator / Denominator;
    }

    @Override
    public float floatValue() {
        return (float) Numerator / Denominator;
    }

    @Override
    public double doubleValue() {
        return (double) Numerator / Denominator;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (!(object instanceof SimpleFraction simpleFraction)) {
            return false;
        }

        return Numerator * simpleFraction.Denominator == simpleFraction.Numerator * Denominator;
    }

    @Override
    public int hashCode() {
        return Numerator * 31 + Denominator;
    }

    @Override
    public String toString() {
        return Numerator + "/" + Denominator;
    }

    public SimpleFraction simplify() {
        var greatestCommonDivisor = getGreatestCommonDivisor();

        return new SimpleFraction(
                Numerator / greatestCommonDivisor,
                Denominator / greatestCommonDivisor
        );
    }

    private int getGreatestCommonDivisor() {
        if (Numerator == 0) {
            return 0;
        }

        var numeratorAbsoluteValue = Math.abs(Numerator);
        var denominatorAbsoluteValue = Math.abs(Denominator);

        while (numeratorAbsoluteValue != denominatorAbsoluteValue) {
            if (numeratorAbsoluteValue > denominatorAbsoluteValue) {
                numeratorAbsoluteValue -= denominatorAbsoluteValue;
            } else {
                denominatorAbsoluteValue -= numeratorAbsoluteValue;
            }
        }

        return numeratorAbsoluteValue;
    }
}
