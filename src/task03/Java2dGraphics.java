/*
 * 
 */
package task03;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author EdsonPaulo
 */
public class Java2dGraphics extends JPanel implements Runnable {

    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_HEIGHT = 500;

    private final int FLAG_BAR_HEIGHT = 100;
    private final int FLAG_BAR_WIDTH = 700;

    private int currentStarAngle = 0;

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        JFrame window = new JFrame();
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT + 10);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Java2dGraphics mainPane = new Java2dGraphics();
        mainPane.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        mainPane.setBackground(Color.WHITE);
        mainPane.setVisible(true);

        window.getContentPane().add(mainPane);
        window.setVisible(true);
    }

    public Java2dGraphics() throws Exception {
        Thread mainThread = new Thread(this);
        mainThread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                currentStarAngle += 20;
                repaint();
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                Logger.getLogger(Java2dGraphics.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void paintComponent(Graphics defaultGraphics) {
        super.paintComponent(defaultGraphics);

        Graphics2D g2D = (Graphics2D) defaultGraphics.create();
        g2D.setColor(Color.BLUE);
        g2D.fillRect(0, 0, FLAG_BAR_WIDTH, FLAG_BAR_HEIGHT);

        g2D.setColor(Color.BLUE);
        g2D.fillRect(0, WINDOW_HEIGHT - FLAG_BAR_HEIGHT, FLAG_BAR_WIDTH, FLAG_BAR_HEIGHT);

        g2D.rotate(Math.toRadians(currentStarAngle), WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2);

        g2D.setStroke(new BasicStroke(7));

        int[] starXPoints = {WINDOW_WIDTH / 2 - 50, WINDOW_WIDTH / 2, WINDOW_WIDTH / 2 + 50};

        int[] starYPoints = {WINDOW_HEIGHT / 2 - 35, WINDOW_HEIGHT / 2 + 65, WINDOW_HEIGHT / 2 - 35};
        g2D.drawPolygon(starXPoints, starYPoints, 3);

        int[] star2YPoints = {WINDOW_HEIGHT / 2 + 35, WINDOW_HEIGHT / 2 - 65, WINDOW_HEIGHT / 2 + 35};
        g2D.drawPolygon(starXPoints, star2YPoints, 3);
    }
}
