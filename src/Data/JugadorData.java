package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Domain.Jugador;

public class JugadorData {
	private String ruta;
public JugadorData() {
	this.ruta="RankingJudadores.dat";

}
public void guardarJugador(Jugador jugador) throws ClassNotFoundException, IOException {
	File file=new File(this.ruta);	
	List<Jugador> jugadores=new ArrayList<Jugador>();
	if(file.exists()) {
		ObjectInputStream input=new ObjectInputStream(new FileInputStream(file));
		Object aux=input.readObject();
		jugadores=(List<Jugador>)aux;
		input.close();
	}
	jugadores.add(jugador);
	ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(file));
	output.writeUnshared(jugadores);
	output.close();
}

public List<Jugador> obtenerJugadores() throws ClassNotFoundException, IOException{
	File file=new File(this.ruta);
	List<Jugador> jugadores=new ArrayList<Jugador>();
	if(file.exists()) {
		ObjectInputStream input=new ObjectInputStream(new FileInputStream(file));
		Object aux=input.readObject();
		jugadores=(List<Jugador>)aux;
		input.close();
		return jugadores;
	}
	return null;
} // obtenerProductos
}
