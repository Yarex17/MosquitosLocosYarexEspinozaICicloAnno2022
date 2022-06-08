package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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
	private JLabel jlbNombre, jlbTabla, jlbNombreJuego,jlbMensaje;
	public JButton jbIniciar;

	private JTable jtbJugadores;
	private DefaultTableModel dtmJugadores;

	
	public JFLogin(int puntos,String nombre) {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(800, 600));
		this.setFocusable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JugadorBusiness jugadorBusiness = new JugadorBusiness();
		try {
			jugadorBusiness.guardarJugador(new Usuario(nombre, puntos));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     init();
        cargarTabla();
		this.setVisible(true);
	}
	
	
	public JFLogin( ) {
		
        this.setLayout(null);
		this.setSize(800,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    init();
        cargarTabla();
		this.setVisible(true);
	}

	private void init() {
		this.setLayout(null);

		this.jlbNombre = new JLabel("Nombre Jugador:");
		this.jlbNombre.setBounds(250, 100, 100, 20);
		this.add(this.jlbNombre);
		
		
		this.jlbMensaje = new JLabel("Ingrese un nombre de usuario");
		this.jlbMensaje.setForeground(Color.red);
		this.jlbMensaje.setBounds(250, 100, 100, 50);
		this.jlbMensaje.setVisible(false);
		this.add(this.jlbMensaje);

		this.jlbNombreJuego = new JLabel("Mosquitos Locos");
		this.jlbNombreJuego.setBounds(250, 20, 300, 75);
		this.jlbNombreJuego.setFont(new Font("Tahoma", Font.BOLD, 30));
		this.add(this.jlbNombreJuego);

		this.jlbTabla = new JLabel("Ranking");
		this.jlbTabla.setBounds(325, 200, 100, 50);
		this.jlbTabla.setFont(new Font("Tahoma", Font.BOLD, 24));
		this.add(this.jlbTabla);

		this.jtfNombre = new JTextField();
		this.jtfNombre.setBounds(350, 100, 100, 20);
		this.add(this.jtfNombre);

		this.jbIniciar = new JButton("Iniciar Juego");
		this.jbIniciar.setBounds(300, 175, 150, 20);
		this.jbIniciar.addActionListener(this);
		this.add(jbIniciar);

		this.dtmJugadores = new DefaultTableModel();

		this.jtbJugadores = new JTable(this.dtmJugadores);
		this.jtbJugadores.setBounds(200, 300, 270, 250);

		JScrollPane jscrollPane = new JScrollPane(this.jtbJugadores);
		jscrollPane.setBounds(250, 250, 270, 250);
		this.add(jscrollPane);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.jbIniciar) {
			if (this.jtfNombre.getText().trim().isEmpty()) {
				this.jlbMensaje.setVisible(true);
			}else {
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
			

	}

	public void cargarTabla() {

		try {
			System.out.println("entra");
			JugadorBusiness jugadorBusiness = new JugadorBusiness();

			this.dtmJugadores.addColumn("Nombre");
			this.dtmJugadores.addColumn("Puntos");
//jugadorBusiness.guardarJugador(new Usuario("Pedro", 100));
			List<Usuario> jugadores;
			jugadores = jugadorBusiness.obtenerJugador();
			if (!jugadores.isEmpty()) {
				for (int i = 0; i < jugadores.size(); i++) {
					this.dtmJugadores.addRow(new Object[] { jugadores.get(i).getNombre(), jugadores.get(i).getPuntos()});
				} // for	
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
