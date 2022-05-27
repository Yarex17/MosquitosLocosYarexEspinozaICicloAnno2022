package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Domain.Criadero.Criadero;
import Domain.Enemigo.Mosquito;

public class Edificacion {
	private double posY,posX;
	private ArrayList<Criadero> criaderos;

	public Edificacion(double posY, double posX) {
	
		this.posY = posY;
		this.posX = posX;
		criaderos=new ArrayList<Criadero>(); 
		CrearCriadero();
	
	}
private void CrearCriadero() {
	for (int i = 0; i < 3; i++) {
	criaderos.add(FabricaCriaderos.crearCriaderoInterno(3));
	}
}

public void dibujar(Graphics g) {
	g.setColor(Color.BLACK);
	g.fillRect((int)this.posX, (int)this.posY, 40, 40);
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
	
}
