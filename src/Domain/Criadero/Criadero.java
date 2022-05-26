package Domain.Criadero;

import java.awt.Graphics;

import Domain.Enemigo.Mosquito;

public abstract class Criadero {
	protected double posX, posY;
	
	public Criadero() {
		this.posX = Math.random()*760;
		this.posY = Math.random()*560;
	}

	public abstract Mosquito generaMosquitos();
	public abstract void dibujar(Graphics g);

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
	
	}
