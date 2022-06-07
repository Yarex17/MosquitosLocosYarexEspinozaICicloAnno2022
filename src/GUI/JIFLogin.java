package GUI;

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

import Domain.Jugador;


public class JIFLogin extends JPanel implements ActionListener {
	private JTextField jtfNombre;
	private JLabel jlbNombre, jlbTabla, jlbNombreJuego;
	public JButton jbIniciar;

	private JTable jtbJugadores;
	private DefaultTableModel dtmJugadores;
	private JFrame jFrame;
	private 	JPAeaDeJuego jpAeaDeJuego; 
	public JIFLogin() {
		
		this.setLayout(null);
		this.setBounds(0, 0, 800, 600);
	    this.setBorder(null);

		init();

		cargarTabla();
		this.setVisible(true);
	}

	private void init() {
		this.setLayout(null);

		this.jlbNombre = new JLabel("Nombre Jugador:");
		this.jlbNombre.setBounds(250, 100, 100, 20);
		this.add(this.jlbNombre);

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
//			this.jFrame.getContentPane().remove(this);
//			//this.jFrame.add(new JPAeaDeJuego());
//			
//			this.jFrame.invalidate();
//			this.jFrame.validate();
			this.jpAeaDeJuego=new JPAeaDeJuego();
			this.add(jpAeaDeJuego);
			System.out.println("entra");
			this.jpAeaDeJuego.iniciar();
		}

	}

	public void cargarTabla() {

		try {
			JugadorBusiness jugadorBusiness = new JugadorBusiness();

			this.dtmJugadores.addColumn("Nombre");
			this.dtmJugadores.addColumn("Puntos");
jugadorBusiness.guardarJugador(new Jugador("Pedro", 100));
			List<Jugador> jugadores;
			jugadores = jugadorBusiness.obtenerJugador();
			for (int i = 0; i < jugadores.size(); i++) {
				this.dtmJugadores.addRow(new Object[] { jugadores.get(i).getNombre(), jugadores.get(i).getPuntos(),

				});
			} // for
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
