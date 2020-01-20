package Hitbox;

import PanelesYVentanas.Constantes;

public class CircleHitbox extends GenHitbox{
	
	double radio;
	
	/**
	 * Constructor con centro y radio 
	 * @param posX posicion X
	 * @param posY posicion Y
	 * @param rad radio
	 */
	public CircleHitbox(int posX, int posY, double rad) {
		super(posX, posY);
		this.radio = rad;
	}

	/**
	 * Funcion que se usa para conocer el radio
	 * @return el radio
	 */
	public double getRadio() {
		return radio;
	}

	/**
	 * Ponemos radio de una hitbox de tipo circulo
	 * @param radio
	 */
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public boolean hayChoqueHitbox(GenHitbox c1) { // Comprueba si hay choque entre dos hitbox de tipo circulo (por ahora)
		
		if (c1 instanceof CircleHitbox) {
				if (Math.sqrt(Math.pow((c1.x - this.x), 2.0) + Math.pow((c1.y-this.y), 2.0)) <= 2* Constantes.RAD_HIT	) {
					return true;
				}
			return false;
		}
		return false;
	}
}
