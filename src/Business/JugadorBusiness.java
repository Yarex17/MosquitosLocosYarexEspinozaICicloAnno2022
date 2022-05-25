package Business;

import java.io.IOException;
import java.util.List;

import Data.JugadorData;
import Domain.Jugador;

public class JugadorBusiness {
	private JugadorData jugadorData;
public JugadorBusiness() {
	this.jugadorData=new JugadorData();
}
public void  guardarJugador(Jugador jugador) throws ClassNotFoundException, IOException{
	if (jugador!=null) {
		this.jugadorData.guardarJugador(jugador);
	}else {
		throw new IOException("Objeto no existen");	}
	
}
public List<Jugador> obtenerJugador()throws ClassNotFoundException, IOException{
	return this.jugadorData.obtenerJugadores();
}
}
