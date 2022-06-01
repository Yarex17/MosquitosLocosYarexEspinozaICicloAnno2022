package Domain.Criadero;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import Domain.Huevo;
import Domain.Personaje;
import Domain.Enemigo.Mosquito;

public abstract class Criadero extends Thread {
	private ArrayList<Huevo> huevos;
	protected double posX, posY;
	protected int valor;
	private Thread thread;
	private long espera;
	private int  contadorColocadorHuevos;
	private int cantidadHuevos;
	private int tiempo;
	private boolean primerMosquito;
	private Mosquito mosquito;
	public Criadero() {
		this.huevos=new ArrayList<Huevo>();
		this.huevos.add(new Huevo(10));
		this.huevos.add(new Huevo(20));
		this.huevos.add(new Huevo(30));
		this.posX = Math.random()*760;
		this.posY = Math.random()*560;

	}

	public abstract Mosquito generaMosquito();
	public abstract void dibujar(Graphics g);

	public  void generarMosquitos(ArrayList<Mosquito> mosquitos) {
		
		for (int i = 0; i < this.huevos.size(); i++) {
		
			if (this.huevos.get(i).isEclosion()) {
				
				this.mosquito = generaMosquito();
				mosquitos.add(mosquito);
				if (primerMosquito && !this.mosquito.isHembra()) {
					this.mosquito.setHembra(true);
				}
				if (this.mosquito.isHembra()) {
					for (int j = 0; j <(int)(Math.random()*4+2); j++) {
						this.huevos.add(new Huevo());
					}
				}
				this.huevos.remove(i);
			}
			
		}
	}
	
	
	
	public int getContadorColocacion() {
		return contadorColocadorHuevos;
	}

	public void setContadorColocacion(int contadorColocacion) {
		this.contadorColocadorHuevos = contadorColocacion;
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

	public int getContadorColocadorHuevos() {
		return contadorColocadorHuevos;
	}

	public void setContadorColocadorHuevos(int contadorColocadorHuevos) {
		this.contadorColocadorHuevos = contadorColocadorHuevos;
	}

	public int getCantidadHuevos() {
		return cantidadHuevos;
	}

	public void setCantidadHuevos(int cantidadHuevos) {
		this.cantidadHuevos = cantidadHuevos;
	}

	
	
	}
