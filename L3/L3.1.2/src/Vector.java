import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringJoiner;

public class Vector {
    public int VectorSpaceDimension;
    public int[] Coordinates;

    public Vector(int xCoordinate) {
        VectorSpaceDimension = 1;
        Coordinates = new int[] { xCoordinate };
    }

    public Vector(int xCoordinate, int yCoordinate) {
        VectorSpaceDimension = 2;
        Coordinates = new int[] { xCoordinate, yCoordinate };
    }

    public Vector(int xCoordinate, int yCoordinate, int zCoordinate) {
        VectorSpaceDimension = 3;
        Coordinates = new int[] { xCoordinate, yCoordinate, zCoordinate };
    }

    public double GetModulus() {
        var sumOfSquares = 0;

        for (int i = 0; i < VectorSpaceDimension; i++) {
            sumOfSquares += Coordinates[i] * Coordinates[i];
        }

        return Math.sqrt(sumOfSquares);
    }

    public Vector Add(Vector vector) throws Exception {
        EnsureVectorsHaveSameVectorSpaceDimensions(this, vector);

        var resultVectorCoordinates = new ArrayList<Integer>();

        for (int i = 0; i < VectorSpaceDimension; i++) {
            resultVectorCoordinates.add(Coordinates[i] + vector.Coordinates[i]);
        }

        return CreateVectorFromCoordinates(resultVectorCoordinates);
    }

    public Vector Subtract(Vector vector) throws Exception {
        EnsureVectorsHaveSameVectorSpaceDimensions(this, vector);

        var resultVectorCoordinates = new ArrayList<Integer>();

        for (int i = 0; i < VectorSpaceDimension; i++) {
            resultVectorCoordinates.add(Coordinates[i] - vector.Coordinates[i]);
        }

        return CreateVectorFromCoordinates(resultVectorCoordinates);
    }

    public Vector MultiplyBy(int scalar) throws Exception {
        var resultVectorCoordinates = new ArrayList<Integer>();

        for (int i = 0; i < VectorSpaceDimension; i++) {
            resultVectorCoordinates.add(Coordinates[i] * scalar);
        }

        return CreateVectorFromCoordinates(resultVectorCoordinates);
    }

    public int MultiplyBy(Vector vector) {
        EnsureVectorsHaveSameVectorSpaceDimensions(this, vector);

        var scalarProduct = 0;

        for (int i = 0; i < VectorSpaceDimension; i++) {
            scalarProduct += Coordinates[i] * vector.Coordinates[i];
        }

        return scalarProduct;
    }

    public VectorsRelation DefineRelationTo(Vector vector) {
        if (this.IsCollinearTo(vector)) {
            return VectorsRelation.Collinear;
        }

        if (this.IsOrthogonalTo(vector)) {
            return VectorsRelation.Orthogonal;
        }

        return VectorsRelation.None;
    }

    @Override
    public String toString() {
        var stringJoiner = new StringJoiner(", ");

        for (int coordinate : Coordinates) {
            stringJoiner.add(Integer.toString(coordinate));
        }

        return "(" + stringJoiner + ")";
    }

    private boolean IsCollinearTo(Vector vector) {
        EnsureVectorsHaveSameVectorSpaceDimensions(this, vector);

        var coordinateRelations = new HashSet<Double>();

        for (int i = 0; i < this.VectorSpaceDimension; i++) {
            coordinateRelations.add((double) (Coordinates[i] / vector.Coordinates[i]));
        }

        return coordinateRelations.size() == 1;
    }

    private boolean IsOrthogonalTo(Vector vector) {
        EnsureVectorsHaveSameVectorSpaceDimensions(this, vector);

        var scalarProduct = this.MultiplyBy(vector);

        return scalarProduct == 0;
    }

    private static void EnsureVectorsHaveSameVectorSpaceDimensions(Vector left, Vector right) {
        if (left.VectorSpaceDimension != right.VectorSpaceDimension) {
            throw new IllegalArgumentException("Vectors have different vector space dimensions");
        }
    }

    private static Vector CreateVectorFromCoordinates(ArrayList<Integer> resultVectorCoordinates) throws Exception {
        return switch (resultVectorCoordinates.size()) {
            case 1 -> new Vector(resultVectorCoordinates.get(0));
            case 2 -> new Vector(resultVectorCoordinates.get(0),
                    resultVectorCoordinates.get(1));
            case 3 -> new Vector(resultVectorCoordinates.get(0),
                    resultVectorCoordinates.get(1),
                    resultVectorCoordinates.get(2));
            default -> throw new Exception(
                    String.format(
                            "Vector space dimension %d is not supported",
                            resultVectorCoordinates.size()));
        };
    }

    public enum VectorsRelation {
        None,
        Collinear,
        Orthogonal
    }
}