
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Game implements KeyListener, GameOverListener{
	 Paddle paddle=new Paddle();
	 Ball ball = new Ball(this);
	 boolean gameover=false;
	 public static final int WIDTH = 500;
	 public static final int HEIGHT = 500;
	 static long lastLoopTime;
	 DrawingPanel panel=new DrawingPanel(WIDTH,HEIGHT);		
	 Graphics2D g=panel.getGraphics();
	public Game()
	{
		panel.addKeyListener(this);
		lastLoopTime = System.currentTimeMillis();
		while (!gameover){
			long delta = System.currentTimeMillis() - lastLoopTime;
			lastLoopTime = System.currentTimeMillis();
			g.setColor(Color.WHITE);
			paddle.draw(g);
			ball.clear(g);
			g.setColor(Color.BLACK);
			paddle.updateP((int) delta);
			ball.updateP((int) delta, paddle);
			//panel.clearWithoutRepaint();
			paddle.draw(g);
			ball.draw(g);
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
		{
		paddle.updateVelocity(30);
		// TODO Auto-generated method stub
		}
		else if (arg0.getKeyCode() == KeyEvent.VK_LEFT){
			paddle.updateVelocity(-30);
		}
		
		
		
	}
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		paddle.updateVelocity(0);
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameOver() {
		gameover = true;
	}

}
