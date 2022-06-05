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
			if (getContador()<20) {
				//this.thread.st
			personaje.setDireccion(-1);
			}else {
				setContador(0);
				personaje.setDireccion(1);
			
			}
		}
			
		}


 
	@Override
	void danio( Personaje personaje) {
		
			if (isHembra()) {
				personaje.setVida(personaje.getVida()-10);
				
			} 
	
	}

	

}
