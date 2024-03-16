public class Main {
    public static void main(String[] args) {
        var customArrayElement1 = new CustomArrayElementOne(1, 2);
        var customArrayElement2 = new CustomArrayElementOne(3, 4);

        var customArray = new CustomArray<CustomArrayElementOne>();

        customArray.add(customArrayElement1);
        customArray.add(customArrayElement2);

        customArray.print();
    }
}
