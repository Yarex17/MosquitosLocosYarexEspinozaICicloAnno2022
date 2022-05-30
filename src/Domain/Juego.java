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
private ArrayList<Cargador>cargadores;
	public Juego() {
		this.cargadores=new ArrayList<Cargador>();
		this.balas = new ArrayList<Bala>();
     	this.ciudad=new Ciudad();
     	this.personaje = new Personaje(300, 300);
     	this.nivel=3;
	}
public void subirNivel() {
	for (int i = 0; i < this.ciudad.getCuadra().getPuertas().size(); i++) {
		if (getNivel()<3&&this.ciudad.getCuadra().getCriaderos().size()==0 && this.ciudad.getCuadra().getPuertas().get(i).getEdificacion().getCriaderos().size()==0) {
			setNivel(getNivel()+1);
		}
	}
}
public void generarCargador() {
	if (this.personaje.getCantidaBalas()<=4) {
		cargadores.add(new Cargador());
	}
}
	public void actualizar() {
		subirNivel();
		generarCargador();
		this.ciudad.getCuadra().cambiocuadra(getNivel());
	
		
		for (int i = 0; i < cargadores.size(); i++) {
	 if (this.personaje.colision(cargadores.get(i).getPosX(), cargadores.get(i).getPosY())) {
		 System.out.println("entra");
		this.cargadores.remove(i);
	}
		}
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
			for (int j = 0; j < this.ciudad.getCuadra().getPuertas().size(); j++) {
				for (int x = 0; x < this.ciudad.getCuadra().getPuertas().get(j).getEdificacion().getCriaderos().size(); x++) {
//if (this.balas.get(i).colision(	this.ciudad.getCuadra().getPuertas().get(j).getEdificacion().getCriaderos().get(x))) {
//	this.balas.remove(i);
//	this.ciudad.getCuadra().getPuertas().get(j).getEdificacion().getCriaderos().remove(x);
//}
				}
				
			}
			
			}
		
		
		
		for (int j = 0; j < this.ciudad.getCuadra().getMosquitos().size(); j++) {
			this.personaje.Rango(this.ciudad.getCuadra().getMosquitos().get(j));
			
		}
		
		for (int j = 0; j < this.ciudad.getCuadra().getPuertas().size(); j++) {
			for (int i = 0; i < this.ciudad.getCuadra().getPuertas().get(j).getEdificacion().getCriaderos().size(); i++) {
				this.personaje.Rango(this.ciudad.getCuadra().getPuertas().get(j).getEdificacion().getCriaderos().get(i));

			}
			
		}

	
		} //actualizar
	

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
for (int i = 0; i < this.cargadores.size(); i++) {
	this.cargadores.get(i).dibujar(g);
}
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
