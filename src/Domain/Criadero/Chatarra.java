package Domain.Criadero;

import java.awt.Color;
import java.awt.Graphics;

import Domain.Enemigo.Chikungunya;
import Domain.Enemigo.Mosquito;

public class Chatarra extends Criadero {
	public Chatarra() {
super();
this.valor=10;
}
	@Override
	public Mosquito crearMosquito() {
		// TODO Auto-generated method stub
		return new Chikungunya(this.posX, this.posY);
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect((int)this.posX, (int)this.posY, 40, 40);
		g.setColor(Color.BLACK);
		g.drawOval((int)this.posX, (int)this.posY, 40, 40);
		
	}
}
