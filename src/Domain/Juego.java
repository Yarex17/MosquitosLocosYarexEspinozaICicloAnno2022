package Domain;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import Domain.Criadero.Balde;
import Domain.Criadero.Criadero;
import Domain.Enemigo.Dengue;
import Domain.Enemigo.Mosquito;
import Domain.Enemigo.Zika;

public class Juego {
	private Personaje personaje;
	private Nivel nivel;

	public Juego() {
		this.personaje = new Personaje(300, 300);
		this.nivel = new Nivel(personaje);

	}

	public void actualizar() {
		this.nivel.subirNivel();
		this.nivel.getCuadras().get(0).actualizar();
		//this.nivel.getCuadras().get(0).getEdificio1();
	}

	public void disparar(int posX, int posY) {// problemas
		this.nivel.getCuadras().get(0).disparar(posX, posY);
		this.nivel.getCuadras().get(0).getEdificio1().disparar(posX, posY);
		this.nivel.getCuadras().get(0).getEdificio2().disparar(posX, posY);

//	}else
//
//	{
//		if (!this.nivel.getCuadras().get(0).getEdificios().get(1).isEntra()
//				&& !this.nivel.getCuadras().get(0).getEdificios().get(2).isEntra()) {
//
//			// Rango
//			for (int k = 0; k < this.nivel.getCuadras().get(0).getCriaderos().size(); k++) {
//				if (this.personaje.Rango(this.nivel.getCuadras().get(0).getCriaderos().get(k))) {
//
//					Bala bala = this.personaje.disparar(posX, posY);
//					if (bala != null) {
//						this.balas.add(bala);
//						bala = null;
//						return;
//					}
//				}
//			}
//		} // rango criaderos externos
//
//		for (int k = 0; k < this.nivel.getCuadras().get(0).getMosquitos().size(); k++) {
//			if (this.personaje.Rango(this.nivel.getCuadras().get(0).getMosquitos().get(k))) {
//				Bala bala = this.personaje.disparar(posX, posY);
//				if (bala != null) {
//					this.balas.add(bala);
//					bala = null;
//					return;
//				}
//			}
//		} // rango mosquitos externos
//	} // control de entrada
//	} // for edificios

	}// disparar

public void dibujar(Graphics g) {
	this.nivel.dibujar(g);
	this.personaje.dibujar(g);
	
	} // dibujar


	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

}
