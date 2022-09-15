package bouncingBall;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class BounceFrame extends JFrame{
	private BallSet ballset;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	public BounceFrame() {
		setSize(WIDTH, HEIGHT);
		setTitle("Bouncing Ball");

		ballset = new BallSet();
     	add(ballset);

     	JPanel buttonPanel = new JPanel();
     	JButton button = new JButton("New Ball");
     	buttonPanel.add(button);
     	add(buttonPanel, BorderLayout.SOUTH);
     	
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        	    Ball ball = new Ball(WIDTH, HEIGHT);
        	    ballset.add(ball);
        	    Runnable run = new BallRunnable(ball, ballset);
        	    Thread t = new Thread(run);
        	    t.start();
            }
	    });
     	
   }
}