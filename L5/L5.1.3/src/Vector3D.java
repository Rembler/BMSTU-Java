public class Vector3D extends Vector3DBase {
    public Point3D A;
    public Point3D B;

    public Vector3D(Point3D a, Point3D b) {
        super(b.X - a.X, b.Y - a.Y, b.Z - a.Z);
        A = a;
        B = b;
    }

    public boolean IntersectsWith(Vector3D vector) {
        return AreOnSamePlane(this, vector)
                && ProjectionsOntoXYPlaneIntersect(this, vector)
                && ProjectionsOntoXZPlaneIntersect(this, vector)
                && ProjectionsOntoYZPlaneIntersect(this, vector);
    }

    private static boolean AreOnSamePlane(Vector3D first, Vector3D second) {
        var firstAuxVector = new Vector3D(first.A, second.A);
        var secondAuxVector = new Vector3D(first.A, second.B);

        return AreCoplanarVectors(first, firstAuxVector, secondAuxVector);
    }

    private static boolean ProjectionsOntoXYPlaneIntersect(Vector3D left, Vector3D right) {
        var leftXYPlaneProjection = new Vector2DProjection(left.A.XYProjection, left.B.XYProjection);
        var rightXYPlaneProjection = new Vector2DProjection(right.A.XYProjection, right.B.XYProjection);

        return ProjectionsOntoPlaneIntersects(leftXYPlaneProjection, rightXYPlaneProjection);
    }

    private static boolean ProjectionsOntoXZPlaneIntersect(Vector3D left, Vector3D right) {
        var leftXZPlaneProjection = new Vector2DProjection(left.A.XZProjection, left.B.XZProjection);
        var rightXZPlaneProjection = new Vector2DProjection(right.A.XZProjection, right.B.XZProjection);

        return ProjectionsOntoPlaneIntersects(leftXZPlaneProjection, rightXZPlaneProjection);
    }

    private static boolean ProjectionsOntoYZPlaneIntersect(Vector3D left, Vector3D right) {
        var leftYZPlaneProjection = new Vector2DProjection(left.A.YZProjection, left.B.YZProjection);
        var rightYZPlaneProjection = new Vector2DProjection(right.A.YZProjection, right.B.YZProjection);

        return ProjectionsOntoPlaneIntersects(leftYZPlaneProjection, rightYZPlaneProjection);
    }

    private static boolean ProjectionsOntoPlaneIntersects(Vector2DProjection left, Vector2DProjection right) {
        return ProjectionsOntoLineIntersects(new Vector1DProjection(left.A.X, left.B.X), new Vector1DProjection(right.A.X, right.B.X))
                && ProjectionsOntoLineIntersects(new Vector1DProjection(left.A.Y, left.B.Y), new Vector1DProjection(right.A.Y, right.B.Y))
                && GetSignedArea(left.A, left.B, right.A) * GetSignedArea(left.A, left.B, right.B) <= 0
                && GetSignedArea(right.A, right.B, left.A) * GetSignedArea(right.A, right.B, left.B) <= 0;
    }

    private static boolean ProjectionsOntoLineIntersects(Vector1DProjection left, Vector1DProjection right) {
        int leftMin;
        int leftMax;

        if (left.A > left.B) {
            leftMin = left.B;
            leftMax = left.A;
        } else {
            leftMin = left.A;
            leftMax = left.B;
        }

        int rightMin;
        int rightMax;

        if (right.A > right.B) {
            rightMin = right.B;
            rightMax = right.A;
        } else {
            rightMin = right.A;
            rightMax = right.B;
        }

        return Math.max(leftMin, rightMin) <= Math.min(leftMax, rightMax);
    }

    private static int GetSignedArea(Point2D a, Point2D b, Point2D c) {
        return (b.X - a.X) * (c.Y - a.Y) - (b.Y - a.Y) * (c.X - a.X);
    }

    private static class Vector2DProjection {
        public Point2D A;
        public Point2D B;

        public Vector2DProjection(Point2D a, Point2D b) {
            A = a;
            B = b;
        }
    }

    private static class Vector1DProjection {
        public int A;
        public int B;

        public Vector1DProjection(int a, int b) {
            A = a;
            B = b;
        }
    }
}

