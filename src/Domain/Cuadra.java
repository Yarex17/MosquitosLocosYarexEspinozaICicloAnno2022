package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import Domain.Criadero.Criadero;
import Domain.Enemigo.Dengue;
import Domain.Enemigo.Mosquito;

public  class Cuadra {
	
private ArrayList<Puerta> puertas;
private ArrayList<Criadero> criaderos;
private ArrayList<Mosquito> mosquitos;
	private int  numeroCuadra;
	public Cuadra() {
		super();
		this.puertas=new ArrayList<Puerta>();
		this.criaderos=new ArrayList<Criadero>();
		this.mosquitos=new ArrayList<Mosquito>();
		this.mosquitos.add(new Dengue(300, 200));
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
	}
		
	}

public void cambiocuadra(int nivel) {
	setNumeroCuadra(nivel);
}
	public void dibujar(Graphics g) {
	
		switch (getNumeroCuadra()) {
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
					
//			if (!this.puertas.get(i).isEntra()&&this.puertas.get(i).isSale()) {
//				this.puertas.get(i).dibujar(g);
//			}else {
//				if (this.puertas.get(i).isEntra()&&!this.puertas.get(i).isSale()) {
//					this.puertas.get(i).dibujar(g);
//				}
//			}
//				
			
			
		}
		
	}
	public int getNumeroCuadra() {
		return numeroCuadra;
	}
	public void setNumeroCuadra(int numeroCuadra) {
		this.numeroCuadra = numeroCuadra;
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
