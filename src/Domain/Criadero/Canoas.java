package Domain.Criadero;

import java.awt.Color;
import java.awt.Graphics;

import Domain.Enemigo.Chikungunya;
import Domain.Enemigo.Mosquito;
import Domain.Enemigo.Zika;

public class Canoas extends Criadero {

	@Override
	public Mosquito generaMosquitos() {
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
