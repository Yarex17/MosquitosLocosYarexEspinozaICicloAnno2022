package Domain.Criadero;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import Domain.Huevo;
import Domain.Personaje;
import Domain.Enemigo.Mosquito;

public abstract class Criadero extends Thread {
	private ArrayList<Huevo> huevos;
	protected double posX, posY;
	protected int valor;
	protected BufferedImage imagen;
	private boolean primerMosquito;
	private Mosquito mosquito;

	public Criadero() {
		this.huevos = new ArrayList<Huevo>();

		this.posX = Math.random() * 760;
		this.posY = Math.random() * 560;
		this.huevos.add(new Huevo(5, tipoMosquito()));
		this.huevos.add(new Huevo(10, tipoMosquito()));
		this.huevos.add(new Huevo(25, tipoMosquito()));

	}

	public abstract Mosquito tipoMosquito();

	public abstract void dibujar(Graphics g);

	public void generarMosquitos(ArrayList<Mosquito> mosquitos) {

		for (int i = 0; i < this.huevos.size(); i++) {

			if (this.huevos.get(i).isEclosion()) {
				// si el huevo eclosiona en el tiempo indicado crear un mosquito
				this.mosquito = this.huevos.get(i).eclosionMosquito();

				if (primerMosquito && !this.mosquito.isHembra()) {// esto lo hize para asegurar que el primer mosquito
																	// que se crea se hembra
					this.mosquito.setHembra(true);
					primerMosquito = false;
				}
				mosquitos.add(mosquito);
				if (this.mosquito.isHembra()) {
					for (int j = 0; j < (int) (Math.random() * 4 + 2); j++) {// este in me agrega los mosquitos dentro
																				// del rango establecido
						this.huevos.add(new Huevo(tipoMosquito()));
					}
				}
				this.huevos.remove(i);
			}

		}
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
