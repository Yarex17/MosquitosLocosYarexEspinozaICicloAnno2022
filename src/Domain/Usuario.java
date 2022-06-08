package Domain;

import java.io.Serializable;

public class Usuario implements Serializable {
	private String nombre;
	private int punto;

	public Usuario(String nombre, int punto) {

		this.nombre = nombre;
		this.punto = punto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPunto() {
		return punto;
	}

	public void setPunto(int puntos) {
		this.punto = puntos;
	}

}
