package Domain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Domain.Criadero.Criadero;
import Domain.Enemigo.Mosquito;

public class Personaje {

	private int posX;
	private int posY;
	private int vida;
	
	private int cantidaBalas;
	private double rango;
	private BufferedImage imagen;
	
	public Personaje(int posX, int posY) {
		this.posX=posX;
		this.posY=posY;
		this.vida=100;
		this.cantidaBalas=10;
		this.rango=20000.00;
		try {
			this.imagen=ImageIO.read(getClass().getResourceAsStream("/Assets/Exterminador.png"));
			
			//https://www.flaticon.es/icono-premium/exterminador_4295657?term=exterminador&page=1&position=12&page=1&position=12&related_id=4295657&origin=search		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // constructor	
	
	public Bala disparar(int posX,int posY) {
		if(this.cantidaBalas>0) {
			this.cantidaBalas=this.cantidaBalas-1;
			return new Bala(this.posX+15, this.posY+15,posX,posY);
		}
		return null;
	}
	public boolean colision(int x,int y){
if (((this.posX < x+ 40 && this.posX >= x)
				|| (this.posX + 40 > x && this.posX <= x))
				&& (this.posY < y + 40 && this.posY >= y
						|| (this.posY + 40 > y && this.posY <= y))) {
	return true;
}else {
	return false;
}
	}
	public Bala disparar() {
		if(this.cantidaBalas>0) {
			this.cantidaBalas=this.cantidaBalas-1;
			return new Bala(this.posX+15, this.posY+15,posX,posY);
		}
		return null;
	} // disparar
	public boolean Rango(Mosquito mosquito) {
		double rango=((mosquito.getPosX()-this.posX)*(mosquito.getPosX()-this.posX)) 
				+ ((mosquito.getPosY()-this.posY)*(mosquito.getPosY()-this.posY)) ;
		if (rango<=this.rango) {
			
			return true;
		}else {
			return false;
		}
		
	}
	public boolean Rango(Criadero criadero) {
		double rango=((criadero.getPosX()-this.posX)*(criadero.getPosX()-this.posX)) 
				+ ((criadero.getPosY()-this.posY)*(criadero.getPosY()-this.posY)) ;
		if (rango<=this.rango) {
			
			return true;
		}else {
			return false;
		}
		
	}
	public void dibujar(Graphics g) {
		
		g.drawImage(this.imagen, (int) this.posX, (int) this.posY, null);
		g.setColor(Color.white);	
        g.setFont(new Font("Times New Roman", Font.BOLD, 15));
        g.drawString("Vida:"+this.vida+"",5, 20);
		g.drawString("Balas :"+this.cantidaBalas+"",5, 40);
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

