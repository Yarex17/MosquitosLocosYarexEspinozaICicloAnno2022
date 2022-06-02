package Domain.Criadero;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import javax.imageio.ImageIO;

import Domain.Enemigo.Chikungunya;
import Domain.Enemigo.Mosquito;
import Domain.Enemigo.Zika;

public class Canoa extends Criadero {
public Canoa() {
super();
this.valor=15;
try { 
	this.imagen=ImageIO.read(getClass().getResourceAsStream("/Assets/Canoa.png"));
	
	//https://www.flaticon.es/icono-premium/exterminador_4295657?term=exterminador&page=1&position=12&page=1&position=12&related_id=4295657&origin=search		
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
	@Override
	public Mosquito crearMosquito() {
		// TODO Auto-generated method stub
		return new Zika(this.posX, this.posY);
	}

	@Override
	public void dibujar(Graphics g) {
		g.drawImage(this.imagen, (int) this.posX, (int) this.posY, null);

	}
}
