package Domain.Enemigo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Domain.Personaje;

public  abstract class Mosquito {
	protected double posX, posY;
	protected int direccion;
	protected boolean hembra;
	protected boolean colision;
	protected int contidadPicaduras;
	protected int valor;
	
	protected BufferedImage imagenMosquito;
	
	
	public Mosquito(double posX, double posY) {
		this.posX = posX;
		this.posY = posY;
		this.direccion=1;
		this.colision=false;
		darGenero();
		try {
			this.imagenMosquito=ImageIO.read(getClass().getResourceAsStream("/Assets/Mosquito.png"));
			//https://www.flaticon.es/icono-gratis/mosquito_2865206?term=mosquito&page=1&position=2&page=1&position=2&related_id=2865206&origin=search
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 abstract void danio(Personaje personaje);
 abstract void efecto();
 
 public  void colision(Personaje personaje) {
if (((this.posX <= personaje.getPosX() + 20) && (this.posX >= personaje.getPosX()))
				&& ((this.posY <= personaje.getPosY() + 20) && (this.posY >= personaje.getPosY()))) {
	if (!isColision()) {
		if (isHembra()) {
			danio(personaje);
	}
		setColision(true);
	}	
}else {
	setColision(false);
}

 }
 
 
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
	g.drawString(isHembra()+"", (int) this.posX, (int) this.posY);
	g.drawImage(this.imagenMosquito, (int) this.posX, (int) this.posY, null);
}
public int getValor() {
	return valor;
}
public void setValor(int valor) {
	this.valor = valor;
}
 public void darGenero() {
	if ((int) (Math.random()*2+1)!=2) {
		setHembra(true);
	}else {
		setHembra(false);
	}
}
	public boolean isHembra() {
	return hembra;
}
	
public void setHembra(boolean genero) {
	this.hembra = genero;
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
	public int getContidadPicaduras() {
		return contidadPicaduras;
	}
	public void setContidadPicaduras(int contidadPicaduras) {
		this.contidadPicaduras = contidadPicaduras;
	}
	public int getDireccion() {
		return direccion;
	}
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	public boolean isColision() {
		return colision;
	}
	public void setColision(boolean colision) {
		this.colision = colision;
	}
	
	
}
