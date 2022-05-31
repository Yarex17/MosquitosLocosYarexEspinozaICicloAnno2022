package Domain.Criadero;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ThreadFactory;

import Domain.Enemigo.Dengue;
import Domain.Enemigo.Mosquito;

public class Balde extends Criadero {

	
	public Balde() {
		super();
		this.valor=5;
	}

	@Override
	public Mosquito generaMosquito() {
		
		return new Dengue(this.posX, this.posY);
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)this.posX, (int)this.posY, 40, 40);
		
		
	}

	

	

}
