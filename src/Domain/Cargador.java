package Domain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cargador {
	private double posX;
	private double posY;
	private BufferedImage imagen;

	public Cargador() {
	
		this.posX = Math.random()*760;
		this.posY = Math.random()*560;
		try {
			this.imagen=ImageIO.read(getClass().getResourceAsStream("/Assets/carga.png"));
			
			//https://www.flaticon.es/icono-premium/exterminador_4295657?term=exterminador&page=1&position=12&page=1&position=12&related_id=4295657&origin=search		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
public void dibujar(Graphics g) {
		
			g.drawImage(this.imagen,(int) this.posX,  (int) this.posY, null);	
		
		
		
	} // dibujar
}
