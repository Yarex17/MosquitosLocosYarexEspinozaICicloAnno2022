package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Business.JugadorBusiness;

import Domain.Usuario;

public class JFLogin extends JFrame implements ActionListener {
	private JTextField jtfNombre;
	private JLabel jlbNombre, jlbTabla, jlbNombreJuego, jlbMensaje;
	public JButton jbIniciar, jbVerTabla;

	private JTable jtbJugadores;
	private DefaultTableModel dtmJugadores;
	private JScrollPane jscrollPane;
	private Fondo fondo;
	boolean b = false;

	public JFLogin(int punto, String nombre) {
		this.setLayout(null);
		// this.setPreferredSize(new Dimension(800, 600));
		this.setSize(new Dimension(800, 600));
		this.setFocusable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JugadorBusiness jugadorBusiness = new JugadorBusiness();
		try {
			jugadorBusiness.actualizarUsuario(new Usuario(nombre, punto));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.fondo = new Fondo();
		this.setContentPane(this.fondo);
		init();
		cargarTabla();

		this.setVisible(true);
	}

	public JFLogin() {

		this.setLayout(null);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.fondo = new Fondo();
		this.setContentPane(this.fondo);
		init();
		cargarTabla();

		this.setVisible(true);
	}

	private void init() {
		this.setLayout(null);

		this.jlbNombre = new JLabel("Nombre Jugador:");
		this.jlbNombre.setForeground(Color.white);
		this.jlbNombre.setBounds(250, 100, 100, 20);
		this.add(this.jlbNombre);

		this.jlbMensaje = new JLabel("Ingrese un nombre de usuario");
		this.jlbMensaje.setForeground(Color.red);
		this.jlbMensaje.setBounds(250, 100, 200, 50);
		this.jlbMensaje.setVisible(false);
		this.add(this.jlbMensaje);

		this.jlbNombreJuego = new JLabel("Mosquitos Locos");
		this.jlbNombreJuego.setBounds(250, 20, 300, 75);
		this.jlbNombreJuego.setForeground(Color.white);
		this.jlbNombreJuego.setFont(new Font("Tahoma", Font.BOLD, 30));
		// this.add(this.jlbNombreJuego);

		this.jlbTabla = new JLabel("Ranking");
		this.jlbTabla.setBounds(325, 200, 100, 50);
		this.jlbTabla.setForeground(Color.white);
		this.jlbTabla.setVisible(false);
		this.jlbTabla.setFont(new Font("Tahoma", Font.BOLD, 24));
		this.add(this.jlbTabla);

		this.jtfNombre = new JTextField();
		this.jtfNombre.setBounds(350, 100, 100, 20);
		this.add(this.jtfNombre);

		this.jbIniciar = new JButton("Iniciar Juego");
		this.jbIniciar.setBounds(150, 150, 150, 20);
		this.jbIniciar.addActionListener(this);
		this.add(jbIniciar);

		this.jbVerTabla = new JButton("Ver Ranking");
		this.jbVerTabla.setBounds(450, 150, 150, 20);
		this.jbVerTabla.addActionListener(this);
		this.add(jbVerTabla);

		this.dtmJugadores = new DefaultTableModel();

		this.jtbJugadores = new JTable(this.dtmJugadores);
		this.jtbJugadores.setBounds(200, 300, 270, 250);
		// this.jtbJugadores.setVisible(false);

		this.jscrollPane = new JScrollPane(this.jtbJugadores);
		this.jscrollPane.setBounds(250, 250, 270, 250);
		this.jscrollPane.setVisible(false);
		this.add(jscrollPane);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.jbIniciar) {
			if (this.jtfNombre.getText().trim().isEmpty()) {
				this.jlbMensaje.setVisible(true);
			} else {
				try {
					JugadorBusiness jugadorBusiness = new JugadorBusiness();
					jugadorBusiness.guardarJugador(new Usuario(this.jtfNombre.getText(), 0));
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new JFVentanaPrincipal(this.jtfNombre.getText());
				this.dispose();

			}
		}

		if (e.getSource() == this.jbVerTabla) {

			if (!b) {
				b = true;
				this.jlbTabla.setVisible(true);
				this.jscrollPane.setVisible(true);
			} else {
				b = false;
				this.jlbTabla.setVisible(false);
				this.jscrollPane.setVisible(false);
			}
		}
	}

	public void cargarTabla() {
		try {

			this.dtmJugadores.addColumn("Nombre");
			this.dtmJugadores.addColumn("Puntos");

			List<Usuario> usuarios = new JugadorBusiness().obtenerJugador();
			if (usuarios != null) {
				this.dtmJugadores.setRowCount(0);

				for (int i = 0; i < usuarios.size(); i++) {
					this.dtmJugadores.addRow(new Object[] { usuarios.get(i).getNombre(), usuarios.get(i).getPunto(), });
				} // for
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // cargarTabla

}

class Fondo extends JPanel {

	private BufferedImage imagen;

	public Fondo() {
		try {
			this.imagen = ImageIO.read(getClass().getResourceAsStream("/Assets/FondoMosquitosLogos.png"));
			this.imagen.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
//https://scontent.fsyq1-1.fna.fbcdn.net/v/t1.18169-9/12246741_1053863091341248_3369155199076795932_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=e3f864&_nc_ohc=zb1_1u-MXCcAX8PlmGY&_nc_ht=scontent.fsyq1-1.fna&oh=00_AT8JZyP3UxvsX3jcwuJf2WMRj2ZQdK8LV9JQBRbIhTJQ8g&oe=62C6A378
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSize(800, 600);
		setVisible(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(this.imagen, 0, 0, getWidth(), getHeight(), this);
	}

}
