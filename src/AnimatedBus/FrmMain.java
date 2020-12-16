/*
 * 
 */
package AnimatedBus;

import java.awt.Color;
import javax.swing.JFrame;

/**
 * @author EdsonPaulo
 */
public class FrmMain extends JFrame {

    private static final int WINDOW_WIDTH = 1024;
    private static final int WINDOW_HEIGHT = 830;

    public FrmMain() throws Exception {
        super("Bus");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT + 10);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);

        Bus mainPane = new Bus();

        getContentPane().add(mainPane);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new FrmMain();
    }
}
