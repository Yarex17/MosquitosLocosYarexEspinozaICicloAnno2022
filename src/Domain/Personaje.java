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

	private double posX;
	private double posY;
	private int vida;
	private int puntos;
	private int direccion;
	private int cantidaBalas;
	private double rango;
	private BufferedImage imagen;
	private int velocidad;
	public Personaje(double posX, double posY) {
		this.direccion=1;
		this.velocidad=6;
		this.posX=posX;
		this.posY=posY;
		this.vida=100;
		this.cantidaBalas=10000;
		this.rango=20000.00;
		try { 
			this.imagen=ImageIO.read(getClass().getResourceAsStream("/Assets/Exterminador.png"));
			
			//https://www.flaticon.es/icono-premium/exterminador_4295657?term=exterminador&page=1&position=12&page=1&position=12&related_id=4295657&origin=search		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // constructor	
	
	public int getCantidaBalas() {
		return cantidaBalas;
	}

	public void setCantidaBalas(int cantidaBalas) {
		this.cantidaBalas = cantidaBalas;
	}

	public double getRango() {
		return rango;
	}

	public void setRango(double rango) {
		this.rango = rango;
	}

	public Bala disparar(int posX,int posY) {
		if(this.cantidaBalas>0) {
			this.cantidaBalas=this.cantidaBalas-1;
			return new Bala(this.posX+15, this.posY+15,posX,posY);
		}
		return null;
	}
	public boolean colision(Cargador cargador){
		if (((this.posX < cargador.getPosX() + 40 && this.posX >= cargador.getPosX())
				|| (this.posX + 40 > cargador.getPosX() && this.posX <= cargador.getPosX()))
				&& (this.posY < cargador.getPosY() + 40 && this.posY >= cargador.getPosY()
						|| (this.posY + 40 > cargador.getPosY() && this.posY <= cargador.getPosY()))) {
			return true;
		} else {
			return false;
		}
	}

	public boolean Rango(Mosquito mosquito) {//Calcula si un mosquito esta dentro del rango de disparo 
		double rango=((mosquito.getPosX()-this.posX)*(mosquito.getPosX()-this.posX)) 
				+ ((mosquito.getPosY()-this.posY)*(mosquito.getPosY()-this.posY)) ;
		if (rango<=this.rango) {
			
			return true;
		}else {
			return false;
		}
		
	}
	public boolean Rango(Criadero criadero) {//Calcula si un criadero esta dentro del rango de disparo 
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
		g.drawString("Puntos :"+getPuntos()+"",5, 60);
	} // dibujar
	

	public void moverDerecha() {
		this.posX+=getVelocidad()*getDireccion();
	}
	
	public void moverIzquierda() {
		this.posX-=getVelocidad()*getDireccion();
	}
	
	public void moverArriba() {
		this.posY-=getVelocidad()*getDireccion();
	}
	
	public void moverAbajo() {
		this.posY+=getVelocidad()*getDireccion();
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

	public int getVida() {
		return vida;
	}
 
	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	
} // fin clase

