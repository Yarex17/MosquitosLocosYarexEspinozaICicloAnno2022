package Domain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cargador {
	private int posX;
	private int posY;
	private BufferedImage imagen;
	public Cargador() {
		this.posX = (int)Math.random()*760;
		this.posY = (int)Math.random()*560;
		try {
			this.imagen=ImageIO.read(getClass().getResourceAsStream("/Assets/carga.png"));
			
			//https://www.flaticon.es/icono-premium/exterminador_4295657?term=exterminador&page=1&position=12&page=1&position=12&related_id=4295657&origin=search		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
public void dibujar(Graphics g) {
		
		g.drawImage(this.imagen, this.posX,  this.posY, null);
		
	} // dibujar
}
