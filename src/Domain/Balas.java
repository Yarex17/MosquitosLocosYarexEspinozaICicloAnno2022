package Domain;

import java.awt.Color;
import java.awt.Graphics;

public class Balas {
	private double posX;
	private double posY;
	public Balas(double posX, double posY) {

		this.posX = posX;
		this.posY = posY;
	}
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}

	public void dibujar(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval((int)this.posX, (int)this.posY, 10, 10);
	}
}//fin class
