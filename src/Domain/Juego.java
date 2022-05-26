package Domain;

import java.awt.Graphics;
import java.util.ArrayList;

import Domain.Enemigo.Dengue;
import Domain.Enemigo.Mosquito;

public class Juego {
	private Personaje personaje;
	private ArrayList<Bala> balas;
	private ArrayList<Mosquito>mosquitos;

	public Juego() {
		
		this.personaje = new Personaje(300, 300);
		this.balas = new ArrayList<Bala>();
		this.mosquitos=new ArrayList<Mosquito>();
this.mosquitos.add(new Dengue(200, 300));
	}

	public void actualizar() {
		for (int i = 0; i < this.balas.size(); i++) {
			this.balas.get(i).mover();
//		for (int j = 0; j < this.enemigos.size(); j++) { 
//			if(this.balas.get(i).colision(this.enemigos.get(j))) {
//				this.enemigos.remove(j);
//				this.balasDisparadas.remove(i);
//				crearNuevosEnemigos();
//				break; 
//			} // if
//		} // for enemigos
		} // for balas
	}

	public void disparar(int posX, int posY) {
		for (int j = 0; j < this.mosquitos.size(); j++) {
			for (int i = 0; i < this.balas.size(); i++) {
				if (this.balas.get(i).Rango(this.mosquitos.get(j))) {
					Bala bala = this.personaje.disparar(posX, posY);
					if (bala != null) {
						this.balas.add(bala);
					}
				}	
		}

}
		
	}

	public void dibujar(Graphics g) {
		this.personaje.dibujar(g);
for (int i = 0; i < this.balas.size(); i++) {
	this.balas.get(i).dibujar(g);
}
for (int i = 0; i < this.mosquitos.size(); i++) {
	this.mosquitos.get(i).dibujar(g);
}
	} // dibujar

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

}
