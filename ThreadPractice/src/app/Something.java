package app;

public class Something {
    private static int rand;
    private static int square;
    private static int cube;

    /**
     * @return the rand
     */
    public static int getRand() {
        return rand;
    }

    /**
     * @return the square
     */
    public static int getSquare() {
        return square;
    }

    /**
     * @return the cube
     */
    public static int getCube() {
        return cube;
    }

    /**
     * @param cube the cube to set
     */
    public static void setCube(int cube) {
        Something.cube = cube;
    }

    /**
     * @param rand the rand to set
     */
    public static void setRand(int rand) {
        Something.rand = rand;
    }

    /**
     * @param square the square to set
     */
    public static void setSquare(int square) {
        Something.square = square;
    }
}