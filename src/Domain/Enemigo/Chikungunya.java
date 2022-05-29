package Domain.Enemigo;

import Domain.Personaje;

public class Chikungunya extends Mosquito {

	public Chikungunya(double posX, double posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}



	@Override
	void efecto() {
		// TODO Auto-generated method stub
		
	}



	@Override
	void daño(boolean colision, Personaje personaje) {
		if (colision) {
			if (isGenero()) {
				personaje.setVida(personaje.getVida()-10);
				setContidadPicaduras(getContidadPicaduras()+1);
			} 
		}
		
	}



	

}
