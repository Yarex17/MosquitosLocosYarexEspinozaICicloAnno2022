package Domain.Enemigo;

import Domain.Personaje;

public class Chikungunya extends Mosquito implements Runnable{
	private Thread thread;
	public Chikungunya(double posX, double posY) {
		
		super(posX, posY);
		this.thread=new Thread(this);
		this.thread.start();
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
				this.thread.interrupt();
			}
		}
			
		}


 
	@Override
	void danio( Personaje personaje) {
		
			if (isHembra()) {
				personaje.setVida(personaje.getVida()-10);
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
