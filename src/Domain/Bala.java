package Domain;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.text.html.parser.Entity;

import Domain.Enemigo.Mosquito;

public class Bala {
	private double posXOrigen;
	private double posYOrigen;
	
	private double posXFinal;
	private double posYFinal;
	
	private double pendiente;
	private double recta;
	private double velocidad;
	
	public Bala(double posXOriguen, double posYOriguen,double posXFinal,double posYFinal) {

		this.posXOrigen = posXOriguen;
		this.posYOrigen = posYOriguen;
		this.posXFinal=posXFinal;
		this.posYFinal=posXFinal;
		this.pendiente=(this.posYFinal-this.posYOrigen)/(this.posXFinal-this.posXOrigen);
		this.recta=(this.posYOrigen-(this.pendiente*this.posXOrigen));
		this.velocidad=2;
	}
	public boolean collision(Mosquito mosquito) {

		if (((this.posXOrigen <= mosquito.getPosX() + 40) && (this.posXOrigen >= mosquito.getPosX()))
				&& ((this.posYOrigen <= mosquito.getPosY() + 40) && (this.posYOrigen >= mosquito.getPosY()))) {
			return true;
		}
		return false;
	} // collision
	public void mover() {

		this.posYOrigen = pendiente * this.posXOrigen + recta;

		if (this.posXOrigen >= this.posXFinal) {
			this.posXOrigen -= this.velocidad;
			this.posXFinal -= this.velocidad;
		}
		if (this.posXOrigen <= this.posXFinal) {
			this.posXOrigen += this.velocidad;
			this.posXFinal += this.velocidad;
		}

	} // move


	public void dibujar(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval((int)this.posXOrigen,(int)this.posYOrigen, 10, 10);
	}
	public double getPosXOrigen() {
		return posXOrigen;
	}
	public void setPosXOrigen(double posXOrigen) {
		this.posXOrigen = posXOrigen;
	}
	public double getPosYOrigen() {
		return posYOrigen;
	}
	public void setPosYOrigen(double posYOrigen) {
		this.posYOrigen = posYOrigen;
	}
	
	
}//fin class
