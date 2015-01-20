import java.awt.Color;
import java.awt.Graphics2D;

public class Ball {
	int x = 250;
	int y = 200;
	int vx = -3;
	int vy = 5;
	private static final int RADIUS = 20;
	private GameOverListener gameOverListener;
	public Ball(GameOverListener gameOverListener)
	{
		this.gameOverListener = gameOverListener;
	}
	protected void draw(Graphics2D g) {
		g.fillOval(x, y, RADIUS, RADIUS);
	}

	protected void clear(Graphics2D g) {
		g.fillRect(x - RADIUS - 10, y - RADIUS - 10, (RADIUS + 10) * 2,
				(RADIUS + 10) * 2);
	}

	protected void updateP(int delta, Paddle paddle) {
		x = x+ (vx * delta) / 15;
		y = y + (vy * delta) / 15;
		
		
		checkWallCollision();
		checkPaddleCollision(paddle);

	}

	private void checkPaddleCollision(Paddle paddle) {
		
		if (y + RADIUS >= paddle.y && y - RADIUS <= paddle.y + paddle.HEIGHT
				&& x + RADIUS >= paddle.x
				&& x - RADIUS <= paddle.x + paddle.WIDTH) {
			if(y <= paddle.y - (paddle.HEIGHT/2))
			{
				vy = -vy;
			}

				

				if(x <= paddle.x - (paddle.WIDTH/2)){
				vx = -vx;
			}
				  //Hit was on left

				if(x >= paddle.x + (paddle.WIDTH/2))
				{
					vx = -vx;
				}
				  //Hit was on right
		}

	}

	private void checkWallCollision() {
		if (x < 0) {
			vx = -vx;
		} else if (x + RADIUS > Game.WIDTH) {
			vx = -vx;
		}
		if (y < 0) {
			vy = -vy;
		} else if (y + RADIUS > Game.HEIGHT) {
			gameOverListener.gameOver();
		}
	}
}
