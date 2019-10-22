import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelNave extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JLabelNave(String dir) { // Saca el icono de una nave
		ImageIcon img = new ImageIcon(dir);
		Image image = img.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		
		img = new ImageIcon(image);
		this.setIcon(img);
		this.setSize(50,50);
	}
	
	public void setPosX(double posX) {
		this.setLocation((int)posX, (int) this.getLocation().getY());
	}
	
	public void setPosY(double posY) {
		this.setLocation((int) this.getLocation().getX(), (int) posY);
	}
}
