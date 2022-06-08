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

import Domain.Usuario;

public class JugadorData {
	private String ruta;
public JugadorData() {
	this.ruta="RankingJudadores.dat";

}
public void guardarJugador(Usuario jugador) throws ClassNotFoundException, IOException {
	File file=new File(this.ruta);	
	List<Usuario> jugadores=new ArrayList<Usuario>();
	if(file.exists()) {
		ObjectInputStream input=new ObjectInputStream(new FileInputStream(file));
		Object aux=input.readObject();
		jugadores=(List<Usuario>)aux;
		input.close();
	}
	jugadores.add(jugador);
	ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(file));
	output.writeUnshared(jugadores);
	output.close();
}

public List<Usuario> obtenerJugadores() throws ClassNotFoundException, IOException{
	File file=new File(this.ruta);
	List<Usuario> jugadores=new ArrayList<Usuario>();
	if(file.exists()) {
		ObjectInputStream input=new ObjectInputStream(new FileInputStream(file));
		Object aux=input.readObject();
		jugadores=(List<Usuario>)aux;
		input.close();
		return jugadores;
	}
	return null;
} // obtenerProductos
}
