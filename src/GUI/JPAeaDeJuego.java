package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;

import Domain.Juego;

public class JPAeaDeJuego extends JPanel implements KeyListener,MouseListener,  Runnable {
	
private Juego juego;
private Graphics2D graphics2d;
private BufferedImage buffer;

	private int FPS=60;
	private long time=1000/FPS;
	private Thread thread;
	private long espera;
public JPAeaDeJuego() {
	
	this.setLayout(null);
	this.setSize(800,600);
    //this.setBorder(null);
    this.setFocusable(true);
	this.setRequestFocusEnabled(true);
	this.addKeyListener(this);
	this.addMouseListener(this);
	this.juego=new Juego();

	//this.setVisible(true);
}
public void addNotify() {
	super.addNotify();
	if(this.thread==null) {
		this.thread=new Thread(this);
		this.thread.start();
	}
} // addNotify

private void drawToScreen() {
	Graphics g=this.getGraphics();
	g.drawImage(this.buffer, 0, 0, 800, 600, null);
	g.dispose();
}
private void init() {
	this.buffer=new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
	this.graphics2d=(Graphics2D)this.buffer.getGraphics();
} // init
private void update() {
	this.juego.actualizar();
}
private void draw() {
	this.graphics2d.setColor(new Color(39, 177, 30));
	this.graphics2d.fillRect(0, 0, 800, 600);
	this.juego.dibujar(this.graphics2d);
} // draw

@Override
public void run() {
	init();
	long start;
	long elapse;
	while (true) {

		start = System.nanoTime();
		update();
		draw();
		drawToScreen();
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
	if (e != null) {
		
		this.juego.disparar(e.getX(), e.getY());
	}
	
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

	
}
}
