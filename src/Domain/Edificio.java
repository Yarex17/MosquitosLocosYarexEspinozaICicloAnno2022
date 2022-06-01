package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Domain.Criadero.Criadero;
import Domain.Enemigo.Mosquito;

public class Edificio  {
	private double posY,posX;
	private double posYPuerta,posXPuerta;
	private double posAntY,posAntX;
	private boolean entra;
	private ArrayList<Criadero> criaderos;
	private ArrayList<Mosquito> mosquitos;
	private BufferedImage habitacion;
	private BufferedImage puerta;
	
	public Edificio() {
		this.posYPuerta=(Math.random()*18*40);
		this.posXPuerta=(Math.random()*13*40);
		this.posAntX=posXPuerta;
     	this.posAntY=posYPuerta;
        this.entra=false;
		this.posY = 0;
		this.posX = 0;
		this.criaderos=new ArrayList<Criadero>(); 
		this.mosquitos=new ArrayList<Mosquito>();
		generarCriadero();
		try {
			this.habitacion=ImageIO.read(getClass().getResourceAsStream("/Assets/fondoEdifio.png"));
			this.puerta=ImageIO.read(getClass().getResourceAsStream("/Assets/puerta.png"));
//https://www.flaticon.es/icono-gratis/puerta_2197491?term=puerta&page=1&position=7&page=1&position=7&related_id=2197491&origin=search
//https://www.flaticon.es/icono-gratis/puerta_2197491?term=puerta&page=1&position=7&page=1&position=7&related_id=2197491&origin=search

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void collison(Personaje personaje) {
		if (((this.posXPuerta < personaje.getPosX()+ 40 && this.posXPuerta >= personaje.getPosX())
				|| (this.posXPuerta + 40 > personaje.getPosX() && this.posXPuerta <= personaje.getPosX()))
				&& (this.posYPuerta < personaje.getPosY() + 40 && this.posYPuerta >= personaje.getPosY()
						|| (this.posYPuerta + 40 > personaje.getPosY() && this.posYPuerta <= personaje.getPosY()))) {
		if (!isEntra()) {
			setEntra(true);
			setPosXPuerta(400);
			setPosYPuerta(550);
			personaje.setPosX(400);
			personaje.setPosY(440);
		}else {
			setEntra(false);
			setPosXPuerta(getPosAntX());
			setPosYPuerta(getPosAntY());
		}
		
		}
	}
	

	public void generarCriadero() {
		for (int i = 0; i < 1; i++) {
			if (criaderos.size()<=5) {
				criaderos.add(FabricaCriaderos.crearCriaderoInterno((int) (Math.random()*3+1)));

			}
			}
		
	}
public void dibujar(Graphics g) {
	if (isEntra()) {
		g.drawImage(this.habitacion, (int) this.posX, (int) this.posY, null);
		
		for (int i = 0; i < criaderos.size(); i++) {
			criaderos.get(i).dibujar(g);
		
	}
		for (int i = 0; i < this.mosquitos.size(); i++) {
			this.mosquitos.get(i).dibujar(g);
		
	}
		
		g.drawImage(this.puerta, (int) this.posXPuerta, (int) this.posYPuerta, null);
	}else {
		//g.drawImage(this.habitacion, (int) this.posX, (int) this.posY, null);
		
		g.drawImage(this.puerta, (int) this.posXPuerta, (int) this.posYPuerta, null);
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

	public double getPosYPuerta() {
		return posYPuerta;
	}
	public void setPosYPuerta(double posYPuerta) {
		this.posYPuerta = posYPuerta;
	}
	public double getPosXPuerta() {
		return posXPuerta;
	}
	public void setPosXPuerta(double posXPuerta) {
		this.posXPuerta = posXPuerta;
	}
	public double getPosAntY() {
		return posAntY;
	}
	public void setPosAntY(double posAntY) {
		this.posAntY = posAntY;
	}
	public double getPosAntX() {
		return posAntX;
	}
	public void setPosAntX(double posAntX) {
		this.posAntX = posAntX;
	}
	public boolean isEntra() {
		return entra;
	}
	public void setEntra(boolean entra) {
		this.entra = entra;
	}

	
	public ArrayList<Mosquito> getMosquitos() {
		return mosquitos;
	}

	public void setMosquitos(ArrayList<Mosquito> mosquitos) {
		this.mosquitos = mosquitos;
	} 
	
}
