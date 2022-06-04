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
	}

	public void disparar(int posX, int posY) {// problemas
		
	
		if (!this.nivel.getCuadras().get(0).getEdificio2().isEntra()&&!this.nivel.getCuadras().get(0).getEdificio1().isEntra()) {
			this.nivel.getCuadras().get(0).disparar(posX, posY);
		}
		if (this.nivel.getCuadras().get(0).getEdificio1().isEntra()) {
			this.nivel.getCuadras().get(0).getEdificio1().disparar(posX, posY);
		}
		if (this.nivel.getCuadras().get(0).getEdificio2().isEntra()) {
			this.nivel.getCuadras().get(0).getEdificio2().disparar(posX, posY);

		}
		
		

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
