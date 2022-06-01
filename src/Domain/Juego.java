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
	private ArrayList<Bala> balas;
	private ArrayList<Cargador>cargadores;
	public Juego() {
		this.cargadores=new ArrayList<Cargador>();
		this.balas = new ArrayList<Bala>();
     	this.nivel=new Nivel();
     	this.personaje = new Personaje(300, 300);
     	
   
	}

public void generarCargador() {
	if (this.personaje.getCantidaBalas()<=4) {
		if (cargadores.size()<1) {
			cargadores.add(new Cargador());
		}
		
	}
}
	public void actualizar() {
		this.nivel.subirNivel();
		generarCargador();
		
	
		//Actializacion de cargadores
		for (int i = 0; i < cargadores.size(); i++) {
	 if (this.personaje.colision((int)cargadores.get(i).getPosX(), (int)cargadores.get(i).getPosY())) {
		 this.personaje.setCantidaBalas(10);
		this.cargadores.remove(i);
	}
		}
//for (int i = 0; i < this.nivel.getCuadras().get(0).getEdificios().size(); i++) {
//if (this.nivel.getCuadras().get(0).getEdificios().get(i).isEntra()) {
//	this.nivel.getCuadras().get(0).getEdificios().get(i).collison(personaje);
//}else {
//	this.nivel.getCuadras().get(0).getEdificios().get(i).collison(personaje);
//}
//}
for (int i = 0; i < this.nivel.getCuadras().get(0).getMosquitos().size(); i++) {
	 this.nivel.getCuadras().get(0).getMosquitos().get(i).movimiento();
}

this.nivel.getCuadras().get(0).generarMosquitos();


for (int i = 0; i < this.nivel.getCuadras().get(0).getEdificios().size(); i++) {
	
}
	
			for (int i = 0; i < this.nivel.getCuadras().get(0).getEdificios().size(); i++) {
				
					if (this.nivel.getCuadras().get(0).getEdificios().get(i).isEntra()) {
						this.nivel.getCuadras().get(0).getEdificios().get(i).collison(personaje);
						
						for (int j = 0; j < this.nivel.getCuadras().get(0).getEdificios().get(i).getMosquitos().size(); j++) {
							this.nivel.getCuadras().get(0).getEdificios().get(i).getMosquitos().get(j).colision(personaje);	
						}
						
						
						for (int j = 0; j < this.balas.size(); j++) {
							this.balas.get(j).mover();
							
						for (int j2 = 0; j2 < this.nivel.getCuadras().get(0).getEdificios().get(i).getMosquitos()
								.size(); j2++) {
							if (this.balas.get(j).colision(
									this.nivel.getCuadras().get(0).getEdificios().get(i).getMosquitos().get(j2))) {
							       this.balas.remove(j);
								this.nivel.getCuadras().get(0).getEdificios().get(i).getMosquitos().remove(j2);
								break;
							}
							
						}//for mosquitos internos
						for (int f = 0; f < this.nivel.getCuadras().get(0).getEdificios().get(i).getCriaderos()
								.size(); f++) {
							if (this.balas.get(j).colision(
									this.nivel.getCuadras().get(0).getEdificios().get(i).getCriaderos().get(f))) {
								this.balas.remove(j);
								this.nivel.getCuadras().get(0).getEdificios().get(i).getCriaderos().remove(f);
								break;
							}
						}//for mosquitos internos
				
					
						}
						
					} else {
						
						this.nivel.getCuadras().get(0).getEdificios().get(i).collison(personaje);
						for (int j = 0; j < this.nivel.getCuadras().get(0).getMosquitos().size(); j++) {
							this.nivel.getCuadras().get(0).getMosquitos().get(j).colision(personaje);	
						}
//						for (int j = 0; j < this.nivel.getCuadras().get(0).getCriaderos().size(); j++) {
//
//						} //
						
						for (int j = 0; j < this.balas.size(); j++) {
							this.balas.get(j).mover();
						
						for (int k = 0; k < this.nivel.getCuadras().get(0).getMosquitos().size(); k++) {
							if (this.balas.get(i).colision(this.nivel.getCuadras().get(0).getMosquitos().get(k))) {
								this.balas.remove(j);
								this.nivel.getCuadras().get(0).getMosquitos().remove(k);
								break;
							}//if  mosquitos externos
						}
						for (int k = 0; k < this.nivel.getCuadras().get(0).getCriaderos().size(); k++) {
							if (this.balas.get(j).colision(this.nivel.getCuadras().get(0).getCriaderos().get(k))) {
								this.nivel.getCuadras().get(0).getCriaderos().remove(k);
								this.balas.remove(j);
								break;
							}
						}//for crideros externos
						
						
											}//if cotrola cuando eliminar un vala dentro o fuera de un edificio
				} // for bala
			} // for edificios
		
		
		//Rangos 
	
	
		} //actualizar
	

	public void disparar(int posX, int posY) {//problemas 
		
		
		for (int i = 0; i < this.nivel.getCuadras().get(0).getEdificios().size(); i++) {
			if (this.nivel.getCuadras().get(0).getEdificios().get(i).isEntra()) {
				// rango
				for (int h = 0; h < this.nivel.getCuadras().get(0).getEdificios().size(); h++) {
					if (this.personaje.Rango(this.nivel.getCuadras().get(0).getEdificios().get(i).getCriaderos().get(h))) {
						Bala bala = this.personaje.disparar(posX, posY);
						if (bala != null) {
							this.balas.add(bala);
							break;
						}
					}
				} // rango criaderos

				for (int h = 0; h < this.nivel.getCuadras().get(0).getMosquitos().size(); h++) {
					if (this.personaje.Rango(this.nivel.getCuadras().get(0).getEdificios().get(i).getMosquitos().get(h))) {
						Bala bala = this.personaje.disparar(posX, posY);
						if (bala != null) {
							this.balas.add(bala);
							break;
						}
					}
				}
			} else {
				// Rango
				for (int k = 0; k < this.nivel.getCuadras().get(0).getCriaderos().size(); k++) {
					if (this.personaje.Rango(this.nivel.getCuadras().get(0).getCriaderos().get(k))) {
						Bala bala = this.personaje.disparar(posX, posY);
						if (bala != null) {
							this.balas.add(bala);
							break;
						}
					}
				} // rango criaderos externos

				for (int k = 0; k < this.nivel.getCuadras().get(0).getMosquitos().size(); k++) {
					if (this.personaje.Rango(this.nivel.getCuadras().get(0).getMosquitos().get(k))) {
						Bala bala = this.personaje.disparar(posX, posY);
						if (bala != null) {
							this.balas.add(bala);
							break;
						}
					}
				} // rango mosquitos externos
			} // control de entrada
		} // for edificios

	}// disparar
		
	

public void dibujar(Graphics g) {
	this.nivel.dibujar(g);
	this.personaje.dibujar(g);
	for (int i = 0; i < this.cargadores.size(); i++) {
		this.cargadores.get(i).dibujar(g);
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
