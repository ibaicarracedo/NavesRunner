package PanelesYVentanas;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ObjetosYNaves.*;

public class GameFrame extends JFrame{

	public GameFrame() {
		
		Nave ne = new Nave(0,100,100);
		JPanel tets = new JPanel(null);
		tets.add(ne.getImage());
		this.getContentPane().add(tets);
		
		this.setTitle("Space Runner");
		this.setSize((Toolkit.getDefaultToolkit().getScreenSize().width)/2, (Toolkit.getDefaultToolkit().getScreenSize().height)/2);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);	
		this.setVisible(true);
	
	}
	
	public void CreaJuego() {
		// Crea Naves (Aliadas, enemigas)
		// Crea obstaculos
		//Juega();
	}
	
}

