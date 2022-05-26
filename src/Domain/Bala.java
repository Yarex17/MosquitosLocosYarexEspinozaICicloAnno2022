package Domain;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.text.html.parser.Entity;

import Domain.Enemigo.Mosquito;

public class Bala {
	private double inicioX, inicioY, finalX, finalY, pendiente, recta, velocidadDesplasamiento,rango;
	public Bala(double inicioX, double inicioY, double finalX, double finalY) {
		this.velocidadDesplasamiento = 2;
		this.rango=50000.00;
		this.inicioX = inicioX;
		this.inicioY = inicioY;
		this.finalX = finalX;
		this.finalY = finalY;
		this.pendiente = (this.finalY - this.inicioY) / (this.finalX - this.inicioX);
		
		this.recta = (this.inicioY - (this.pendiente * this.inicioX));
	
	}
	public boolean collision(Mosquito mosquito) {

		if (((this.inicioX <= mosquito.getPosX() + 40) && (this.inicioX >= mosquito.getPosX()))
				&& ((this.inicioY <= mosquito.getPosY() + 40) && (this.inicioY >= mosquito.getPosY()))) {
			return true;
		}
		return false;
	} // collision
	public void mover() {

	this.inicioY = pendiente * this.inicioX + recta;

	if (this.inicioX >= this.finalX) {
		this.inicioX -= this.velocidadDesplasamiento;
		this.finalX -= this.velocidadDesplasamiento;
	}
	if (this.inicioX <= this.finalX) {
		this.inicioX += this.velocidadDesplasamiento;
		this.finalX += this.velocidadDesplasamiento;
	}

		

	} // move
public boolean Rango(Mosquito mosquito) {
	double rango=((mosquito.getPosX()-this.inicioX)*(mosquito.getPosX()-this.inicioX)) + ((mosquito.getPosY()-this.inicioY)*(mosquito.getPosY()-this.inicioY)) ;
	if (rango<=this.rango) {
		return true;
	}else {
		return false;
	}
	
}
	public void dibujar(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval((int) this.inicioX, (int) this.inicioY, 10, 10);
	}
	public double getPosX() {
		return inicioX;
	}

	public void setPosX(double posX) {
		this.inicioX = posX;
	}

	public double getPosY() {
		return inicioY;
	}

	public void setPosY(double posY) {
		this.inicioY = posY;
	}
	
	
}//fin class
