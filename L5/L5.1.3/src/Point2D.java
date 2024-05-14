public class Point2D {
    public int X;
    public int Y;
    public int Z;

    public Point2D(int x, int y) throws InvalidCoordinatesException {
        if (Math.abs(x) > 46340 || Math.abs(y) > 46340) {
            throw new InvalidCoordinatesException("Coordinate can not exceed 46340");
        }

        X = x;
        Y = y;
    }
}
