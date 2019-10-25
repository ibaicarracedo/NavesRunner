package PanelesYVentanas;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ObjetosYNaves.*;

public class GameFrame extends JFrame{

	public GameFrame() {
		
		JPanel panelSeleccion = new JPanel();
		
		this.setTitle("Space Runner");
		this.setSize((Toolkit.getDefaultToolkit().getScreenSize().width)/2, (Toolkit.getDefaultToolkit().getScreenSize().height)/2);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		;
		this.setVisible(true);
		

		
	}
	
	
}

