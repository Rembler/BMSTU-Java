import java.util.*;

public class CustomArray<T extends ICustomArrayElement<T>> extends ArrayList<T> {
    public CustomArray() {
        super();
    }

    public CustomArray(int initialCapacity) {
        super(initialCapacity);
    }

    public CustomArray(Collection<T> data) {
        super(data);
    }

    @Override
    public boolean add(T element) {
        return super.add(element);
    }

    public CustomArray<T> sum(CustomArray<T> array) throws IllegalArgumentException {
        CustomArray<T> result = new CustomArray<>();

        if(size() != array.size()) {
            throw new IllegalArgumentException("Arrays have different sizes");
        }

        for (int i = 0; i < size(); i++) {
            result.add(get(i).sum(array.get(i)));
        }

        return result;
    }

    public CustomArray<T> subtract(CustomArray<T> array) throws IllegalArgumentException {
        CustomArray<T> result = new CustomArray<>();

        if(size() != array.size()) {
            throw new IllegalArgumentException("Arrays have different sizes");
        }

        for (int i = 0; i < size(); i++) {
            result.add(get(i).subtract(array.get(i)));
        }

        return result;
    }

    public CustomArray<T> multiply(CustomArray<T> array) throws IllegalArgumentException {
        CustomArray<T> result = new CustomArray<>();

        if(size() != array.size()) {
            throw new IllegalArgumentException("Arrays have different sizes");
        }

        for (int i = 0; i < size(); i++) {
            result.add(get(i).multiply(array.get(i)));
        }

        return result;
    }

    public void print() {
        var formattedString = toString();

        System.out.println(formattedString);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public String toString() {
        Iterator<T> iterator = iterator();

        if (!iterator.hasNext())
            return "[]";

        var stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        for (;;) {
            T element = iterator.next();

            stringBuilder.append(element.format());

            if (!iterator.hasNext()) {
                stringBuilder.append(']');

                return stringBuilder.toString();
            }

            stringBuilder.append(", ");
        }
    }
}
