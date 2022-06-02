package Domain;

import java.awt.Graphics;
import java.util.ArrayList;

public class Nivel {
private int nivel;
private ArrayList<Cuadra> cuadras;
private Personaje personaje;
public Nivel(Personaje personaje) {
this.nivel=1;
this.personaje=personaje;
this.cuadras=new ArrayList<Cuadra>();
this.cuadras.add(new Cuadra(nivel,this.personaje));
	 
}
public void subirNivel() {
	
		
		if (getNivel()<3&& this.cuadras.get(0).getCriaderos().size()==0 && this.cuadras.get(0).getEdificio1().getCriaderos().size()==0&& this.cuadras.get(0).getEdificio2().getCriaderos().size()==0) {
			setNivel(getNivel()+1);
			this.cuadras.remove(0);
			this.cuadras.add(new Cuadra(getNivel(),this.personaje));
		}
	}

public void dibujar(Graphics g) {
	this.cuadras.get(0).dibujar(g);
}
public int getNivel() {
	return nivel;
}
public void setNivel(int nivel) {
	this.nivel = nivel;
}
public ArrayList<Cuadra> getCuadras() {
	return cuadras;
}
public void setCuadras(ArrayList<Cuadra> cuadras) {
	this.cuadras = cuadras;
}

}
