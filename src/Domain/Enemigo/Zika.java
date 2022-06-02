package Domain.Enemigo;

import Domain.Personaje;

public class Zika extends Mosquito implements Runnable{
	private Thread thread;
	public Zika(double posX, double posY) {
		
		super(posX, posY);
		this.thread=new Thread(this);
		this.thread.start();
		if (hembra) {
			this.valor=6;
		}else {
			this.valor=1;
		}
	}

	
public void contadorsegundos() {
	setContador(getContador()+1);
}
	@Override
	void efecto(Personaje personaje) {
if (isHembra()) {if (getContador()==0) {
	for (int i = 0; i < cantidadPicaduras; i++) {
		personaje.setVelocidad(personaje.getVelocidad()/2);
	}
	this.thread.start();
}
	if (getContador()<20) {
		
	}else {
		setContador(0);
		personaje.setVelocidad(6);
		this.thread.interrupt();
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
	
	@Override
	public void run() {
	while (true) {
		contadorSegundos();
		
		try {
			this.thread.sleep(1000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
}
