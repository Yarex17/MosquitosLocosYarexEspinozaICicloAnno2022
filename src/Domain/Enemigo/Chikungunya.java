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
	public void contadorSegundos() {
		setContador(getContador()+1);
	}
		@Override
		void efecto(Personaje personaje) {
		if (isHembra()) {
			personaje.setDireccion(-1);
			}
		}
			
		


 
	@Override
	void danio( Personaje personaje) {
		
			if (isHembra()) {
				personaje.setColisionChinkunguya(true);
				personaje.setVida(personaje.getVida()-10);
				
			} 
	
	}

	

}
