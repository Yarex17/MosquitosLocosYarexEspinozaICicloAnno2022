package Domain;
import java.awt.Color;
import java.awt.Graphics;

public class Puerta {
	private double posY,posX;
	private double posAntY,posAntX;
	private boolean entra;
	private boolean sale;
	private Edificacion edificacion;
	Puerta() {
    this.entra=false;
    this.sale=false;
		this.posX=Math.random()*760;
		this.posY=Math.random()*560;
		this.posAntY=posY;
		this.posAntX=posX;
		this.edificacion=new Edificacion();
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
		g.setColor(Color.BLACK);
		g.fillRect((int)this.posX, (int)this.posY, 40, 40);
		if (isEntra()&&!isSale()) {
			this.edificacion.dibujar(g);
		}
		
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
	
	
}
