public class Vector3DBase {
    public int X;
    public int Y;
    public int Z;
    public double Modulus;

    public Vector3DBase(int x, int y, int z) {
        X = x;
        Y = y;
        Z = z;
        Modulus = Math.sqrt(X * X + Y * Y + Z * Z);
    }

    public boolean IsOrthogonalTo(Vector3DBase vector) {
        var scalarProduct = Multiply(this, vector);

        return scalarProduct == 0;
    }

    public boolean IsEqualTo(Vector3DBase vector) {
        return Modulus == vector.Modulus;
    }

    public static boolean AreCoplanarVectors(Vector3DBase first, Vector3DBase second, Vector3DBase third) {
        var determinant = new int[][] {
                { first.X, first.Y, first.Z },
                { second.X, second.Y, second.Z },
                { third.X, third.Y, third.Z }
        };

        var determinantValue = determinant[0][0] * (determinant[1][1] * determinant[2][2] - determinant[1][2] * determinant[2][1])
                - determinant[0][1] * (determinant[1][0] * determinant[2][2] - determinant[1][2] * determinant[2][0])
                + determinant[0][2] * (determinant[1][0] * determinant[2][1] - determinant[1][1] * determinant[2][0]);

        return determinantValue == 0;
    }

    private static int Multiply(Vector3DBase left, Vector3DBase right) {
        return left.X * right.X + left.Y * right.Y + left.Z * right.Z;
    }
}