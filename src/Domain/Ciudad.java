package Domain;

import java.awt.Graphics;
import java.util.ArrayList;

import Domain.Criadero.Criadero;
import Domain.Enemigo.Mosquito;

public  abstract class Ciudad {
	protected static int nivel;
	protected static ArrayList<Criadero> criaderos;
	public static ArrayList<Mosquito> mosquitos;
public Ciudad(int nivel) {
	Ciudad.nivel=1;
	Ciudad.criaderos= new ArrayList<Criadero> ();
	Ciudad.mosquitos=new ArrayList<Mosquito>();
}


public abstract void generarCriadero();
public abstract void dibujar(Graphics g) ;

}
