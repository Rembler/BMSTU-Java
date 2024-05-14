public class Main {
    public static void main(String[] args) {
        Vector3D[] vectors = new Vector3D[] {};

        try {
            vectors = new Vector3D[] {
                    new Vector3D(
                            new Point3D(0, 0, 46341),
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
        } catch (InvalidCoordinatesException exception) {
            System.out.printf("Unable to create vectors. %s%n", exception.getMessage());

            return;
        }

        try {
            System.out.println(Vector3DBase.AreCoplanarVectors(vectors[0], vectors[1], vectors[2]));
        }
        catch (IndexOutOfBoundsException exception) {
            System.out.printf("Unable to check if vectors are coplanar. %s%n", exception.getMessage());
        }
    }
}

