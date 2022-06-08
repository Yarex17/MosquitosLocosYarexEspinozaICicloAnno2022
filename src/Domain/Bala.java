package Domain;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Domain.Criadero.Criadero;
import Domain.Enemigo.Mosquito;

public class Bala {

	private double inicioX, inicioY, finalX, finalY, pendiente, recta, velocidadDesplasamiento, rango;
	protected BufferedImage imagen;

	public Bala(double inicioX, double inicioY, double finalX, double finalY) {
		this.velocidadDesplasamiento = 2;
		this.rango = 50000.00;
		this.inicioX = inicioX;
		this.inicioY = inicioY;
		this.finalX = finalX;
		this.finalY = finalY;

		this.pendiente = (this.finalY - this.inicioY) / (this.finalX - this.inicioX);

		this.recta = (this.inicioY - (this.pendiente * this.inicioX));

		try {
			this.imagen = ImageIO.read(getClass().getResourceAsStream("/Assets/Bala.png"));
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

	public boolean colision(Criadero criadero) {

		if (((this.inicioX <= criadero.getPosX() + 40) && (this.inicioX >= criadero.getPosX()))
				&& ((this.inicioY <= criadero.getPosY() + 40) && (this.inicioY >= criadero.getPosY()))) {
			return true;
		}
		return false;
	} // colision

	public boolean trayectoria(Criadero criadero) {
		double Y = 0;
		double X = 0;
		Y = pendiente * criadero.getPosX() + recta;
		X = (Y - recta) / pendiente;
		if ((Y > criadero.getPosY() && Y < criadero.getPosY() + 40)) {
			return true;
		}else {
			return false;
		}
	}

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

	public double getInicioX() {
		return inicioX;
	}

	public void setInicioX(double inicioX) {
		this.inicioX = inicioX;
	}

	public double getInicioY() {
		return inicioY;
	}

	public void setInicioY(double inicioY) {
		this.inicioY = inicioY;
	}

	public double getFinalX() {
		return finalX;
	}

	public void setFinalX(double finalX) {
		this.finalX = finalX;
	}

	public double getFinalY() {
		return finalY;
	}

	public void setFinalY(double finalY) {
		this.finalY = finalY;
	}

	public double getPendiente() {
		return pendiente;
	}

	public void setPendiente(double pendiente) {
		this.pendiente = pendiente;
	}

	public double getRecta() {
		return recta;
	}

	public void setRecta(double recta) {
		this.recta = recta;
	}

	public double getVelocidadDesplasamiento() {
		return velocidadDesplasamiento;
	}

	public void setVelocidadDesplasamiento(double velocidadDesplasamiento) {
		this.velocidadDesplasamiento = velocidadDesplasamiento;
	}

	public double getRango() {
		return rango;
	}

	public void setRango(double rango) {
		this.rango = rango;
	}

}// fin class
