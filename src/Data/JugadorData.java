package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import Domain.Usuario;

public class JugadorData {
	private String ruta;

	public JugadorData() {
		this.ruta = "RankingJudadores.dat";

	}

	public void actualizarUsuario(Usuario jugador) throws ClassNotFoundException, IOException {
		File file = new File(this.ruta);
		List<Usuario> jugadores = new ArrayList<Usuario>();
		if (file.exists()) {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			Object aux = input.readObject();
			jugadores = (List<Usuario>) aux;
			input.close();
		}
		for (int i = 0; i < jugadores.size(); i++) {
			if (jugadores.get(i).getNombre().equalsIgnoreCase(jugador.getNombre())) {
				if (jugadores.get(i).getPunto() < jugador.getPunto()) {
					jugadores.get(i).setPunto(jugador.getPunto());
				}

			}
		}

		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
		output.writeUnshared(jugadores);
		output.close();
	}

	public void guardarJugador(Usuario jugador) throws ClassNotFoundException, IOException {
		File file = new File(this.ruta);
		boolean existe = false;
		List<Usuario> jugadores = new ArrayList<Usuario>();
		if (file.exists()) {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			Object aux = input.readObject();
			jugadores = (List<Usuario>) aux;
			input.close();
		}
		for (int i = 0; i < jugadores.size(); i++) {
			if (jugadores.get(i).getNombre().equalsIgnoreCase((jugador.getNombre()))) {
				existe = true;

			}
		}
		if (!existe) {
			jugadores.add(jugador);
		}

		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
		output.writeUnshared(jugadores);
		output.close();
	}

	public List<Usuario> obtenerJugadores() throws ClassNotFoundException, IOException {
		File file = new File(this.ruta);
		List<Usuario> jugadores = new ArrayList<Usuario>();
		if (file.exists()) {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			Object aux = input.readObject();
			jugadores = (List<Usuario>) aux;

			for (int i = 0; i < jugadores.size(); i++) {
				for (int j = 0; j < jugadores.size() - 1; j++) {
					Usuario usuarioActual = jugadores.get(j);
					Usuario usuarioSiguiente = jugadores.get(j + 1);
					if (usuarioActual.getPunto() < usuarioSiguiente.getPunto()) {
						jugadores.set(j, usuarioSiguiente);
						jugadores.set(j + 1, usuarioActual);
						// usuarioSiguiente=jugadores.get(j+1);
					}

				}
			}

			input.close();
			return jugadores;
		}
		return null;
	} // obtenerProductos

}
