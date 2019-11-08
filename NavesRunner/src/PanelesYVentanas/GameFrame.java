package PanelesYVentanas;
import PanelesYVentanas.Constantes;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ObjetosYNaves.*;

public class GameFrame extends JFrame{

	public GameFrame() {
		
		JPanel game = new JPanel();
		
		this.setTitle("Space Runner");
		this.setSize((Toolkit.getDefaultToolkit().getScreenSize().width)/2, (Toolkit.getDefaultToolkit().getScreenSize().height)/2);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);	
		this.setVisible(true);
		
		game.setLayout(null);
		this.getContentPane().add(game);
		
		Juego juego = new Juego();
		
	
	}
	
	
}

