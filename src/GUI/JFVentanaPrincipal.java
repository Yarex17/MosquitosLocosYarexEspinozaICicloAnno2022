package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class JFVentanaPrincipal extends JFrame {
	
	JPAeaDeJuego jpAeaDeJuego;
	JPLogin jifLogin ;
	public JFVentanaPrincipal() {
		this.setSize(816,639);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.jpAeaDeJuego = new JPAeaDeJuego();
		this.jifLogin =new JPLogin();
		this.add(jifLogin);
		this.add(jpAeaDeJuego);
		
	
	}
	
//	public void cambioEscena(){
//		if(!jpAeaDeJuego.cambio()) {
//			this.jifLogin.setVisible(false);
//		}
//			
//		
//	}
}
