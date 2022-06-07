package Domain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Domain.Criadero.Criadero;
import Domain.Enemigo.Mosquito;

public class Personaje extends Thread{

	private double posX;
	private double posY;
	private int vida;
	private int puntos;
	private int direccion;
	private int cantidaBalas;
	private double rango;
	private BufferedImage imagen;
	private double velocidad;
	
	private boolean colisionZika;
	private boolean colisionChinkunguya;
	
	private int picaduraDegue;
	private int picadurazika;
	
	private Thread thread;
	
	
	public Personaje(double posX, double posY) {
	
		this.colisionChinkunguya=false;
		this.colisionZika=false;
		this.picaduraDegue=0;
		 this.picadurazika=0;
		this.direccion=1;
		this.velocidad=8.0;
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
		this.thread=new Thread(this);
		this.thread.start();
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
			setCantidaBalas(10);
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
		if (this.posX<760) 
		this.posX+=getVelocidad()*getDireccion();
	}
	
	public void moverIzquierda() {
if (this.posX>0) 
		this.posX-=getVelocidad()*getDireccion();
	}
	
	public void moverArriba() {
		if (this.posY>0) 
		this.posY-=getVelocidad()*getDireccion();
	}
	
	public void moverAbajo() {
		if (this.posY<560) 
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

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Double velocidad) {
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

	public boolean isColisionZika() {
		return colisionZika;
	}

	public void setColisionZika(boolean colisionZika) {
		this.colisionZika = colisionZika;
	}

	public boolean isColisionChinkunguya() {
		return colisionChinkunguya;
	}

	public void setColisionChinkunguya(boolean colisionChinkunguya) {
		this.colisionChinkunguya = colisionChinkunguya;
	}

	public int getPicaduraDegue() {
		return picaduraDegue;
	}

	public void setPicaduraDegue(int picaduraDegue) {
		this.picaduraDegue = picaduraDegue;
	}

	public int getPicadurazika() {
		return picadurazika;
	}

	public void setPicadurazika(int picadurazika) {
		this.picadurazika = picadurazika;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(600);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (isColisionZika()) {
				
				try {
					setColisionZika(false);
					Thread.sleep(20000);
					setVelocidad(8.0);
		
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
							}
			
	
			if (isColisionChinkunguya()) {
				setColisionChinkunguya(false);
				try {
					
					Thread.sleep(10000);
					setDireccion(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
} // fin clase

