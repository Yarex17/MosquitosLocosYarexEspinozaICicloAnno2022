package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class JFVentanaPrincipal extends JFrame  {



	JIFLogin jifLogin ;
	
	public JFVentanaPrincipal() {
		this.setSize(816,639);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.jifLogin= new JIFLogin();
		init();
		this.setLocationRelativeTo(null);
	}
private void init() {
	//this.add(this.jpAeaDeJuego);
	this.add(jifLogin);
	
	
}
	

}
