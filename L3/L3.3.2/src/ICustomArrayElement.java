public interface ICustomArrayElement<T extends ICustomArrayElement<T>> {
    T sum(T element);
    T subtract(T element);
    T multiply(T element);
    String format();
}
