package ObjetosYNaves;

public class Asteroide extends ObstaculosYNaves {
	
	private JLabelAsteroide graf;
	
	public Asteroide(double posX, double posY, double vel) {
		super(posX, posY, vel);
		graf = new JLabelAsteroide();
		graf.setLocation((int) posX, (int)posY);
	}

	/** Cambia la velocidad actual de la nave
	 * @param aceleracion Incremento de la velocidad en pixels/segundo
	 */
	 public void acelera( double aceleracion ) { 
		 
		 this.vel += aceleracion; 
		 
	 }
	 
	 public JLabelAsteroide getLabel() {
		 return graf;
	 }


	 /** Cambia la posición del asteroide solo X dependiendo de su velocidad 
	 * @param tiempoDeMovimiento Tiempo transcurrido, en segundos
	 */
	 public void mueve( double tiempoDeMovimiento ) {
		 
		 this.posX += this.vel * tiempoDeMovimiento;
		 System.out.println(this.posX + " " + this.vel);
		 graf.setLocation((int)this.posX, (int)this.posY);
		 hitbox.setPos((int)this.posX, (int)this.posY);
		 
	 }
}
