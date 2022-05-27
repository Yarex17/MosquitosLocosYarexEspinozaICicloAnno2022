package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Domain.Criadero.Criadero;
import Domain.Enemigo.Mosquito;

public class Edificacion extends Ciudad{
	private double posY,posX;
	//private ArrayList<Criadero> criaderos;

	public Edificacion(double posY, double posX) {
	super(nivel);
		this.posY = posY;
		this.posX = posX;
		criaderos=new ArrayList<Criadero>(); 
		generarCriadero();
	
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
	@Override
	public void generarCriadero() {
		for (int i = 0; i < 3; i++) {
			criaderos.add(FabricaCriaderos.crearCriaderoInterno(i+1));
			}
		
	}
	
}
