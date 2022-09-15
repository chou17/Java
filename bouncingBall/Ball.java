package bouncingBall;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import java.util.Random;


public class Ball{
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
	private double dy = 1;
	
	//random color
    Random rand = new Random();   
	float r = rand.nextFloat();
	float g = rand.nextFloat();
	float b = rand.nextFloat();
	Color randomColor = new Color(r, g, b);
	
	Ball (int Width, int Height) {
		Random random = new Random();
		//4 edges
		int border = random.nextInt(4);
		
		if(border == 0 ) {
			x = 0;
			y = random.nextInt(Height);
		}
		else if(border == 1){
			y = 0;
			x = random.nextInt(Width);
		}
		else if(border == 2){
			x = Width;
			y = random.nextInt(Height);
		}
		else {
			y = Height;
			x = random.nextInt(Width);
		}
	
		
	}
	

    //Moves the ball to the next position, if hits the edge, turn to opposite direction.
    public void move(Rectangle2D bounds){
        x += dx;
        y += dy;
    
        double maxX = bounds.getMaxX();
        double maxY = bounds.getMaxY();
        double minX = bounds.getMinX();
        double minY = bounds.getMinY();
        
        if (x < minX) {
        	x = 2*minX - x;
        	dx = -dx;
        }
        else if (x + XSIZE >= maxX){
            x = 2*(maxX - XSIZE) - x;
            dx = -dx;
        }
        else if (y < minY) {
        	y = 2*minY - y;
        	dy = -dy;
        }
            
        else if (y + YSIZE >= maxY){
            y = 2*(maxY - YSIZE) - y;
            dy = -dy;
        }
    }

	//draw the ball
	void draw(Graphics graph) {
		Graphics2D graph2D =  (Graphics2D) graph;
		Ellipse2D shape = new Ellipse2D.Double(x, y, XSIZE, YSIZE);
		graph2D.fill(shape);
		graph2D.setColor(randomColor);
        
    }
}