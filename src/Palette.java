import java.awt.Color;

public class Palette {
    private static int colorScheme = 1;

    public static int getScheme() {
        return Palette.colorScheme;
    }

    public static void setScheme(int num) {
        Palette.colorScheme = num;
    }

    public static Color MapColor(double value) {
        double ratio;
        if (value == -1) {
            return Color.BLACK;
        } else {
            ratio = normalize(value);
        }
        if (Palette.getScheme() == 1) {
            return Scheme1(ratio);
        }
        return Color.PINK;
    }

    private static double normalize(double value) {
        return value / Mandelbrot.getLimit();
    }

    private static Color Scheme1(double ratio){
        Color orange = Color.ORANGE;
        Color blue = Color.BLUE;
        int r = (int)(orange.getRed() * (1 - ratio) + blue.getRed()*ratio);
        int b = (int)(orange.getBlue() * (1 - ratio) + blue.getBlue()*ratio);
        int g = (int)(orange.getGreen() * (1 - ratio) + blue.getGreen()*ratio);
        return new Color(r,g,b);
    }

}
