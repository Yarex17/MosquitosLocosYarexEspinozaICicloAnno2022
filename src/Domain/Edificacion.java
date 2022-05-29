package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Domain.Criadero.Criadero;
import Domain.Enemigo.Mosquito;

public class Edificacion  {
	private double posY,posX;
	private ArrayList<Criadero> criaderos;

	public Edificacion() {
	super();
		this.posY = 0;
		this.posX = 0;
		criaderos=new ArrayList<Criadero>(); 
		generarCriadero();
	
	}


public void dibujar(Graphics g) {
	
		//g.setColor(Color.BLACK);
		g.fillRect((int)this.posX, (int)this.posY, 800, 600);
		
		for (int i = 0; i < criaderos.size(); i++) {
			criaderos.get(i).dibujar(g);
		
	}
}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public void generarCriadero() {
		for (int i = 0; i < 2; i++) {
			if (criaderos.size()<=5) {
				criaderos.add(FabricaCriaderos.crearCriaderoInterno(i+1));

			}
			}
		
	}
	
}
