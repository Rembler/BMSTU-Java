package Hospital;

public class Prescription {
    private boolean _done;
    private final Type _type;

    public final int Id;

    protected Prescription(int id, Type type) {
        Id = id;
        _type = type;
        _done = false;
    }

    public boolean isDone() {
        return _done;
    }

    public Type getType() {
        return _type;
    }

    public void markAsDone() {
        _done = true;
    }

    public enum Type {
        Procedure,
        Medicine,
        Surgery
    }
}
