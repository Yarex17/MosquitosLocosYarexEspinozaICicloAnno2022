package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.text.html.parser.Entity;

import Domain.Enemigo.Mosquito;

public class Bala {
	
	private double inicioX, inicioY, finalX, finalY, pendiente, recta, velocidadDesplasamiento,rango;
	protected BufferedImage imagen;
	public Bala(double inicioX, double inicioY, double finalX, double finalY) {
		this.velocidadDesplasamiento = 2;
		this.rango=50000.00;
		this.inicioX = inicioX;
		this.inicioY = inicioY;
		this.finalX = finalX;
		this.finalY = finalY;
		this.pendiente = (this.finalY - this.inicioY) / (this.finalX - this.inicioX);
		
		this.recta = (this.inicioY - (this.pendiente * this.inicioX));
		try {
			this.imagen=ImageIO.read(getClass().getResourceAsStream("/Assets/Bala.png"));
//https://www.flaticon.es/icono-gratis/nube-de-co2_2893005?term=nube%20%20verde&related_id=2893005
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean colision(Mosquito mosquito) {

		if (((this.inicioX <= mosquito.getPosX() + 20) && (this.inicioX >= mosquito.getPosX()))
				&& ((this.inicioY <= mosquito.getPosY() + 20) && (this.inicioY >= mosquito.getPosY()))) {
			return true;
		}
		return false;
	} // colision
	
	
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

		

	} // mover
	

	

	public void dibujar(Graphics g) {

		g.drawImage(this.imagen, (int) this.inicioX, (int) this.inicioY, null);

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
