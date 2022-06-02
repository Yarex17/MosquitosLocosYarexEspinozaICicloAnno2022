package Domain.Enemigo;

import Domain.Personaje;

public class Dengue extends Mosquito{
private int picaduras;
	public Dengue(double posX, double posY) {
		
		super(posX, posY);
		this.picaduras=0;
		if (hembra) {
			this.valor=2;
		}else {
			this.valor=1;
		}
		
	}
	@Override
	void efecto(Personaje personaje) {
		if (isHembra()) {
			if (getPicaduras()==2) {
				personaje.setVida(0);
			}
		}
		
	}

	@Override
	void danio( Personaje personaje) {
		
			if (isHembra()) {
				personaje.setVida(personaje.getVida()-5);
				setContidadPicaduras(getContidadPicaduras()+1);
			} 
		}




	public int getPicaduras() {
		return picaduras;
	}




	public void setPicaduras(int picaduras) {
		this.picaduras = picaduras;
	}

	

	

}
