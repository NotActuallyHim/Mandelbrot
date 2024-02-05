import java.awt.Color;

public class Palette {
    private static int colorScheme = 4;

    public static int getScheme() {
        return Palette.colorScheme;
    }

    public static void setScheme(int num) {
        Palette.colorScheme = num;
    }

    public static Color MapColor(double value) {
        if (Palette.getScheme() == 1) {
            return Scheme1(value);
        } else if (Palette.getScheme() == 2) {
            return Scheme2(value);
        } else if (Palette.getScheme() == 3) {
            return Scheme3(value);
        } else if (Palette.getScheme() == 4) {
            return Scheme4(value);
        }
        return Scheme1(value); // Default to Scheme1
    }

    private static double normalize(double value) {
        return value / Mandelbrot.getLimit();
    }

    private static Color Scheme1(double value) {
        if (value < 0)
            return Color.BLACK;
        double ratio = normalize(value);
        int r = (int) Math.min(255, Math.max(0, 255 * ratio));
        int g = (int) Math.min(255, Math.max(0, Math.sin(ratio * Math.PI) * 255));
        int b = (int) Math.min(255, Math.max(0, Math.cos(ratio * Math.PI) * 255));
        return new Color(r, g, b);
    }

    private static Color Scheme2(double value) {
        if (value < 0)
            return Color.BLACK;
        double ratio = normalize(value);
        int r = (int) Math.min(255, Math.max(0, Math.sin(ratio * Math.PI) * 255));
        int g = (int) Math.min(255, Math.max(0, Math.cos(ratio * Math.PI) * 255));
        int b = (int) Math.min(255, Math.max(0, 255 * ratio));
        return new Color(r, g, b);
    }

    private static Color Scheme3(double value) {
        if (value < 0)
            return Color.BLACK;
        double ratio = normalize(value);
        int r = (int) Math.min(255, Math.max(0, Math.cos(ratio * Math.PI) * 255));
        int g = (int) Math.min(255, Math.max(0, 255 * ratio));
        int b = (int) Math.min(255, Math.max(0, Math.sin(ratio * Math.PI) * 255));
        return new Color(r, g, b);
    }

    private static Color Scheme4(double value) {
        if (value < 0)
            return Color.BLACK;
        double ratio = normalize(value);
        int r = (int) Math.min(255, Math.max(0, 255 * ratio));
        int g = (int) Math.min(255, Math.max(0, 255 * Math.sin(ratio * Math.PI / 2)));
        int b = 0;
        return new Color(r, g, b);
    }
}
