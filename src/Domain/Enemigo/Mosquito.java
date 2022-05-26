package Domain.Enemigo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public  abstract class Mosquito {
	protected double posX, posY;
	protected int direccion;
	protected boolean genero;
	protected BufferedImage imagenMosquito;
	
	
	public Mosquito(double posX, double posY) {
		this.posX = posX;
		this.posY = posY;
		this.direccion=1;
		darGenero();
		try {
			this.imagenMosquito=ImageIO.read(getClass().getResourceAsStream("/Assets/Mosquito.png"));
			//https://www.flaticon.es/icono-gratis/mosquito_2865206?term=mosquito&page=1&position=2&page=1&position=2&related_id=2865206&origin=search
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 abstract void daño();
 abstract void efecto();
 public  void movimiento() {
	 this.posY += 1 * this.direccion;
		if (this.posY <= 0) {
			this.direccion = 1;
		}
		if (this.posY >= 560) {
			this.direccion = -1;
		}
 }
public void dibujar(Graphics g) {
	//g.drawRect((int) this.posX, (int) this.posY, 20, 20);
	g.drawImage(this.imagenMosquito, (int) this.posX, (int) this.posY, null);
}
 public void darGenero() {
	if (((int) Math.random()*1)==1) {
		setGenero(true);
	}else {
		setGenero(false);
	}
}
	public boolean isGenero() {
	return genero;
}
	
public void setGenero(boolean genero) {
	this.genero = genero;
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
	
}
