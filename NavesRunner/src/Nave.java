import javax.swing.ImageIcon;

public class Nave {

	protected double posX;
	protected double posY;
	protected int velocidad;
	
	public Nave ( double posX, double posY) {
		
		this.posX = posX;
		this.posY = posY;

		
	}
	
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
	
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
	
	
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
}
