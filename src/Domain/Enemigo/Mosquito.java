package Domain.Enemigo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Domain.Personaje;

public  abstract class Mosquito implements Runnable{
	
	
	
	protected double posX, posY;
	protected int direccion;
	protected boolean hembra;
	protected boolean colision;
	protected int cantidadPicaduras;
	protected int valor;
	private Thread thread;
	private int cambio;
	protected int contador;
	protected BufferedImage imagenMosquito;
	
	
	public Mosquito(double posX, double posY) {
		this.cantidadPicaduras=0;

		this.posX = posX;
		this.posY = posY;
		this.direccion=1;
		this.colision=true;
		this.cambio=1;
		
		this.thread=new Thread(this);
		this.thread.start();
		
		this.contador=1;
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
 abstract void efecto(Personaje personaje);
 
 public  void colision(Personaje personaje) {
if (((this.posX <= personaje.getPosX() + 20) && (this.posX >= personaje.getPosX()))
				&& ((this.posY <= personaje.getPosY() + 20) && (this.posY >= personaje.getPosY()))) {
	if (!isColision()) {
		if (isHembra()) {
			setColision(true);
			danio(personaje);
			efecto(personaje);
			setColision(true);
	}
		setColision(true);
	}	
}else {
	setColision(false);
}

 }

 
 public  void movimiento() {
	 
		if (this.posY <= 0) {
			this.direccion = 1;
		}
		if (this.posY >= 560) {
			this.direccion = -1;
		}
		if (this.posX <= 0) {
			this.direccion = 1;
		}
		if (this.posX >= 760) {
			this.direccion = -1;
		}
		
switch (getCambio()) {
		
		case 1:
			 this.posY += 0.5 * this.direccion;
			break;
		case 2:
			 this.posY += 0.5 * this.direccion;
			 this.posX += 0.5 * this.direccion;
			break;
		case 3:
			
			 this.posX += 0.5 * this.direccion;
			break;
		case 4:
			 this.posY += 0.5 * this.direccion;
			 this.posX += 0.5 * this.direccion;
			break;

		default:
			break;
		} 
 }
 public void cambiarDireccion() {
	setCambio((int)(Math.random()*4+1));

}

 @Override
public void run() {
	 
while (true) {
	cambiarDireccion();
	
	try {
		this.thread.sleep(1500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}


public void dibujar(Graphics g) {
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
	
public int getCambio() {
		return cambio;
	}
	public void setCambio(int cambio) {
		this.cambio = cambio;
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
	
	public int getCantidadPicaduras() {
		return cantidadPicaduras;
	}
	public void setCantidadPicaduras(int cantidadPicaduras) {
		this.cantidadPicaduras = cantidadPicaduras;
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
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}

	
	
}
