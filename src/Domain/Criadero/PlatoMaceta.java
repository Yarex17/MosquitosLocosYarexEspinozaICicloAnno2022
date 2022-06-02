package Domain.Criadero;

import java.awt.Color;
import java.awt.Graphics;

import Domain.Enemigo.Mosquito;
import Domain.Enemigo.Zika;

public class PlatoMaceta extends Criadero {
public PlatoMaceta() {
	super();
	this.valor=15;
}
	@Override
	public Mosquito crearMosquito() {
		// TODO Auto-generated method stub
		return new Zika(this.posX,this.posY);
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect((int)this.posX, (int)this.posY, 40, 40);
		
	}

}
