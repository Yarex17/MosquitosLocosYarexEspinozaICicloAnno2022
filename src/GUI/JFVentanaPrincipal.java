package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class JFVentanaPrincipal extends JFrame {

	JFLogin jifLogin;
	JPAeaDeJuego jpAeaDeJuego;

	public JFVentanaPrincipal(String nombre) {
		this.setSize(816, 635);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.jpAeaDeJuego = new JPAeaDeJuego(this, nombre);
		add(this.jpAeaDeJuego);
		// this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
