package Domain.Enemigo;

import Domain.Personaje;

public class Zika extends Mosquito {

	public Zika(double posX, double posY) {
		super(posX, posY);
		if (hembra) {
			this.valor=6;
		}else {
			this.valor=1;
		}
	}

	

	@Override
	void efecto(Personaje personaje) {
		// TODO Auto-generated method stub
		
	}



	@Override
	void danio( Personaje personaje) {
		
			if (isHembra()) {
				personaje.setVida(personaje.getVida()-15);
				setContidadPicaduras(getContidadPicaduras()+1);
			} 
		}		
	

}
