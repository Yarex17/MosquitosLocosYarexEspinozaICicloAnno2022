package Domain;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import Domain.Criadero.Criadero;
import Domain.Enemigo.Mosquito;

public class Cuadra {
	private double posY, posX;
	private Edificio edificio1;
	private Edificio edificio2;
	private ArrayList<Criadero> criaderos;
	private ArrayList<Mosquito> mosquitos;
	private ArrayList<Bala> balas;
	private int nivel;
	private ArrayList<Cargador> cargadores;
	private Personaje personaje;
	protected BufferedImage imagen;
	private Cuadra cuadra;

	public Cuadra(int nivel, Personaje personaje) {

		this.personaje = personaje;
		this.nivel = nivel;
		this.posY = 0;
		this.posX = 0;
		this.edificio1 = new Edificio(639, 187, this.nivel, personaje);
		this.edificio2 = new Edificio(82, 492, this.nivel, personaje);
		this.criaderos = new ArrayList<Criadero>();
		this.mosquitos = new ArrayList<Mosquito>();
		this.balas = new ArrayList<Bala>();
		this.cargadores = new ArrayList<Cargador>();
		generarCriadero();

		try {
			switch (this.nivel) {
			case 1:
				this.imagen = ImageIO.read(getClass().getResourceAsStream("/Assets/nvel1.png"));
				break;
			case 2:
				this.imagen = ImageIO.read(getClass().getResourceAsStream("/Assets/nivel2.png"));
				break;
			case 3:
				this.imagen = ImageIO.read(getClass().getResourceAsStream("/Assets/nivel3.png"));
				break;

			default:
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void generarMosquito() {
		for (int i = 0; i < this.criaderos.size(); i++) {
			this.criaderos.get(i).generarMosquitos(mosquitos);
		}
	}

	public void generarCriadero() {
		for (int i = 0; i < 3 * this.nivel; i++) {
			this.criaderos.add(FabricaCriadero.crearCriaderoExterno((int) (Math.random() * 3 + 1)));
		}
	}

	public void actualizar() {

		if (this.edificio1.isEntra()) {
			this.edificio1.collison(personaje);
		} else {
			if (this.edificio2.isEntra()) {
				this.edificio2.collison(personaje);
			} else {
				this.edificio1.collison(personaje);
				this.edificio2.collison(personaje);
			}

		}

		if (!this.edificio1.isEntra() && !this.edificio2.isEntra()) {
			generarMosquito();
			for (int i = 0; i < this.mosquitos.size(); i++) {
				this.mosquitos.get(i).movimiento();
				this.mosquitos.get(i).colision(personaje);
			}

			for (int i = 0; i < this.cargadores.size(); i++) {

				if (this.personaje.colision(this.cargadores.get(i))) {

					for (int j = 0; j < this.edificio1.getCargadores().size(); j++) {
						this.edificio1.getCargadores().remove(j);
					}
					for (int j = 0; j < this.edificio2.getCargadores().size(); j++) {
						this.edificio2.getCargadores().remove(j);
					}

					this.cargadores.remove(i);
				}

			}

			if (this.personaje.getCantidaBalas() <= 4) {
				if (this.cargadores.size() == 0) {
					this.cargadores.add(new Cargador());

				}

			}

			for (int j = 0; j < this.balas.size(); j++) {
				this.balas.get(j).mover();

				if (this.balas.get(j).getInicioY() == 0 || this.balas.get(j).getInicioY() == 600
						|| this.balas.get(j).getInicioX() == 0 || this.balas.get(j).getInicioX() == 700) {
					this.balas.remove(j);
				}
				for (int i = 0; i < this.criaderos.size(); i++) {
					this.balas.get(j).trayectoria(this.criaderos.get(i));
				}
				for (int i = 0; i < this.mosquitos.size(); i++) {
					if (this.balas.get(j).colision(this.mosquitos.get(i))) {// falta colocar rango pero hagamos pruebas
						this.balas.remove(j);
						personaje.setPunto(personaje.getPunto() + this.mosquitos.get(i).getValor());
						this.mosquitos.remove(i);
						return;
					}

				}

			}

			for (int j = 0; j < this.balas.size(); j++) {
				this.balas.get(j).mover();
				for (int i = 0; i < this.criaderos.size(); i++) {
					if (this.balas.get(j).colision(this.criaderos.get(i))) {// falta colocar rango pero hagamos pruebas
						this.balas.remove(j);
						personaje.setPunto(personaje.getPunto() + this.criaderos.get(i).getValor());
						this.criaderos.remove(i);

						return;
					}

				}

			}

		} else {
			if (this.edificio1.isEntra()) {
				this.edificio1.actualizar();
			} else {
				if (this.edificio2.isEntra()) {
					this.edificio2.actualizar();
					;
				}
			}
		}
	}

	public void disparar(int posX, int posY) {
		for (int i = 0; i < this.criaderos.size(); i++) {
			if (this.personaje.Rango(this.criaderos.get(i))) {
				Bala bala = this.personaje.disparar(posX, posY);
				if (bala != null) {
					this.balas.add(bala);
					return;
				}
			}
		}
		for (int i = 0; i < this.mosquitos.size(); i++) {
			if (this.personaje.Rango(this.mosquitos.get(i))) {
				Bala bala = this.personaje.disparar(posX, posY);
				if (bala != null) {
					this.balas.add(bala);
					return;
				}
			}
		}
	}

	public void dibujar(Graphics g) {

		g.drawImage(this.imagen, (int) this.posX, (int) this.posY, null);

		if (this.edificio1.isEntra()) {
			this.edificio1.dibujar(g);
		} else {

			if (this.edificio2.isEntra()) {
				this.edificio2.dibujar(g);
			} else {
				this.edificio1.dibujar(g);
				this.edificio2.dibujar(g);
				for (int i = 0; i < this.criaderos.size(); i++) {
					this.criaderos.get(i).dibujar(g);

				}
				for (int i = 0; i < this.mosquitos.size(); i++) {
					this.mosquitos.get(i).dibujar(g);

				}
				for (int i = 0; i < this.balas.size(); i++) {
					this.balas.get(i).dibujar(g);

				}
				for (int i = 0; i < this.cargadores.size(); i++) {
					this.cargadores.get(i).dibujar(g);

				}
			}
		}

	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public ArrayList<Criadero> getCriaderos() {
		return criaderos;
	}

	public void setCriaderos(ArrayList<Criadero> criaderos) {
		this.criaderos = criaderos;
	}

	public ArrayList<Mosquito> getMosquitos() {
		return mosquitos;
	}

	public void setMosquitos(ArrayList<Mosquito> mosquitos) {
		this.mosquitos = mosquitos;
	}

	public Edificio getEdificio1() {
		return edificio1;
	}

	public void setEdificio1(Edificio edificio1) {
		this.edificio1 = edificio1;
	}

	public Edificio getEdificio2() {
		return edificio2;
	}

	public void setEdificio2(Edificio edificio2) {
		this.edificio2 = edificio2;
	}

	public ArrayList<Cargador> getCargadores() {
		return cargadores;
	}

	public void setCargadores(ArrayList<Cargador> cargadores) {
		this.cargadores = cargadores;
	}

}
