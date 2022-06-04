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
			
			//System.out.println(th);
			if (getContador() == 0) {
				for (int i = 0; i < cantidadPicaduras; i++) {
					
					personaje.setVelocidad(2);
				}
			}
			
			if (getContador() == 10) {
				setContador(1);
				personaje.setVelocidad(6);
			
			}
		}
		
	}

	@Override
	void danio( Personaje personaje) {
		
			if (isHembra()) {
				personaje.setVida(personaje.getVida()-15);
				setCantidadPicaduras(getCantidadPicaduras()+1);
				} 
		}		
	
	
}
