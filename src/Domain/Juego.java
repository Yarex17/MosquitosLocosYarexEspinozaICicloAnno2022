package Domain;

import java.awt.Graphics;

public class Juego {
	private Personaje personaje;
	private Nivel nivel;
	private boolean fin;

	public Juego() {
		this.fin = false;
		this.personaje = new Personaje(300, 300);
		this.nivel = new Nivel(personaje);

	}

	public void acabarJuego() {
		if (this.personaje.getVida() == 0 || this.nivel.getNivel() == 4) {
			setFin(true);
		}
	}

	public void actualizar() {

		this.nivel.subirNivel();
		acabarJuego();
		this.nivel.getCuadras().get(0).actualizar();
	}

	public void disparar(int posX, int posY) {

		if (!this.nivel.getCuadras().get(0).getEdificio2().isEntra()
				&& !this.nivel.getCuadras().get(0).getEdificio1().isEntra()) {
			this.nivel.getCuadras().get(0).disparar(posX, posY);
		}
		if (this.nivel.getCuadras().get(0).getEdificio1().isEntra()) {
			this.nivel.getCuadras().get(0).getEdificio1().disparar(posX, posY);
		}
		if (this.nivel.getCuadras().get(0).getEdificio2().isEntra()) {
			this.nivel.getCuadras().get(0).getEdificio2().disparar(posX, posY);

		}

	}// disparar

	public void dibujar(Graphics g) {
		this.nivel.dibujar(g);
		this.personaje.dibujar(g);

	} // dibujar

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public boolean isFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}

}
