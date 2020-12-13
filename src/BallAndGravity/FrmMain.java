/*
 * 
 */
package BallAndGravity;

import java.awt.Color;
import javax.swing.JFrame;

/**
 * @author EdsonPaulo
 */
public class FrmMain extends JFrame {

    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_HEIGHT = 500;

    public FrmMain() throws Exception {
        super("Ball and Gravity");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT + 10);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);

        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new FrmMain();
    }
}
