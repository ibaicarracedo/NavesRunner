package ObjetosYNaves;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import PanelesYVentanas.Constantes;

public class JLabelNave extends JLabel{

		public JLabelNave() {
			try {
				ImageIcon img = new ImageIcon(System.getProperty("user.dir") +"\\img\\nave.png");
				Image image = img.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
				img = new ImageIcon(image);
				this.setIcon(img);
				this.setSize(76,76);
			} catch (Exception e) {
				System.out.println("Fallo al encontrar el archivo. \n");
			}
		}
}
