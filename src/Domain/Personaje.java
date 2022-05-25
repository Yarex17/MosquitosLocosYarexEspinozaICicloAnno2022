package Domain;

import java.awt.Color;
import java.awt.Graphics;

public class Personaje {

	private int posX;
	private int posY;
	private int vida;
	
	private int cantidaBalas;
	
	public Personaje() {
		this.posX=0;
		this.posY=0;
		this.vida=100;
		this.cantidaBalas=10;
	} // constructor
	public Bala disparar(int posX,int posY) {
		if(this.cantidaBalas>0) {
			this.cantidaBalas=this.cantidaBalas-1;
			return new Bala(this.posX, this.posY)
		}
	}
	
	public Personaje(int posX, int posY) {
		this.posX=posX;
		this.posY=posY;
		this.vida=100;
		this.cantidaBalas=10;
	} // constructor	
	
//	public Bala disparar() {
//		if(this.cantidaBalas>0) {
//			this.cantidaBalas=this.cantidaBalas-1;
//			return new Bala(this.posX+40, this.posY+15);
//		}
//		return null;
//	} // disparar

	public void dibujar(Graphics g) {
		g.setColor(new Color(221, 27, 18));
		g.fillOval(this.posX, this.posY, 40, 40);
		g.setColor(Color.white);
		g.drawString(this.vida+"", this.posX+10, this.posY+25);
	} // dibujar
	
	public void atacar() {}
	
	public void moverDerecha() {
		this.posX+=4;
	}
	
	public void moverIzquierda() {
		this.posX-=4;
	}
	
	public void moverArriba() {
		this.posY-=4;
	}
	
	public void moverAbajo() {
		this.posY+=4;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	
} // fin clase

