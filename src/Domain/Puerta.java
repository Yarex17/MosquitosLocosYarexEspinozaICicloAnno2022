package Domain;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Puerta {
	private double posY,posX;
	private double posAntY,posAntX;
	private boolean entra;
	private boolean sale;
	private Edificacion edificacion;
	protected BufferedImage imagen;
	
	Puerta() {
    this.entra=false;
    this.sale=true;
		this.posX=Math.random()*760;
		this.posY=Math.random()*560;
		this.posAntY=posY;
		this.posAntX=posX;
		this.edificacion=new Edificacion();
		try {
			this.imagen=ImageIO.read(getClass().getResourceAsStream("/Assets/puerta.png"));
//https://www.flaticon.es/icono-gratis/puerta_2197491?term=puerta&page=1&position=7&page=1&position=7&related_id=2197491&origin=search
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void collison(Personaje personaje) {
		if (((this.posX < personaje.getPosX()+ 40 && this.posX >= personaje.getPosX())
				|| (this.posX + 40 > personaje.getPosX() && this.posX <= personaje.getPosX()))
				&& (this.posY < personaje.getPosY() + 40 && this.posY >= personaje.getPosY()
						|| (this.posY + 40 > personaje.getPosY() && this.posY <= personaje.getPosY()))) {
		if (!isEntra()) {
			setEntra(true);
			setSale(false);
			setPosX(400);
			setPosY(300);
		}else {
			setEntra(false);
			setSale(true);
			setPosX(getPosAntX());
			setPosY(getPosAntY());
		}
		
		}
	}
	
	
	
	public void dibujar(Graphics g) {
		if (isEntra()&&!isSale()) {
			this.edificacion.dibujar(g);
			g.drawImage(this.imagen, (int) this.posX, (int) this.posY, null);

			
		}
		g.drawString(this.isEntra()+"/"+ this.isSale(), (int) this.posX, (int) this.posY);
		g.drawImage(this.imagen, (int) this.posX, (int) this.posY, null);


	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosAntY() {
		return posAntY;
	}

	public void setPosAntY(double posAntY) {
		this.posAntY = posAntY;
	}

	public double getPosAntX() {
		return posAntX;
	}

	public void setPosAntX(double posAntX) {
		this.posAntX = posAntX;
	}

	public boolean isEntra() {
		return entra;
	}

	public void setEntra(boolean entra) {
		this.entra = entra;
	}

	public boolean isSale() {
		return sale;
	}

	public void setSale(boolean sale) {
		this.sale = sale;
	}

	public Edificacion getEdificacion() {
		return edificacion;
	}

	public void setEdificacion(Edificacion edificacion) {
		this.edificacion = edificacion;
	}
	
	
}
