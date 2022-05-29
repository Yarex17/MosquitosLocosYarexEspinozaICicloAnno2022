package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import Domain.Criadero.Criadero;
import Domain.Enemigo.Mosquito;

public  class Cuadra {
	
private ArrayList<Puerta> puertas;
private ArrayList<Criadero> criaderos;
private ArrayList<Mosquito> mosquitos;
	
	public Cuadra() {
		super();
		this.puertas=new ArrayList<Puerta>();
		this.criaderos=new ArrayList<Criadero>();
		this.mosquitos=new ArrayList<Mosquito>();
        generarEntradas();
        generarCriadero();

	}
	public void generarEntradas() {
		for (int i = 0; i < 3; i++) {
			this.puertas.add(new Puerta());
		}
	}
	
	public void generarCriadero() {
	for (int i = 0; i < 3; i++) {
		this.criaderos.add(FabricaCriaderos.crearCriaderoExterno(i+1));
		//Ciudad.mosquitos.add(Ciudad.criaderos.get(i).generaMosquitos());
	}
		
	}


	public void dibujar(Graphics g) {
	
		switch (1) {
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
		for (int i = 0; i < puertas.size(); i++) {
			this.puertas.get(i).dibujar(g);
		}
		
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
