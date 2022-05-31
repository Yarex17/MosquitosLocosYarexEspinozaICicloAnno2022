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
	private ArrayList<Cuadra> cuadras;
	private ArrayList<Bala> balas;
    protected  int nivel;
private ArrayList<Cargador>cargadores;
	public Juego() {
		this.cargadores=new ArrayList<Cargador>();
		this.balas = new ArrayList<Bala>();
     	this.cuadras=new ArrayList<Cuadra>();
     	this.cuadras.add(new Cuadra(1));
     	this.cuadras.add(new Cuadra(2));
     	this.cuadras.add(new Cuadra(3));
     	this.personaje = new Personaje(300, 300);
     	
     	this.nivel=0;
	}
public void subirNivel() {
	for (int i = 0; i <this.cuadras.get(nivel).getPuertas().size(); i++) {
		if (getNivel()<2&&this.cuadras.get(nivel).getCriaderos().size()==0 && this.cuadras.get(nivel).getPuertas().get(i).getEdificacion().getCriaderos().size()==0) {
			setNivel(getNivel()+1);
		}
	}
}
public void generarCargador() {
	if (this.personaje.getCantidaBalas()<=4) {
		if (cargadores.size()<1) {
			cargadores.add(new Cargador());
		}
		
	}
}
	public void actualizar() {
		subirNivel();
		generarCargador();
		
	
		// actualiza la cantidad de balas
		for (int i = 0; i < cargadores.size(); i++) {
	 if (this.personaje.colision((int)cargadores.get(i).getPosX(), (int)cargadores.get(i).getPosY())) {
		 this.personaje.setCantidaBalas(10);
		this.cargadores.remove(i);
	}
		}
		//actualiza
		for (int i = 0; i <this.cuadras.get(nivel).getPuertas().size(); i++) {
			
			this.cuadras.get(nivel).getPuertas().get(i).collison(personaje);
		}
		
		
		for (int i = 0; i < this.balas.size(); i++) {// esto genera un problema
		
			//this.balas.get(i).mover();
			for (int j = 0; j < this.cuadras.get(nivel).getMosquitos().size(); j++) {
				if (this.balas.get(i).colision(this.cuadras.get(nivel).getMosquitos().get(j))){
					this.balas.remove(i);
					this.cuadras.get(nivel).getMosquitos().remove(j);
					break;
				}
			}
			
			}
		
//		for (int i = 0; i < this.balas.size(); i++) {// tengo problemas
//			
//			for (int j = 0; j < this.cuadras.get(nivel).getPuertas().size(); j++) {
//				for (int x = 0; x < this.cuadras.get(nivel).getPuertas().get(j).getEdificacion().getCriaderos()
//						.size(); x++) {
//					//System.out.println(this.cuadras.get(nivel).getPuertas().get(j).getEdificacion().getCriaderos()
//					//	.size());
//					if (this.balas.get(i).colision(this.cuadras.get(nivel).getPuertas()
//							.get(j).getEdificacion().getCriaderos().get(x)) /*&& this.cuadras.get(nivel).getPuertas().get(j).isEntra()*/) {
//						this.balas.remove(i);
//						this.cuadras.get(nivel).getPuertas().get(j).getEdificacion().getCriaderos().remove(x);
//						break;
//					}
//					}
//					
//				}
//		}
		for (int i = 0; i < this.balas.size(); i++) {
			for (int j = 0; j < this.cuadras.get(nivel).getPuertas().size(); j++) {
				for (int x = 0; x < this.cuadras.get(nivel).getPuertas().get(j).getEdificacion().getMosquitos()
						.size(); x++) {
					if (this.balas.get(i).colision(this.cuadras.get(nivel).getPuertas()
							.get(j).getEdificacion().getMosquitos().get(x))&& this.cuadras.get(nivel).getPuertas().get(j).isEntra()) {
						this.balas.remove(i);
						this.cuadras.get(nivel).getPuertas().get(j).getEdificacion().getMosquitos().remove(x);
						break;
					}
					}
					
				}
		}
		
		for (int i = 0; i < this.balas.size(); i++) {
			for (int j = 0; j < this.cuadras.get(nivel).getCriaderos().size(); j++) {
				if (this.balas.get(i).colision(this.cuadras.get(nivel).getCriaderos().get(j))){
					this.balas.remove(i);
					this.cuadras.get(nivel).getCriaderos().remove(j);
					break;
				}
				
			}
		}
		for (int i = 0; i < this.balas.size(); i++) {// esto genera un problema
			
			this.balas.get(i).mover();
			for (int j = 0; j < this.cuadras.get(nivel).getMosquitos().size(); j++) {
				if (this.balas.get(i).colision(this.cuadras.get(nivel).getMosquitos().get(j))){
					this.balas.remove(i);
					this.cuadras.get(nivel).getMosquitos().remove(j);
					break;
				}
			}
		}
		
		
		//Rangos 
		for (int j = 0; j < this.cuadras.get(nivel).getMosquitos().size(); j++) {
			this.personaje.Rango(this.cuadras.get(nivel).getMosquitos().get(j));
			
		}
		
		for (int j = 0; j < this.cuadras.get(nivel).getPuertas().size(); j++) {
			for (int i = 0; i < this.cuadras.get(nivel).getPuertas().get(j).getEdificacion().getCriaderos().size(); i++) {
				this.personaje.Rango(this.cuadras.get(nivel).getPuertas().get(j).getEdificacion().getCriaderos().get(i));
			}
			
		}
		for (int j = 0; j < this.cuadras.get(nivel).getPuertas().size(); j++) {
			for (int i = 0; i < this.cuadras.get(nivel).getPuertas().get(j).getEdificacion().getMosquitos().size(); i++) {
				this.personaje.Rango(this.cuadras.get(nivel).getPuertas().get(j).getEdificacion().getMosquitos().get(i));
			}
			
		}
		for (int i = 0; i < this.cuadras.get(getNivel()).getMosquitos().size(); i++) {
			this.cuadras.get(getNivel()).getMosquitos().get(i).movimiento();
			this.cuadras.get(getNivel()).getMosquitos().get(i).colision(personaje);
		}
		 this.cuadras.get(getNivel()).agregar();
	
		} //actualizar
	

	public void disparar(int posX, int posY) {
		for (int k = 0; k < this.cuadras.get(nivel).getPuertas().size(); k++) {
			for (int j = 0; j < this.cuadras.get(nivel).getMosquitos().size(); j++) {
				if (this.personaje.Rango(this.cuadras.get(nivel).getMosquitos().get(j))) {
					if (!this.cuadras.get(nivel).getPuertas().get(k).isEntra()) {
						Bala bala = this.personaje.disparar(posX, posY);
						if (bala != null) {
							this.balas.add(bala);
						}
					}

				}
			}
		}
		

		for (int k = 0; k < this.cuadras.get(nivel).getPuertas().size(); k++) {
			for (int j = 0; j < this.cuadras.get(nivel).getCriaderos().size(); j++) {
				if (this.personaje.Rango(this.cuadras.get(nivel).getCriaderos().get(j))) {
					if (!this.cuadras.get(nivel).getPuertas().get(k).isEntra()) {
						Bala bala = this.personaje.disparar(posX, posY);
						if (bala != null) {
							this.balas.add(bala);
						}//if add
					}//if puerta
				}//if criaderowww
			}
		}
		
		for (int j = 0; j < this.cuadras.get(nivel).getPuertas().size(); j++) {
			for (int i = 0; i < this.cuadras.get(nivel).getPuertas().get(j).getEdificacion().getCriaderos().size(); i++) {
				if (this.personaje.Rango(this.cuadras.get(nivel).getPuertas().get(j).getEdificacion().getCriaderos().get(i))) {
					if (this.cuadras.get(nivel).getPuertas().get(j).isEntra()) {
						Bala bala = this.personaje.disparar(posX, posY);
						if (bala != null) {
							this.balas.add(bala);
							break;
						}
					}
				}	
			}
			
	}
		
		for (int j = 0; j < this.cuadras.get(nivel).getPuertas().size(); j++) {
			for (int i = 0; i < this.cuadras.get(nivel).getPuertas().get(j).getEdificacion().getMosquitos().size(); i++) {
				if (this.personaje.Rango(this.cuadras.get(nivel).getPuertas().get(j).getEdificacion().getCriaderos().get(i))) {
					if (this.cuadras.get(nivel).getPuertas().get(j).isEntra()) {
						Bala bala = this.personaje.disparar(posX, posY);
						if (bala != null) {
							this.balas.add(bala);
							break;
						}
					}
				}	
			}
			
	}	


}//disparar
		
	

public void dibujar(Graphics g) {
	this.cuadras.get(nivel).dibujar(g);
	this.personaje.dibujar(g);
for (int i = 0; i < this.cargadores.size(); i++) {
	this.cargadores.get(i).dibujar(g);
}
	for (int i = 0; i < this.balas.size(); i++) {
		this.balas.get(i).dibujar(g);

	}

	} // dibujar

	public  int getNivel() {
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
