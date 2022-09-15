package bouncingBall;

class BallRunnable implements Runnable{
    private Ball ball;
    private BallSet ballset;
    public static final int DELAY = 5;
	
    public BallRunnable(Ball newball, BallSet balls){
      ball = newball;
      ballset = balls;
    }

    public void run(){
        try{
    	    while(true) {
                ball.move(ballset.getBounds());
                ballset.repaint();
                Thread.sleep(DELAY);
    	    }
        }
        catch (InterruptedException e){
        }
    }

}