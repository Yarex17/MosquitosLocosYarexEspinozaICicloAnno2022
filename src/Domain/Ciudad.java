package Domain;

import java.awt.Graphics;


public   class Ciudad {
	
	private Cuadra cuadra;
	
public Ciudad() {
	this.cuadra = new Cuadra();
}

public  void dibujar(Graphics g) {
	cuadra.dibujar(g);
}

public Cuadra getCuadra() {
	return cuadra;
}

public void setCuadra(Cuadra cuadra) {
	this.cuadra = cuadra;
}

}
