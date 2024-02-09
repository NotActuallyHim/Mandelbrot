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
        double imag = yOffset - ySlope * y; 
        return new Complex(real, imag);
    }

    public void setComplexCorners(Complex topLeft, Complex botRight) {
        double xRange = botRight.getReal() - topLeft.getReal();
        double yRange = topLeft.getImaginary() - botRight.getImaginary(); 

        double currentAspectRatio = (double) screenWidth / screenHeight;
        double desiredAspectRatio = xRange / yRange;

        if (desiredAspectRatio > currentAspectRatio) {
            xRange = yRange * currentAspectRatio;
        } else {
            yRange = xRange / currentAspectRatio;
        }

        xSlope = xRange / screenWidth;
        ySlope = yRange / screenHeight;
        xOffset = topLeft.getReal();
        yOffset = topLeft.getImaginary();
    }
}
