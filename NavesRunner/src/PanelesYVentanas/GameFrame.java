package PanelesYVentanas;

import ObjetosYNaves.*;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import GmailYBd.BaseDeDatos;
import Hitbox.CircleHitbox;

public class GameFrame extends JFrame {

	//private JLabel score;
	private JPanel pJuego;
	private Nave nave;
	private ArrayList<Asteroide> ast;
	private double puntuacion;
	private boolean acabado;
	private boolean subiendo = false;
	private boolean bajando = false;
	private boolean acelera = false;
	private boolean frena = false;
	private JLabel score;
	
	/**
	 *  Constructor de la ventana de juego con escuchadores
	 */
	public GameFrame() {
		
		
		pJuego = new JPanel();
		pJuego.setLayout(null);
		score = new JLabel("Puntuacion: ");
		pJuego.add(score);
		score.setBounds(5, 5,100, 25);
		Constantes.OB_VEL = -20;
		
		this.setSize(Constantes.FRAME_ANCHO, Constantes.FRAME_ALTO);
		this.getContentPane().add(pJuego, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				subiendo = false;
				bajando = false;
				acelera = false;
				frena = false;
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					subiendo = true;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					bajando = true;
				}else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					frena = true;
				}else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					acelera = true;
				}
			}
		});
		
		
		acabado = false;
		
		this.setVisible(true);
	}
	
	/**
	 * Main principal de la ventana de juego
	 */
	public static void main () { 
		GameFrame g = new GameFrame();
		g.crearNaveyAst();
		g.jugar();
	}
	
	
	/**
	 * Funcion que inicia los arrays de naves y asteroides
	 */
	public void crearNaveyAst() {
		nave = new Nave(0, Constantes.POS_INICIAL_ALTO, Constantes.OB_VEL);
		pJuego.add(nave.getJLabel()); 
		ast = new ArrayList<Asteroide>();
	}
	
	/**
	 * Funcion que inicia el bucle principal de juego
	 */
	public void jugar() { // bucle principal
	
		int i;
		puntuacion = 0.0;
		Random r = new Random();
		Long time = System.currentTimeMillis();
		Thread gestionTeclados = new Thread(new Runnable() {
			@Override
			public void run() {
				
				while (acabado != true) {
					
					if (bajando == true) {
						nave.mueve(-Constantes.TASA_REFRESCO/35.0);
					} else if (subiendo == true) {
						nave.mueve(Constantes.TASA_REFRESCO/35.0);
					} else if (acelera == true) {
						Constantes.OB_VEL -= 5;
						for (Asteroide a: ast) {
							a.setVel(Constantes.OB_VEL);
						}
					} else if (frena == true) {
						Constantes.OB_VEL += 5;
						for (Asteroide a: ast) {
							a.setVel(Constantes.OB_VEL);
						}
					}
					
					
					try {
						Thread.sleep(Constantes.TASA_REFRESCO*3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}
		});
		gestionTeclados.start();
		
		while (acabado == false) {
			
			puntuacion = (System.currentTimeMillis() - time)/1000 * Constantes.INC_PUNT;
			score.setText("Puntuacion: " + puntuacion);
			
			if (r.nextInt(100) < Constantes.PROB_AST) {
				Asteroide a = new Asteroide(Constantes.FRAME_ANCHO, r.nextInt(Constantes.FRAME_ALTO), Constantes.OB_VEL);
				ast.add(a);
				pJuego.add(a.getLabel());
			}
			
			for (Asteroide a: ast) {

				a.mueve(Constantes.TASA_REFRESCO/85.0);
				if (a.getHitbox().hayChoqueHitbox(nave.getHitbox()) == true) {
					acabado = true;
					String opciones[] = { "Guardar(solo si es mas alta) y jugar", "Jugar de nuevo", "Salir", "Tabla de puntuaciones"};
					int x = JOptionPane.showOptionDialog(pJuego, "Tu puntuacion ha sido de " + puntuacion + "\n. Deseas guardar los resultados ? ",
							"Game Over", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
							null, opciones, opciones[0]);
					
					if (x == 0) {
						
						if (BaseDeDatos.actualizarPuntuacion(LoginFrame.getNick(), puntuacion) == false) {
							JOptionPane.showMessageDialog(this, "Error al actualizar la puntuación. Se cerrara el programa");
						} else {
							(new Thread() {
								@Override
								public void run() {
									dispose();
									GameFrame.main();
									super.run();
								}
							}).start();
						}
						
						// Guardamos en BD y llamamos a gameframe otra vez
						
						
						
						
					} else if (x == 1) {
						// llamamos a gameframe
						(new Thread() {
							@Override
							public void run() {
								dispose();
								GameFrame.main();
								super.run();
							}
						}).start();
						
					} else if (x == 3) {
						FramePuntuaciones f = new FramePuntuaciones();
						dispose();
					} else {
						dispose();
					}
				}
			}
			
			
			for (Asteroide a: ast) { // Los que se salen de la pantalla se borran
				for (i = 0; i< ast.size(); i++) {
					if (a.equals(ast.get(i)) == true) {
						if (a.getPosY() <= - Constantes.RAD_HIT_AST)
							ast.remove(i);	
					}
				}
			}
			pJuego.repaint();
			
			try {
				Thread.sleep(Constantes.TASA_REFRESCO);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
