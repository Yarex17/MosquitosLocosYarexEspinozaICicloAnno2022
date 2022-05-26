package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class JFVentanaPrincipal extends JFrame  {
	
	JPAeaDeJuego jpAeaDeJuego;
	JIFLogin jifLogin ;
	
	public JFVentanaPrincipal() {
		this.setSize(816,639);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		this.add(new JPAeaDeJuego());
		//init();
		//this.add(new JPAeaDeJuego());
		this.setLocationRelativeTo(null);
	}
	private void init() {
		
	}
	

}
