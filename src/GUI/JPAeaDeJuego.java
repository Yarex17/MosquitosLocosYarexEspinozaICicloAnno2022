package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;

import Domain.Juego;

public class JPAeaDeJuego extends JPanel implements KeyListener,MouseListener,  Runnable {
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
	long start;
	long elapse;
	while (true) {

		start = System.nanoTime();
		repaint();
		elapse = System.nanoTime() - start;
		this.espera = this.time - elapse / 1000000;

		if (this.espera < 0) {
			this.espera = 5;
		} // if

		try {
			Thread.sleep(this.espera);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // try

	} // while

} // run
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		this.juego.getPersonaje().moverDerecha();;
	if(e.getKeyCode()==KeyEvent.VK_LEFT)
		this.juego.getPersonaje().moverIzquierda();
	if(e.getKeyCode()==KeyEvent.VK_UP)
		this.juego.getPersonaje().moverArriba();
	if(e.getKeyCode()==KeyEvent.VK_DOWN)
	this.juego.getPersonaje().moverAbajo();
	
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
