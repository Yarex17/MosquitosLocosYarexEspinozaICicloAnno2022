package Domain.Enemigo;

import Domain.Personaje;

public class Zika extends Mosquito implements Runnable{
	private Thread thread;
	//this.thread=new Thread(this);
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

	
public void contadorSegundos() {
	setContador(getContador()+1);
	System.out.println(getContador());
}
	@Override
	void efecto(Personaje personaje) {
	

		if (isHembra()) {
			
			if (getContador() == 1) {
				for (int i = 0; i < cantidadPicaduras; i++) {
					System.out.println(i);
					personaje.setVelocidad(personaje.getVelocidad()-1);
				}
			}
			
			if (getContador() == 10) {
				setContador(1);
				personaje.setVelocidad(6);
				setPico(false);
				//System.out.println(this.thread.isInterrupted());
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
	while (contador!=10&&isPico()) {
		contadorSegundos();
		try {
			this.thread.sleep(500);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	}
}
