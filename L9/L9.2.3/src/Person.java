public class Person {
    private String _name;
    private int _age;

    public Person(String name, int age) {
        _name = name;
        _age = age;
    }

    public String getName() {
        return _name;
    }

    public int getAge() {
        return _age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", _name, _age);
    }
}
