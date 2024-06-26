public class Point3D {
    public int X;
    public int Y;
    public int Z;
    public Point2D XYProjection;
    public Point2D XZProjection;
    public Point2D YZProjection;

    public Point3D(int x, int y, int z) throws InvalidCoordinatesException {
        if (Math.abs(x) > 46340 || Math.abs(y) > 46340 || Math.abs(z) > 46340) {
            throw new InvalidCoordinatesException("Coordinate can not exceed 46340");
        }

        X = x;
        Y = y;
        Z = z;
        XYProjection = new Point2D(x, y);
        XZProjection = new Point2D(x, z);
        YZProjection = new Point2D(y, z);
    }
}
