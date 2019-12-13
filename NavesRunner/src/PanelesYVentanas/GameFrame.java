package PanelesYVentanas;

import ObjetosYNaves.*;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameFrame extends JFrame {

	//private JLabel score;
	private JPanel pJuego;
	private Nave nave;
	private ArrayList<Asteroide> ast;
	private boolean acabado;
	
	public GameFrame() {
		
		pJuego = new JPanel();
		pJuego.setLayout(null);
		
		this.setSize(Constantes.FRAME_ANCHO, Constantes.FRAME_ALTO);
		this.getContentPane().add(pJuego, BorderLayout.CENTER);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		
		acabado = false;
		
		this.setVisible(true);
	}
	
	public static void main () { 
		GameFrame g = new GameFrame();
		g.crearNaveyAst();
		g.jugar();
	}
	
	public void crearNaveyAst() {
		nave = new Nave(0, Constantes.POS_INICIAL_ALTO, 0);
		pJuego.add(nave.getJLabel()); 
		ast = new ArrayList<Asteroide>();
	}
	
	public void jugar() { // bucle principal
	
		Random r = new Random();
		Long time = System.currentTimeMillis();
		
		while (true) {
			
			if (r.nextInt(100) < 30) {

				Asteroide a = new Asteroide(500, r.nextInt(Constantes.FRAME_ALTO), -Constantes.OB_VEL);
				ast.add(a);
				pJuego.add(a.getLabel());
				//a.getLabel().setLocation(500, 462);
				System.out.println(a.getLabel().getBounds());
			}
			
			for (Asteroide a: ast) {

				a.mueve(Constantes.TASA_REFRESCO/100.0);
			
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
