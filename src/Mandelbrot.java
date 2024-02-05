import MathObjects.Complex;


public class Mandelbrot {

    public static int testPoint(Complex c) {
        Complex z = new Complex();
        int iteration = 1;
        int limit = 500;

        while (iteration < limit) {
            z = z.square().add(c);
            if (z.abs() > 2) {
                return iteration;
            }
            iteration++;
        }
        
        return -1;
    }
}
