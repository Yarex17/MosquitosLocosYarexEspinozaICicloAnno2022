package Business;

import java.io.IOException;
import java.util.List;

import Data.JugadorData;
import Domain.Usuario;

public class JugadorBusiness {
	private JugadorData jugadorData;
public JugadorBusiness() {
	this.jugadorData=new JugadorData();
}
public void  guardarJugador(Usuario jugador) throws ClassNotFoundException, IOException{
	if (jugador!=null) {
		this.jugadorData.guardarJugador(jugador);
	}else {
		throw new IOException("Objeto no existen");	}
	
}
public List<Usuario> obtenerJugador()throws ClassNotFoundException, IOException{
	return this.jugadorData.obtenerJugadores();
}
}
