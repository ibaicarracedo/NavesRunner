package ObjetosYNaves;

import java.awt.Rectangle;


public class Nave {

	private double velocidad;
	private double posX;
	private double posY;
	private JLabelNave image;
	
	public Nave (double vel, double posX, double posY) {

		this.velocidad = vel;
		this.posX = posX;
		this.posY = posY;
		this.image = new JLabelNave();
		this.image.setLocation((int) posX, (int) posY); 
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
		image.setLocation((int) posX, (int) image.getLocation().getY());
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
		image.setLocation((int) image.getLocation().getX(), (int) posY);
	}
	
	public JLabelNave getImage() {
		return image;
	}

	public void setImage(JLabelNave image) {
		this.image = image;
	}
	
	public void setPos(double posX, double posY) {
		setPosX(posX);
		setPosY(posY);
	}
	

}
