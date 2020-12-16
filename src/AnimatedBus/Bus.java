/*
 * 
 */
package AnimatedBus;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 * @author EdsonPaulo
 */
public class Bus extends JPanel implements Runnable {

    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_HEIGHT = 500;

    private int blockWidth = 400;
    private int blockHeight = 200;

    private int blockPositionX = 100;
    private int blockPositionY = 400;
    private int blockDirection = 10;

    private int personPositionX = blockPositionX + 25;
    private int personPositionY = blockPositionY + 15;
    private int personDirection = 10;

    public Bus() throws Exception {
        Thread mainThread = new Thread(this);
        mainThread.start();

        setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                //Invert block direction
                if (blockPositionX >= (1024 - blockWidth) || blockPositionX <= 0) {
                    blockDirection *= -1;
                }
                if (personPositionX >= (blockPositionX + 20 - 5) || personPositionX <= (blockPositionY + 10 + 80 - personPositionX)) {
                    personDirection *= -1;
                }

                blockPositionX += blockDirection;
                personPositionX += personDirection;
                repaint();
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void paintComponent(Graphics defaultGraphics) {
        super.paintComponent(defaultGraphics);

        Graphics2D g2D = (Graphics2D) defaultGraphics.create();
        g2D.setColor(Color.RED);
        g2D.fillRoundRect(blockPositionX, blockPositionY, blockWidth, blockHeight, 15, 15);

        g2D.setColor(Color.lightGray);
        g2D.fillRoundRect(blockPositionX + 20, blockPositionY + 10, 80, 80, 15, 15);
        g2D.fillRoundRect(blockPositionX + 120, blockPositionY + 10, 80, 80, 15, 15);

        g2D.fillRoundRect(blockPositionX + blockWidth - 120, blockPositionY + 10, 80, 80, 15, 15);

        g2D.setColor(Color.black);
        g2D.fillOval(blockPositionX + 20, blockPositionY + blockHeight - 30, 60, 60);

        g2D.fillOval(blockPositionX + blockWidth - 80, blockPositionY + blockHeight - 30, 60, 60);

        g2D.setColor(Color.ORANGE);
        g2D.fillOval(personPositionX, personPositionY, 40, 40);

    }
}
