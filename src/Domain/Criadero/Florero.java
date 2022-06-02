package Domain.Criadero;

import java.awt.Color;
import java.awt.Graphics;

import Domain.Enemigo.Chikungunya;
import Domain.Enemigo.Mosquito;

public class Florero extends Criadero{
	
public Florero() {

this.valor=10;

}
	@Override
	public Mosquito crearMosquito() {
		return new Chikungunya(this.posX, this.posY);
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect((int)this.posX, (int)this.posY, 40, 40);
		g.setColor(Color.BLACK);
		g.drawOval((int)this.posX, (int)this.posY, 40, 40);
		
	}

}
