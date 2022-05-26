package Domain.Criadero;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ThreadFactory;

import Domain.Enemigo.Dengue;
import Domain.Enemigo.Mosquito;

public class Balde extends Criadero implements Runnable{

	
	@Override
	public Mosquito generaMosquitos() {
		
		return new Dengue(this.posX, this.posY);
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)this.posX, (int)this.posY, 40, 40);
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	

}
