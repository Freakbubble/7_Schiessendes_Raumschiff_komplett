package Raumschiff;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Player extends GameObject {
	// Variablen
	int shotsize = 2;
	int shotspeed = -4;
	private boolean playerMoveLeft;
	private boolean playerMoveRight;
	private boolean playerMoveUp;
	private boolean playerMoveDown;
	private double playerSpeedX;
	private double playerSpeedY;
	private double playerx;
	private double playery;

	public Player(Coordinate objectPosition, double width, double height, double movingAngle, double movingDistance) {

		// TODO Auto-generated constructor stub
		super(objectPosition, width, height);
		setMovingAngle(movingAngle); // Achtung der Winkel wird im Bogenma� angegeben!!
		setMovingDistance(movingDistance);
		playerMoveLeft = false;
		playerMoveRight = false;
		playerMoveUp = false;
		playerMoveDown = false;
		playerSpeedX = 3;
		playerSpeedY = 3;

	}

	@Override
	public void makeMove() {
		// TODO Auto-generated method stub
		super.makeMove();
	}

	public void setPlayerMoveUp(boolean newPlayerUp) {
		playerMoveUp = newPlayerUp;
	}

	public void setPlayerMoveDown(boolean newPlayerDown) {
		playerMoveDown = newPlayerDown;
	}

	public void setPlayerMoveRight(boolean newPlayerRight) {
		playerMoveRight = newPlayerRight;
	}

	public void setPlayerMoveLeft(boolean newPlayerLeft) {
		playerMoveLeft = newPlayerLeft;
	}

	public boolean playerMoveUp() {
		return this.playerMoveUp;
	}

	public boolean playerMoveDown() {
		return this.playerMoveDown;
	}

	public boolean playerMoveRight() {
		return this.playerMoveRight;
	}

	public boolean playerMoveLeft() {
		return this.playerMoveLeft;
	}

	public Shot generateShot() {
		Shot shot = new Shot(
				new Coordinate(this.getObjectPosition().getX() - shotsize / 2, this.getObjectPosition().getY()),
				shotsize, shotsize, Math.PI / 2, shotspeed);
		return shot;
	}

	public void paintMe(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		int x_pos = (int) this.getObjectPosition().getX();
		int y_pos = (int) this.getObjectPosition().getY();
		int[] x_poly = { x_pos, x_pos - 10, x_pos, x_pos + 10 };
		int[] y_poly = { y_pos, y_pos + 15, y_pos + 10, y_pos + 15 };
		g2d.fillPolygon(x_poly, y_poly, 4); // Zeichnung beginnt an der Spitze des Raumschiffs.
	}

}