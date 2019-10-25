package ObjetosYNaves;

public abstract class ObjetosMapa {
	protected double velocidad;
	protected double posX;
	protected double posY;
	
	public ObjetosMapa(double velocidad, double posX, double posY) {
		super();
		this.velocidad = velocidad;
		this.posX = posX;
		this.posY = posY;
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
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
	
	
}
