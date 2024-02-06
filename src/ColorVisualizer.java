import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ColorVisualizer extends JPanel {

    private static final long serialVersionUID = 1L;
    public final int ITERATION_LIMIT = 500;
    public final int GRAPH_WIDTH = 1000;
    public final int LEFT_MARGIN = 50;

    public ColorVisualizer() {
        setPreferredSize(new Dimension(GRAPH_WIDTH + 100, 400));
        setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Palette q = new Palette();
        g.setColor(Color.white);
        g.drawString("0", 48, 365);
        g.drawString("" + ITERATION_LIMIT, GRAPH_WIDTH + LEFT_MARGIN, 365);
        g.drawString("0", 32, 305);
        g.drawString("255", 32, 45);

        double stepSize = (double) ITERATION_LIMIT / GRAPH_WIDTH;
        double testVal = 0;
        for (int x = 0; x < GRAPH_WIDTH; x++) {
            testVal += stepSize;
            Color c = q.MapColor(testVal);
            g.setColor(c);
            g.fillRect(x + LEFT_MARGIN, 300, 1, 50);
            g.setColor(Color.red);
            g.fillRect(x + LEFT_MARGIN, 300 - c.getRed(), 1, 1);
            g.setColor(Color.blue);
            g.fillRect(x + LEFT_MARGIN, 300 - c.getBlue(), 1, 1);
            g.setColor(Color.green);
            g.fillRect(x + LEFT_MARGIN, 300 - c.getGreen(), 1, 1);
        }
    }
}