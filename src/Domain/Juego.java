package Domain;

import java.awt.Graphics;

public class Juego {
private Personaje personaje;
public Juego() {
	this.personaje=new Personaje(300,300);
}
public void dibujar(Graphics g) {
	this.personaje.dibujar(g);
	
	
} // dibujar
}
