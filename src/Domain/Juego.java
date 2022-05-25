package Domain;

import java.awt.Graphics;
import java.util.ArrayList;

public class Juego {
private Personaje personaje;
private ArrayList<Bala>balas;
public Juego() {
	this.personaje=new Personaje(300,300);
	this.balas=new ArrayList<Bala>();
	
}
public void fire(int posX,int posY) {
	Bala bala=this.personaje.disparar(posX,posY);
}
public void dibujar(Graphics g) {
	this.personaje.dibujar(g);
	
	
} // dibujar
public Personaje getPersonaje() {
	return personaje;
}
public void setPersonaje(Personaje personaje) {
	this.personaje = personaje;
}

}
