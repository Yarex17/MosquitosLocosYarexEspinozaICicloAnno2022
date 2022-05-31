package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Domain.Criadero.Criadero;
import Domain.Enemigo.Mosquito;

public class Edificacion  {
	private double posY,posX;
	private ArrayList<Criadero> criaderos;
	private ArrayList<Mosquito> mosquitos;
	protected BufferedImage imagen;
	public Edificacion() {
	super();
		this.posY = 0;
		this.posX = 0;
		this.criaderos=new ArrayList<Criadero>(); 
		this.mosquitos=new ArrayList<Mosquito>();
		generarCriadero();
		try {
			this.imagen=ImageIO.read(getClass().getResourceAsStream("/Assets/fondoEdifio.png"));
//https://www.flaticon.es/icono-gratis/puerta_2197491?term=puerta&page=1&position=7&page=1&position=7&related_id=2197491&origin=search
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Mosquito> getMosquitos() {
		return mosquitos;
	}

	public void setMosquitos(ArrayList<Mosquito> mosquitos) {
		this.mosquitos = mosquitos;
	} 

	public void generarCriadero() {
		for (int i = 0; i < 1; i++) {
			if (criaderos.size()<=5) {
				criaderos.add(FabricaCriaderos.crearCriaderoInterno((int) (Math.random()*3+1)));

			}
			}
		
	}
public void dibujar(Graphics g) {
	
	g.drawImage(this.imagen, (int) this.posX, (int) this.posY, null);

		for (int i = 0; i < criaderos.size(); i++) {
			criaderos.get(i).dibujar(g);
		
	}
		for (int i = 0; i < this.mosquitos.size(); i++) {
			this.mosquitos.get(i).dibujar(g);
		
	}
}

	public ArrayList<Criadero> getCriaderos() {
	return criaderos;
}


public void setCriaderos(ArrayList<Criadero> criaderos) {
	this.criaderos = criaderos;
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
