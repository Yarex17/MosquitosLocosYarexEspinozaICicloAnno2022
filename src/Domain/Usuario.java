package Domain;

import java.io.Serializable;

public class Usuario implements Serializable{
private String nombre;
private int puntos;

public Usuario(String nombre, int puntos)  {
	
	this.nombre = nombre;
	this.puntos = puntos;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getPuntos() {
	return puntos;
}
public void setPuntos(int puntos) {
	this.puntos = puntos;
}

}
