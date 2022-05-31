package Domain.Criadero;

import java.awt.Color;
import java.awt.Graphics;

import Domain.Enemigo.Chikungunya;
import Domain.Enemigo.Mosquito;
import Domain.Enemigo.Zika;

public class Canoa extends Criadero {
public Canoa() {
super();
this.valor=15;
}
	@Override
	public Mosquito generaMosquito() {
		// TODO Auto-generated method stub
		return new Zika(this.posX, this.posY);
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect((int)this.posX, (int)this.posY, 40, 40);
		g.setColor(Color.BLACK);
		g.drawOval((int)this.posX, (int)this.posY, 40, 40);
		
	}
}
