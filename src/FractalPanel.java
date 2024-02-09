import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import MathObjects.Complex;

public class FractalPanel extends JPanel implements KeyListener, MouseListener {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 800;
    private static final int DEFAULT_ITERATION_LIMIT = 1000;

    private View view;
    private Palette colors;
    private Complex topLeft, bottomRight;
    private int colorScheme = 0;
    private int iterationLimit = DEFAULT_ITERATION_LIMIT;

    public FractalPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        addKeyListener(this);
        addMouseListener(this);

        view = new View(WIDTH, HEIGHT);
        colors = new Palette();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        colors.setScheme(colorScheme);
        Mandelbrot.setLimit(iterationLimit);

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                g.setColor(colors.mapColor(Mandelbrot.testPoint(view.translate(x, y))));
                g.fillRect(x, y, 1, 1);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        topLeft = view.translate(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        bottomRight = view.translate(e.getX(), e.getY());
        view.setComplexCorners(topLeft, bottomRight);
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_1:
                colorScheme = 1;
                break;
            case KeyEvent.VK_2:
                colorScheme = 2;
                break;
            case KeyEvent.VK_3:
                colorScheme = 3;
                break;
            case KeyEvent.VK_4:
                colorScheme = 4;
                break;
            case KeyEvent.VK_R:
                view.setComplexCorners(new Complex(-2, 1), new Complex(2, -1));
                break;
            case KeyEvent.VK_SPACE:
                saveImage();
                break;
        }

        repaint();
    }

    private void saveImage() {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        paintComponent(g2d);
        g2d.dispose();

        try {
            File outputFile = new File("fractal_image.png");
            ImageIO.write(image, "png", outputFile);
            System.out.println("Image saved as " + outputFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
