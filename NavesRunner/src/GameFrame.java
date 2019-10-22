import java.awt.Toolkit;
import javax.swing.*;

public class GameFrame extends JFrame{

	public GameFrame() {
		
		JPanel panelSeleccion = new JPanel();
		JPanel gamePanel = new JPanel();
		NaveEnemiga nave1 = new NaveEnemiga(this.getSize().getWidth()/2.0, this.getSize().getHeight()/2.0);
		
		this.getContentPane().add(gamePanel);
		gamePanel.add(nave1.getImgDir());
		
		nave1.setPosY(250);
		gamePanel.revalidate();
		gamePanel.repaint();
		
		this.setTitle("Space Runner");
		this.setSize((3*Toolkit.getDefaultToolkit().getScreenSize().width)/5, (Toolkit.getDefaultToolkit().getScreenSize().height)/2);
		this.setVisible(true);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	
}


