package bouncingBall;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

//the ball set

public class BallSet extends JComponent
{
    private ArrayList<Ball> balls = new ArrayList<Ball>();
    //add new ball
    public void add(Ball ball){
        balls.add(ball);
    }
    //draw the balls
    public void paint(Graphics graph){
        Graphics2D graph2 = (Graphics2D) graph;
        for (Ball ball : balls)
            ball.draw(graph2);
   }
}