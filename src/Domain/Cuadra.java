package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import Domain.Criadero.Criadero;
import Domain.Enemigo.Dengue;
import Domain.Enemigo.Mosquito;

public  class Cuadra {
	
private ArrayList<Puerta> puertas;
private ArrayList<Criadero> criaderos;
private ArrayList<Mosquito> mosquitos;
	private int  nivel;
	public Cuadra(int nivel) {
		super();
		this.puertas=new ArrayList<Puerta>();
		this.criaderos=new ArrayList<Criadero>();
		this.mosquitos=new ArrayList<Mosquito>();
		this.mosquitos.add(new Dengue(300, 200));
		this.nivel=nivel;
		
        generarEntradas();
        generarCriadero();
       //agregar();

	}
	public void agregar() {
for (int i = 0; i < this.criaderos.size(); i++) {
	for (int j = 0; j < (int) (Math.random()*5+1); j++) {
		Mosquito mosquito=this.criaderos.get(i).generarMosquitos();
		if (mosquito!=null) {
			this.mosquitos.add(mosquito);
		}
	}
}
	}
	public void generarEntradas() {
		for (int i = 0; i < 3; i++) {
			this.puertas.add(new Puerta());
		}
	}
	
	public void generarCriadero() {
	
	for (int i = 0; i < 3; i++) {
		this.criaderos.add(FabricaCriaderos.crearCriaderoExterno((int) (Math.random()*3+1)));
	}
		
	}
	public void generarMosquitos() {
		for (int i = 0; i <criaderos.size(); i++) {
			this.mosquitos.add(this.criaderos.get(i).generarMosquitos());
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
		//System.out.println(entradas.size());
		g.fillRect(0,0, 800, 600);
		for (int i = 0; i < this.criaderos.size(); i++) {
			this.criaderos.get(i).dibujar(g);
		
		}
		for (int i = 0; i < this.mosquitos.size(); i++) {
			this.mosquitos.get(i).dibujar(g);
		
		}
		int validad=-1;
		for (int i = 0; i < puertas.size(); i++) {
			
					if (this.puertas.get(i).isEntra()&&!this.puertas.get(i).isSale()) {
						validad=i;
					}else {
						
					}
					if (validad==-1&&!this.puertas.get(i).isEntra()&&this.puertas.get(i).isSale()) {
						this.puertas.get(i).dibujar(g);
					}else {
						if (this.puertas.get(i).equals(this.puertas.get(validad))) {
							this.puertas.get(validad).dibujar(g);
						}
					}
					
		
			
		}
		
	}
	
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public ArrayList<Puerta> getPuertas() {
		return puertas;
	}
	public void setPuertas(ArrayList<Puerta> puertas) {
		this.puertas = puertas;
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
	
	

}
