import MathObjects.Complex;

public class View {

    private int screenWidth, screenHeight;

    private double xSlope, xOffset, ySlope, yOffset;

    public View(int w, int h) {
        screenWidth = w;
        screenHeight = h;
        setComplexCorners(new Complex(-2, 1), new Complex(1, -1));
    }

    public Complex translate(int x, int y) {
        double real = xSlope * x + xOffset;

        double imag = ySlope * y + yOffset;
        
        return new Complex(real, imag);
    }

    public void setComplexCorners(Complex topLeft, Complex botRight) {
        xSlope = (botRight.getReal()-topLeft.getReal())/screenWidth;
        ySlope = (botRight.getImaginary()-topLeft.getImaginary())/screenHeight;
        xOffset = topLeft.getReal();
        yOffset = topLeft.getImaginary();
    }

}