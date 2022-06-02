package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import Domain.Criadero.Criadero;
import Domain.Enemigo.Dengue;
import Domain.Enemigo.Mosquito;

public  class Cuadra {
private ArrayList<Edificio>edificios;
private ArrayList<Criadero> criaderos;
private ArrayList<Mosquito> mosquitos;
	private int  nivel;
	public Cuadra(int nivel) {
		this.edificios=new ArrayList<Edificio>();
		this.criaderos=new ArrayList<Criadero>();
		this.mosquitos=new ArrayList<Mosquito>();
		this.nivel=nivel;
		
        generarEntradas();
        generarCriadero();
      
	}
 public void generarMosquito() {
	for (int i = 0; i < this.criaderos.size(); i++) {
		this.criaderos.get(i).generarMosquitos(mosquitos);
	}
}

	public void generarEntradas() {
		this.edificios.add(new Edificio(100,550,this.nivel));
		this.edificios.add(new Edificio(400,100,this.nivel));
		this.edificios.add(new Edificio(720,300,this.nivel));
	}
	
	public void generarCriadero() {
	
	for (int i = 0; i < 2*this.nivel; i++) {
		this.criaderos.add(FabricaCriaderos.crearCriaderoExterno((int) (Math.random()*3+1)));
	}
		
	}

	public void dibujar(Graphics g) {
	
		switch (getNivel()) {
		case 1:
			g.setColor(Color.RED);
			break;
		case 2:
			g.setColor(Color.blue);
			break;
		case 3:
			g.setColor(Color.ORANGE);
			break;

		default:
			break;
		}
		
		g.fillRect(0,0, 800, 600);
		
		for (int i = 0; i < this.criaderos.size(); i++) {
			this.criaderos.get(i).dibujar(g);
		
		}
		for (int i = 0; i < this.mosquitos.size(); i++) {
			this.mosquitos.get(i).dibujar(g);
		
		}
		int validacion=0;
		int puertaActiva=0;
		for (int i = 0; i < this.edificios.size(); i++) {
			if (!this.edificios.get(i).isEntra()) {
				validacion++;
			}else {
				 puertaActiva=i;
			}	
		}
		for (int i = 0; i < this.edificios.size(); i++) {
			if (validacion==this.edificios.size()) {
				this.edificios.get(i).dibujar(g);
				
			}else {
				this.edificios.get(puertaActiva).dibujar(g);
			}
		}
	}
	
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public ArrayList<Criadero> getCriaderos() {
		return criaderos;
	}
	public void setCriaderos(ArrayList<Criadero> criaderos) {
		this.criaderos = criaderos;
	}
	public ArrayList<Mosquito> getMosquitos() {
		return mosquitos;
	}
	public void setMosquitos(ArrayList<Mosquito> mosquitos) {
		this.mosquitos = mosquitos;
	}
	public ArrayList<Edificio> getEdificios() {
		return edificios;
	}
	public void setEdificios(ArrayList<Edificio> edificios) {
		this.edificios = edificios;
	}
	
	

}
