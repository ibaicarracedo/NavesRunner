package ObjetosYNaves;

public class Obstaculo {
	private double velocidad;
	private double posX;
	private double posY;

	
	public Obstaculo (double vel, double posX, double posY) {

		this.velocidad = vel;
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
