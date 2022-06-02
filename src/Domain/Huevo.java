package Domain;

public class Huevo extends Thread {
private boolean eclosion;
private int tiempoeclosion;
private Thread thread;
private int contadorsegudos;

public Huevo() {
	this.tiempoeclosion=60;
	this.eclosion=false;
	this.thread=new Thread(this);
	this.thread.start();
	this.contadorsegudos=0;
	
}
public Huevo(int tiempo) {
	this.tiempoeclosion=tiempo;
	this.eclosion=false;
	this.thread=new Thread(this);
	this.thread.start();
	this.contadorsegudos=0;
}



public void eclosion() {
setContadorsegudos(getContadorsegudos()+1);

	if (getContadorsegudos()==getTiempoeclosion()) {
		setEclosion(true);

	}
	}
@Override
public void run() {
	
		while (true) {
			
			eclosion();
			try {
				thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
}

public boolean isEclosion() {
	return eclosion;
}
public void setEclosion(boolean eclosion) {
	this.eclosion = eclosion;
}
public int getTiempoeclosion() {
	return tiempoeclosion;
}
public void setTiempoeclosion(int tiempoeclosion) {
	this.tiempoeclosion = tiempoeclosion;
}
public int getContadorsegudos() {
	return contadorsegudos;
}
public void setContadorsegudos(int contadorsegudos) {
	this.contadorsegudos = contadorsegudos;
}

}
