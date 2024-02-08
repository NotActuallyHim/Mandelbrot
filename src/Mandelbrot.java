import MathObjects.Complex;

public class Mandelbrot {
    private static int iterationLimit;

    public static int getLimit() {
        return Mandelbrot.iterationLimit;
    }

    public static void setLimit(int limit) {
        Mandelbrot.iterationLimit = limit;
    }

    public static int testPoint(Complex c) {
        Complex z = new Complex();
        int iteration = 0; // Start from 0 iterations

        while (iteration < iterationLimit) {
            z = z.square().add(c);
            if (z.abs() > 2) {
                return iteration;
            }
            iteration++;
        }

        return -1;
    }
}
