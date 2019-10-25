package ObjetosYNaves;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelNave extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JLabelNave(Boolean enemiga) { // Saca el icono de una nave
		ImageIcon img = new ImageIcon(System.getProperty("user.dir") +"\\img\\" + ((enemiga==false)?"aliada.png":"enemiga.png"));
		Image image = img.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
		
		img = new ImageIcon(image);
		this.setIcon(img);
		this.setSize(75,75);
	}
}
