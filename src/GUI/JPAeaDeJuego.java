package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import Domain.Juego;

public class JPAeaDeJuego extends JPanel implements  Runnable {
private Juego juego;

	private int FPS=60;
	private long time=1000/FPS;
	private Thread thread;
	private long espera;
public JPAeaDeJuego() {
	this.juego=new Juego();
	this.setLayout(null);
	this.setSize(800,600);
    this.setBorder(null);
	this.setVisible(true);
//	this.addKeyListener(this);
	//this.addMouseListener(this);
}
public void addNotify() {
	super.addNotify();
	if(this.thread==null) {
		this.thread=new Thread(this);
		this.thread.start();
	}
} // addNotify

public void paintComponent(Graphics g) {
	this.juego.dibujar(g);
	g.setColor(new Color(39, 100, 30));
	g.fillRect(0, 0, 40, 40);
	

	//this.juego.actualizar();
}
public boolean cambio() {
	return false;
}
@Override
public void run() {
	// TODO Auto-generated method stub
	
}
}
