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
        double xRange = botRight.getReal() - topLeft.getReal();
        double yRange = topLeft.getImaginary() - botRight.getImaginary(); // Invert y-axis to match standard complex plane

        double currentAspectRatio = (double) screenWidth / screenHeight;
        double desiredAspectRatio = xRange / yRange;

        if (desiredAspectRatio > currentAspectRatio) {
            // Adjust width to maintain aspect ratio
            xRange = yRange * currentAspectRatio;
        } else {
            // Adjust height to maintain aspect ratio
            yRange = xRange / currentAspectRatio;
        }

        xSlope = xRange / screenWidth;
        ySlope = yRange / screenHeight;
        xOffset = topLeft.getReal();
        yOffset = topLeft.getImaginary();
    }
}
