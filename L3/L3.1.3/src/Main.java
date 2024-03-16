public class Main {
    public static void main(String[] args) {
        var vectors = new Vector3D[] {
                new Vector3D(
                        new Point3D(0, 0, 0),
                        new Point3D(1, 1, -1)
                ),
                new Vector3D(
                        new Point3D(0, -1, 3),
                        new Point3D(-1, 2, -2)
                ),
                new Vector3D(
                        new Point3D(3, 2, -3),
                        new Point3D(3, -2, 3)
                )
        };

        System.out.println(Vector3DBase.AreCoplanarVectors(vectors[0], vectors[1], vectors[2]));
    }
}

