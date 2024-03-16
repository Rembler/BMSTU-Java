public class CustomArrayElementOne implements ICustomArrayElement<CustomArrayElementOne> {
    public int A;
    public int B;

    public CustomArrayElementOne(int a, int b) {
        A = a;
        B = b;
    }

    @Override
    public CustomArrayElementOne sum(CustomArrayElementOne element) {
        return new CustomArrayElementOne(A + element.A, B + element.B);
    }

    @Override
    public CustomArrayElementOne subtract(CustomArrayElementOne element) {
        return new CustomArrayElementOne(A - element.A, B - element.B);
    }

    @Override
    public CustomArrayElementOne multiply(CustomArrayElementOne element) {
        return new CustomArrayElementOne(A * element.A, B * element.B);
    }

    @Override
    public String format() {
        return String.format("{A: %d, B: %d}", A, B);
    }
}
