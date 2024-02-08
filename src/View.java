import MathObjects.Complex;

public class View {

    private int screenWidth, screenHeight;

    private double xSlope, xOffset, ySlope, yOffset;

    public View(int w, int h) {
        screenWidth = w;
        screenHeight = h;
        setComplexCorners(new Complex(-2, 1), new Complex(2, -1));
    }

    public Complex translate(int x, int y) {
        double real = xSlope * x + xOffset;
        double imag = yOffset - ySlope * y; // Invert y-axis to match standard complex plane
        return new Complex(real, imag);
    }

    public void setComplexCorners(Complex topLeft, Complex botRight) {
        xSlope = (botRight.getReal() - topLeft.getReal()) / screenWidth;
        ySlope = (topLeft.getImaginary() - botRight.getImaginary()) / screenHeight; // Invert y-axis to match standard complex plane
        xOffset = topLeft.getReal();
        yOffset = topLeft.getImaginary();
    }
}