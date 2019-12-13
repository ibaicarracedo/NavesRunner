package ObjetosYNaves;

public class Nave extends ObstaculosYNaves {

	private JLabelNave graf;
	
	public Nave(double posX, double posY, double vel) {
		super(posX, posY, vel);
		graf = new JLabelNave();
		graf.setLocation((int) posX, (int)posY);
	}

	/** Cambia la posición de la nave en el eje Y dependiendo de su velocidad 
	 * @param tiempoDeMovimiento Tiempo transcurrido, en segundos
	 */
	 public void mueve( double tiempoDeMovimiento ) {
		 
		 this.posY += this.vel * tiempoDeMovimiento;
		 graf.setLocation((int)posX, (int)posY);
		 hitbox.setPos((int)posX, (int)posY);
		 
	 }
	 
	 public JLabelNave getJLabel() {
		 return graf;
	 }
}
