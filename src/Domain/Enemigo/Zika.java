package Domain.Enemigo;

import Domain.Personaje;

public class Zika extends Mosquito {

	public Zika(double posX, double posY) {
		
		super(posX, posY);
		
	//	this.thread2.start();
		
		
		if (hembra) {
			this.valor=6;
		}else {
			this.valor=1;
		}
	}

	

	@Override
	
	void efecto(Personaje personaje) {

		if (isHembra()) {
		//personaje.setColisionZika(true);
				for (int i = 0; i < personaje.getPicadurazika(); i++) {

					personaje.setVelocidad(personaje.getVelocidad() / 2);
				}	
			
		}

	}

	@Override
	void danio( Personaje personaje) {
		
			if (isHembra()) {
				
				personaje.setColisionZika(true);
				
				personaje.setVida(personaje.getVida()-15);
				personaje.setPicadurazika(personaje.getPicadurazika()+1);
				
				} 
		}		
	
	
}
