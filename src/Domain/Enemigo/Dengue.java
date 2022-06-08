package Domain.Enemigo;

import Domain.Personaje;

public class Dengue extends Mosquito {

	public Dengue(double posX, double posY) {

		super(posX, posY);

		if (hembra) {
			this.valor = 2;
		} else {
			this.valor = 1;
		}

	}

	@Override
	void efecto(Personaje personaje) {
		if (isHembra()) {
			if (personaje.getPicaduraDegue() == 2) {
				personaje.setVida(0);
			}
		}

	}

	@Override
	void danio(Personaje personaje) {

		if (isHembra()) {
			personaje.setVida(personaje.getVida() - 5);
			personaje.setPicaduraDegue(personaje.getPicaduraDegue() + 1);
		}
	}

}
