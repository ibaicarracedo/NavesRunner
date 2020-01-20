package Hitbox;

/**
 * Clase que se usa para tratar las hitbox
 * @author iCarr
 *
 */
public abstract class GenHitbox { // IMPLEMENTAR MAIXMO NAVE OCN 3 RECTANGLES Y CHOQUE CON CIRC (ASTEROIDE)
	
	protected int x;
	protected int y;
	
	/**
	 * Constrctor que pone el centro en un punto de la ventana
	 * @param x pos x
	 * @param y pos y
	 */
	public GenHitbox(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * Funcion que pone la posicion en un determinado punto
	 * @param posX
	 * @param posY
	 */
	public void setPos(int posX, int posY) {
		this.x = posX;
		this.y = posY;
	}
	
	/**
	 * Funcion que se llama para conocer la x
	 * @return devuelve la x
	 */
	public int getPosX() {
		return this.x;
	}
	
	/**
	 * Funcion que se llama para conocer la y
	 * @return devuelve la y
	 */
	public int getPosY() {
		return this.y;
	}
	
	/**
	 * Funcion que nos devuelve si hay choque entre dos hitbox
	 * @param c1. Una hitbox generica
	 * @return Devuelve si hay choque con la Hitbox Generica c1
	 */
	public abstract boolean hayChoqueHitbox(GenHitbox c1);
}
