package Domain.Criadero;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.concurrent.ThreadFactory;

import javax.imageio.ImageIO;

import Domain.Enemigo.Dengue;
import Domain.Enemigo.Mosquito;

public class Balde extends Criadero {

	
	public Balde() {
		super();
		try { 
			this.imagen=ImageIO.read(getClass().getResourceAsStream("/Assets/Balde.png"));
			
			//https://www.flaticon.es/icono-premium/exterminador_4295657?term=exterminador&page=1&position=12&page=1&position=12&related_id=4295657&origin=search		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.valor=5;
	}

	@Override
	public Mosquito tipoMosquito() {
		
		return new Dengue(this.posX, this.posY);
	}

	@Override
	public void dibujar(Graphics g) {
g.drawImage(this.imagen, (int) this.posX, (int) this.posY, null);

		
	}

	

	

}
