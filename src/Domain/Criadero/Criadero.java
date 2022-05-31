package Domain.Criadero;

import java.awt.Graphics;
import java.util.Iterator;

import Domain.Enemigo.Mosquito;

public abstract class Criadero  {
	protected double posX, posY;
	protected int valor;
	private Thread thread;
	private long espera;
	private int  contadorColocacion;
	public Criadero() {
		this.posX = Math.random()*760;
		this.posY = Math.random()*560;
		this.espera=6;//60000
		this.contadorColocacion=1;
	}

	public abstract Mosquito generaMosquito();
	public abstract void dibujar(Graphics g);

	public Mosquito generarMosquitos() {
		 
	Mosquito nuevoMosquito=generaMosquito();
			
			if (getContadorColocacion()>0) {
				setContadorColocacion(getContadorColocacion()-1);
				try {
					thread.sleep(espera);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (nuevoMosquito.isHembra()) {
		             setContadorColocacion(getContadorColocacion()+1);
					}
				return generaMosquito();
			}
			return null;
			
	
		
	}
	
	
	
	
	public int getContadorColocacion() {
		return contadorColocacion;
	}

	public void setContadorColocacion(int contadorColocacion) {
		this.contadorColocacion = contadorColocacion;
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

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	}
