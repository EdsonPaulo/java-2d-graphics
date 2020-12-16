/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BallAndGravity;

import IsraelFlag.Flag;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author EdsonPaulo
 */
public class Ball extends JPanel implements Runnable  {

    private final int BALL_SIZE = 50;
    private int ballPositionX = 100;
    private int ballPositiony = 100;
    private double ballVerticalSpeed = 30;

    private final double gravity = 1;
    private final double ballPressure = 0.1;
    private final double arResistance = 0.00001;
    
       public Ball() throws Exception {
        Thread mainThread = new Thread(this);
        mainThread.start();

        setBounds(0, 0, 700, 500);
        setVisible(true);
    }

    public void drawBall(Graphics2D g2D) {
        g2D.setColor(Color.red);
        g2D.fillOval(ballPositionX, ballPositiony, BALL_SIZE, BALL_SIZE);
        applyGravity();
        keepOnScreenBounds();
    }

    /// HANDLING BALL ON VERTICAL DIRECTION (Y)
    private void applyGravity() {
        ballVerticalSpeed += gravity;
        ballPositiony += ballVerticalSpeed;
        ballVerticalSpeed -= (ballVerticalSpeed * arResistance);
    }

    public void makeBounceBottom(int surface) {
        ballPositiony = surface - (BALL_SIZE / 2);
        ballVerticalSpeed *= -1;
        ballVerticalSpeed -= (ballVerticalSpeed * ballPressure);
    }

    public void makeBounceTop(int surface) {
        ballPositiony = surface + (BALL_SIZE / 2);
        ballVerticalSpeed *= -1;
        ballVerticalSpeed -= (ballVerticalSpeed * ballPressure);
    }
    

    // keep ball in the screen
    private void keepOnScreenBounds() {
        if (ballPositiony + (BALL_SIZE / 2) > 500) {
            makeBounceBottom(500);
        }
        if (ballPositiony - (BALL_SIZE / 2) < 0) {
            makeBounceTop(0);
        }
    }
    
      @Override
    public void run() {
         while (true) {
            try {
                repaint();
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Flag.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics defaultGraphics) {
        super.paintComponent(defaultGraphics);

        Graphics2D g2D = (Graphics2D) defaultGraphics.create();
        this.drawBall(g2D);
    }

    public int getBallPositionX() {
        return ballPositionX;
    }

    public void setBallPositionX(int ballPositionX) {
        this.ballPositionX = ballPositionX;
    }

    public int getBallPositiony() {
        return ballPositiony;
    }

    public void setBallPositiony(int ballPositiony) {
        this.ballPositiony = ballPositiony;
    }

    public double getBallVerticalSpeed() {
        return ballVerticalSpeed;
    }

    public void setBallVerticalSpeed(double ballVerticalSpeed) {
        this.ballVerticalSpeed = ballVerticalSpeed;
    }


    public int getBALL_SIZE() {
        return BALL_SIZE;
    }

  
}
