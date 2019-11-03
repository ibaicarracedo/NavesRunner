package ObjetosYNaves;

import java.awt.Rectangle;

import Collision.*;

public class Nave {

	private double velocidad;
	private double posX;
	private double posY;
	// private CircleBox c1;
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
	

	/** Cambia la velocidad actual de la nave
	 * @param aceleracion Incremento de la velocidad en pixels/segundo
	 */
	 public void acelera( double aceleracion ) { 
		 
		 this.velocidad += aceleracion; 
		 
	 }


	 /** Cambia la posición de la nave dependiendo de su velocidad y dirección
	 * @param tiempoDeMovimiento Tiempo transcurrido, en segundos
	 */
	 public void mueve( double tiempoDeMovimiento ) {
		 
		 this.posX = this.velocidad * tiempoDeMovimiento;
		 this.posY = this.velocidad * tiempoDeMovimiento;
		 
	 }
	
}
