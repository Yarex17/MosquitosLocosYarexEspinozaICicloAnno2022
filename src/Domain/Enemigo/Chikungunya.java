package Domain.Enemigo;

import Domain.Personaje;

public class Chikungunya extends Mosquito {

	public Chikungunya(double posX, double posY) {
		super(posX, posY);
		if (hembra) {
			this.valor=4;
		}else {
			this.valor=1;
		}
	}



	@Override
	void efecto() {
		if (isHembra()) {
			
		}
		
	}



	@Override
	void daño( Personaje personaje) {
		
			if (isHembra()) {
				personaje.setVida(personaje.getVida()-10);
				setContidadPicaduras(getContidadPicaduras()+1);
			} 
		
		
	}



	

}
