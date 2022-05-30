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
	private Ciudad ciudad;
    private ArrayList<Bala> balas;
    private int nivel;

	public Juego() {
		
		this.balas = new ArrayList<Bala>();
     	this.ciudad=new Ciudad();
     	this.personaje = new Personaje(300, 300);
	}
public void subirNivel() {
	for (int i = 0; i < this.ciudad.getCuadra().getPuertas().size(); i++) {
		if (getNivel()<3&&this.ciudad.getCuadra().getCriaderos().size()==0 && this.ciudad.getCuadra().getPuertas().get(i).getEdificacion().getCriaderos().size()==0) {
			setNivel(getNivel()+1);
		}
	}
}
	public void actualizar() {
		subirNivel();
		for (int i = 0; i < this.ciudad.getCuadra().getPuertas().size(); i++) {
			this.ciudad.getCuadra().getPuertas().get(i).collison(personaje);
		}
		for (int i = 0; i < this.balas.size(); i++) {
		
			this.balas.get(i).mover();
			for (int j = 0; j < this.ciudad.getCuadra().getMosquitos().size(); j++) {
				if (this.balas.get(i).colision(this.ciudad.getCuadra().getMosquitos().get(j))){
					this.balas.remove(i);
					this.ciudad.getCuadra().getMosquitos().remove(j);
					
				}
			}
			for (int j = 0; j < this.ciudad.getCuadra().getCriaderos().size(); j++) {
System.out.println(this.ciudad.getCuadra().getCriaderos().size());
				if (this.balas.get(i).colision(this.ciudad.getCuadra().getCriaderos().get(j))){
					this.balas.remove(i);
					this.ciudad.getCuadra().getCriaderos().remove(j);
					
				}
			}
			}
		
		
		
		for (int j = 0; j < this.ciudad.getCuadra().getMosquitos().size(); j++) {
			this.personaje.Rango(this.ciudad.getCuadra().getMosquitos().get(j));
			
		}

	
		} // for balas
	

	public void disparar(int posX, int posY) {
		for (int j = 0; j < this.ciudad.getCuadra().getMosquitos().size(); j++) {
				if (this.personaje.Rango(this.ciudad.getCuadra().getMosquitos().get(j))) {
					Bala bala = this.personaje.disparar(posX, posY);
					if (bala != null) {
						this.balas.add(bala);
					}
				}	
		}
		
		
		for (int j = 0; j < this.ciudad.getCuadra().getCriaderos().size(); j++) {
			if (this.personaje.Rango(this.ciudad.getCuadra().getCriaderos().get(j))) {
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

	for (int i = 0; i < this.balas.size(); i++) {
		this.balas.get(i).dibujar(g);

	}

	} // dibujar

	public int getNivel() {
	return nivel;
}
public void setNivel(int nivel) {
	this.nivel = nivel;
}
	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

}
