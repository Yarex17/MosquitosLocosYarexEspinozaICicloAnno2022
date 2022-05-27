package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import Domain.Criadero.Criadero;
import Domain.Enemigo.Dengue;
import Domain.Enemigo.Mosquito;
import Domain.Enemigo.Zika;

public class Cuadra extends Ciudad {
private ArrayList<Edificacion> edificacions;
//private ArrayList<Criadero> criaderos;
//private ArrayList<Mosquito> mosquitos;
	
	public Cuadra() {
		super(nivel);
		this.edificacions=new ArrayList<Edificacion>();
		Ciudad.criaderos=new ArrayList<Criadero>();
		///this.mosquitos=new ArrayList<Mosquito>();
        this.mosquitos.add(new Dengue(200, 300));
        this.mosquitos.add(new Zika(400, 300));
		generarEdificaciones();
		generarCriadero();
	}
	public void generarEdificaciones() {
		for (int i = 0; i < 3; i++) {
			this.edificacions.add(new Edificacion(40*i, 40*i));
		}
	}
	@Override
	public void generarCriadero() {
	for (int i = 0; i < 3; i++) {
		Ciudad.criaderos.add(FabricaCriaderos.crearCriaderoInterno(i+1));
		//Ciudad.mosquitos.add(Ciudad.criaderos.get(i).generaMosquitos());
	}
		
	}

	@Override
	public void dibujar(Graphics g) {
		switch (Ciudad.nivel) {
		case 1:
			g.setColor(Color.RED);
			break;
		case 2:
			g.setColor(Color.blue);
			break;
		case 3:
			g.setColor(Color.ORANGE);
			break;

		default:
			break;
		}
		g.fillRect(0,0, 800, 600);
		
		for (int i = 0; i < 3; i++) {
			Ciudad.criaderos.get(i).dibujar(g);
		
		}
		for (int i = 0; i < 3; i++) {
			this.edificacions.get(i).dibujar(g);
		}
		for (int i = 0; i < criaderos.size(); i++) {
			
		}
	}

}
