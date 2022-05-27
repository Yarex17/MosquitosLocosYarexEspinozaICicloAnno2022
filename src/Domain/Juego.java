package Domain;

import java.awt.Graphics;
import java.util.ArrayList;

import Domain.Criadero.Balde;
import Domain.Criadero.Criadero;
import Domain.Enemigo.Dengue;
import Domain.Enemigo.Mosquito;
import Domain.Enemigo.Zika;

public class Juego {
	private Personaje personaje;
	private Ciudad ciudad;
	private ArrayList<Bala> balas;
	private ArrayList<Mosquito>mosquitos;
private Criadero criadero;
	public Juego() {
		
		
		this.balas = new ArrayList<Bala>();
		
     	
     	this.ciudad=new Cuadra();
     	this.personaje = new Personaje(300, 300);
	}

	public void actualizar() {
		
		for (int i = 0; i < this.balas.size(); i++) {
			this.balas.get(i).mover();
			for (int j = 0; j < this.ciudad.mosquitos.size(); j++) {
				if (this.balas.get(i).colision(this.ciudad.mosquitos.get(j))){
					this.ciudad.mosquitos.remove(j);
					//this.balas.remove(i);
				}
			}
			}
		for (int j = 0; j < this.ciudad.mosquitos.size(); j++) {
			this.ciudad.mosquitos.get(j).movimiento();
		}
//		for (int j = 0; j < this.enemigos.size(); j++) { 
//			if(this.balas.get(i).colision(this.enemigos.get(j))) {
//				this.enemigos.remove(j);
//				this.balasDisparadas.remove(i);
//				crearNuevosEnemigos();
//				break; 
//			} // if
//		} // for enemigos
	
		} // for balas
	

	public void disparar(int posX, int posY) {
		for (int j = 0; j < this.ciudad.mosquitos.size(); j++) {
				if (this.personaje.Rango(this.ciudad.mosquitos.get(j))) {
					Bala bala = this.personaje.disparar(posX, posY);
					if (bala != null) {
						this.balas.add(bala);
					}
				}	
		}

}
		
	

	public void dibujar(Graphics g) {
		this.ciudad.dibujar(g);
		this.personaje.dibujar(g);
		for (int i = 0; i <this.ciudad.mosquitos.size(); i++) {
			this.ciudad.mosquitos.get(i).dibujar(g);
		}
		for (int i = 0; i <this.ciudad.criaderos.size(); i++) {
			this.ciudad.criaderos.get(i).dibujar(g);
		}
		
for (int i = 0; i < this.balas.size(); i++) {
	this.balas.get(i).dibujar(g);
}

	} // dibujar

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

}
