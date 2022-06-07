package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Domain.Criadero.Criadero;
import Domain.Enemigo.Mosquito;

public class Edificio {
	private double posY, posX;
	private double posYPuerta, posXPuerta;
	private double posAntY, posAntX;
	private boolean entra;
	private ArrayList<Criadero> criaderos;
	private ArrayList<Mosquito> mosquitos;
	private ArrayList<Cargador> cargadores;
	private ArrayList<Bala> balas;
	private BufferedImage habitacion;
	private BufferedImage puerta;
	private int nivel;
	private Personaje personaje;


	public Edificio(double posXPuerta, double posYPuerta, int nivel, Personaje personaje) {
	
		this.nivel = nivel;
		this.personaje = personaje;

		this.posYPuerta = posYPuerta;
		this.posXPuerta = posXPuerta;
		this.posAntX = posXPuerta;
		this.posAntY = posYPuerta;
		this.entra = false;
		this.posY = 0;
		this.posX = 0;
		this.criaderos = new ArrayList<Criadero>();
		this.mosquitos = new ArrayList<Mosquito>();
		this.cargadores = new ArrayList<Cargador>();
		this.balas = new ArrayList<Bala>();
		generarCriadero();
		try {

			this.habitacion = ImageIO.read(getClass().getResourceAsStream("/Assets/fondoEdifio.png"));
			this.puerta = ImageIO.read(getClass().getResourceAsStream("/Assets/puerta.png"));
//https://www.flaticon.es/icono-gratis/puerta_2197491?term=puerta&page=1&position=7&page=1&position=7&related_id=2197491&origin=search
//https://www.flaticon.es/icono-gratis/puerta_2197491?term=puerta&page=1&position=7&page=1&position=7&related_id=2197491&origin=search

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.nivel = nivel;
	}

	public void collison(Personaje personaje) {
		if (((this.posXPuerta < personaje.getPosX() + 40 && this.posXPuerta >= personaje.getPosX())
				|| (this.posXPuerta + 40 > personaje.getPosX() && this.posXPuerta <= personaje.getPosX()))
				&& (this.posYPuerta < personaje.getPosY() + 40 && this.posYPuerta >= personaje.getPosY()
						|| (this.posYPuerta + 40 > personaje.getPosY() && this.posYPuerta <= personaje.getPosY()))) {
			if (!isEntra()) {
				setEntra(true);
				setPosXPuerta(400);
				setPosYPuerta(550);
				personaje.setPosX(400);
				personaje.setPosY(440);
			} else {
				setEntra(false);
				setPosXPuerta(getPosAntX());
				setPosYPuerta(getPosAntY());
				if (getPosYPuerta()<getPosYPuerta()+50) {
					personaje.setPosX(getPosXPuerta()+50);
					personaje.setPosY(getPosYPuerta()-50);
				}else {
					personaje.setPosX(getPosXPuerta()+50);
					personaje.setPosY(getPosYPuerta()+50);
				}
				
			}

		}
	}

	public void actualizar() {
		
		if (isEntra()) {
			generarMosquito(); 
			
			for (int i = 0; i < this.mosquitos.size(); i++) {
				this.mosquitos.get(i).movimiento();
				this.mosquitos.get(i).colision(personaje);
			}
			for (int i = 0; i < this.cargadores.size(); i++) {

				if (this.personaje.colision(this.cargadores.get(i))) {
					
					this.cargadores.remove(i);
				}

			}

			if (this.personaje.getCantidaBalas() <= 4) {
				if (this.cargadores.size() < 1) {
					this.cargadores.add(new Cargador());
				}

			}
			//elimina balas cuando colisiona con un mosquito
			for (int j = 0; j < this.balas.size(); j++) {
				this.balas.get(j).mover();
				for (int i = 0; i < this.mosquitos.size(); i++) {
					if (this.balas.get(j).colision(this.mosquitos.get(i))) {
						this.balas.remove(j);
						personaje.setPuntos(personaje.getPuntos()+this.mosquitos.get(i).getValor());
						this.mosquitos.remove(i);
						return;
					}

				}

			}
			//elimina balas cuando colisiona con un criadero
			for (int j = 0; j < this.balas.size(); j++) {
				this.balas.get(j).mover();
				for (int i = 0; i < this.criaderos.size(); i++) {
					if (this.balas.get(j).colision(this.criaderos.get(i))) { 
						this.balas.remove(j);
						personaje.setPuntos(personaje.getPuntos()+this.criaderos.get(i).getValor());
						this.criaderos.remove(i);
						return;
					}
 
				}

			}

		}
	}

	public void disparar(int posX, int posY) {
		//agrega balas cuando el mosquito esta dentro del rango con un mosquito
		for (int i = 0; i < this.criaderos.size(); i++) {
			if (this.personaje.Rango(this.criaderos.get(i))) {
				Bala bala = this.personaje.disparar(posX, posY);
				if (bala != null) {
					this.balas.add(bala);
					return;
				}
			}
		}
		for (int i = 0; i < this.mosquitos.size(); i++) {
			if (this.personaje.Rango(this.mosquitos.get(i))) {
				Bala bala = this.personaje.disparar(posX, posY);
				if (bala != null) {
					this.balas.add(bala);
					return;
				}
			}
		}
	}

	public void generarMosquito() {
		for (int i = 0; i < this.criaderos.size(); i++) {
			this.criaderos.get(i).generarMosquitos(mosquitos);
		}
	}

	public void generarCriadero() {
		for (int i = 0; i < 1 * nivel; i++) {

			criaderos.add(FabricaCriaderos.crearCriaderoInterno((int) (Math.random() * 3 + 1)));

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
			for (int i = 0; i < this.balas.size(); i++) {
				this.balas.get(i).dibujar(g);

			}
			for (int i = 0; i < this.cargadores.size(); i++) {
				this.cargadores.get(i).dibujar(g);

			}

			g.drawImage(this.puerta, (int) this.posXPuerta, (int) this.posYPuerta, null);
		} else {
			// g.drawImage(this.habitacion, (int) this.posX, (int) this.posY, null);

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

	public ArrayList<Cargador> getCargadores() {
		return cargadores;
	}

	public void setCargadores(ArrayList<Cargador> cargadores) {
		this.cargadores = cargadores;
	}

}
