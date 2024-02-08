import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import MathObjects.Complex;

public class FractalPanel extends JPanel implements KeyListener, MouseListener {
    int width = 1000;
    int height = 800;
    int iterationLimit = 1000;
    int colorScheme = 0;
    int zoomScale = 10;
    View view = new View(width, height);
    Palette colors = new Palette();

    public FractalPanel() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        Mandelbrot.setLimit(iterationLimit);
        colors.setScheme(colorScheme);
        addKeyListener(this);
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                g.setColor(colors.MapColor(Mandelbrot.testPoint(view.translate(x, y))));
                g.fillRect(x, y, 1, 1);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Calculate the new complex corners based on the click position and zoom scale
        Complex topLeft = view.translate(e.getX() - width / (2 * zoomScale), e.getY() - height / (2 * zoomScale));
        Complex bottomRight = view.translate(e.getX() + width / (2 * zoomScale), e.getY() + height / (2 * zoomScale));
        
        // Set the new complex corners
        view.setComplexCorners(topLeft, bottomRight);
        
        // Update the iteration limit based on the zoom scale
        iterationLimit *= zoomScale*zoomScale;
        
        // Repaint the panel
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_P){
            colorScheme ++;
            colorScheme %= 5;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}