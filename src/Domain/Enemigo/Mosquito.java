package Domain.Enemigo;

public class Mosquito {
	protected double posX, posY;

	
	
	public Mosquito(double posX, double posY) {
		this.posX = posX;
		this.posY = posY;
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
	
}
