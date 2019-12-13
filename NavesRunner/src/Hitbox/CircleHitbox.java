package Hitbox;

import PanelesYVentanas.Constantes;

public class CircleHitbox extends GenHitbox{
	
	double radio;
	
	public CircleHitbox(int posX, int posY, double rad) {
		super(posX, posY);
		this.radio = rad;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public boolean hayChoqueHitbox(GenHitbox c1, GenHitbox c2) { // Comprueba si hay choque entre dos hitbox de tipo circulo (por ahora)
		
		if (c1 instanceof CircleHitbox) {
			if (c2 instanceof CircleHitbox) {
				if (Math.sqrt(Math.pow((c1.x - c2.x), 2.0) + Math.pow((c1.y-c2.y), 2.0)) <= 2* Constantes.RAD_HIT	) {
					return true;
				}
			} 
			return false;
		}
		return false;
	}
}
