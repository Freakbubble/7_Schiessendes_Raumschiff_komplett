package Raumschiff;

//import java.awt.Graphics;
//import java.awt.Color;
//
//public class Shot{
//	private int x_pos;
//	private int y_pos;
//
//	private final int radius = 3;
//
//	public Shot(int x, int y)	{
//		x_pos = x;
//		y_pos = y;
//	}
//
//	public int getYPos(){
//		return y_pos;
//	}
//
//	public void moveShot(int speed){
//		y_pos += speed;
//	}
//
//	public void drawShot(Graphics g){
//		g.setColor(Color.yellow);
//		g.fillOval(x_pos, y_pos, radius, radius);
//	}
//	
//	
//}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Shot extends GameObject {
	private double mittelpunkt_x;
	private double mittelpunkt_y;

	public Shot(Coordinate objectPosition, double width, double height, double movingAngle, double movingDistance) {

		// TODO Auto-generated constructor stub
		super(objectPosition, width, height);
		setMovingAngle(movingAngle); // Achtung der Winkel wird im Bogenma� angegeben!!
		setMovingDistance(movingDistance);

	}

	@Override
	public void makeMove() {
		// TODO Auto-generated method stub
		super.makeMove();
	}
		
	// prueft, ob das Geschoss das Spielfeld verlassen hat	
	public boolean isOut(Dimension d) {

		if (getObjectPosition().getX() > 0 && getObjectPosition().getX() + this.getWidth() < d.getWidth()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	protected void paintMe(Graphics g) {
		// TODO Auto-generated method stub

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);

		Ellipse2D.Double shot = new Ellipse2D.Double(getObjectPosition().getX(), getObjectPosition().getY(), getWidth(),
				getHeight());

		g2d.draw(shot);
		g2d.fill(shot);
	}
}
