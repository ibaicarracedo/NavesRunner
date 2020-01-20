package ObjetosYNaves;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import PanelesYVentanas.Constantes;


/**
 * @author iCarr
 * @version 1.0: Scale an image of an asteroid to a JLabel size.
 */
public class JLabelAsteroide extends JLabel {
	
	public JLabelAsteroide() {
		try {
			ImageIcon img = new ImageIcon(System.getProperty("user.dir") +"\\img\\asteroide.png");
			Image image = img.getImage().getScaledInstance(76, 76, Image.SCALE_DEFAULT);
			img = new ImageIcon(image);
			
			this.setIcon(img);
			this.setSize(76,76);
			this.setBounds(0, 0, 76, 76);
		} catch (Exception e) {
			System.out.println("Fallo al encontrar el archivo. \n");
		}
	}
}
