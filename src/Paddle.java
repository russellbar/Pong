import java.awt.Graphics2D;


public class Paddle {
	int x=250;
	int y=400;
	int v=0;
	protected static final int WIDTH = 50;
	protected static final int HEIGHT = 20;
protected void draw(Graphics2D g) {
g.fillRect(x, y, WIDTH, HEIGHT);	

}
protected void updateVelocity(int v){
	this.v = v;
}
protected void updateP(int delta){
	x=x+(v * delta)/100;
	if (x<0)
	{
		x = 0;
	}
	else if (x+WIDTH>Game.WIDTH)
	{
		x=Game.WIDTH-WIDTH;
	}
}
}
