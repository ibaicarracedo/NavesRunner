package ObjetosYNaves;

import Hitbox.CircleHitbox;
import PanelesYVentanas.Constantes;

public abstract class ObstaculosYNaves {
	
	protected double posX;
	protected double posY;
	protected double vel;
	CircleHitbox hitbox;
	// Protected string nombreUser;
	
	
	public ObstaculosYNaves(double posX, double posY, double vel) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.vel = vel;
		this.hitbox = new CircleHitbox((int)posX, (int)posY, Constantes.RAD_HIT);
	}
	
	public double getPosX() {
		return posX;
	}
	
	public void setPosX(double posX) {
		this.posX = posX;
		hitbox.setPos((int) posX, hitbox.getPosY()); // Posiciona la X y deja igual la Y
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
		hitbox.setPos(hitbox.getPosX(), (int) posY); 
	}
	public double getVel() {
		return vel;
	}
	public void setVel(double vel) {
		this.vel = vel;
	}
	public CircleHitbox getHitbox() {
		return hitbox;
	}
	public void setHitbox(CircleHitbox hitbox) {
		this.hitbox = hitbox;
	}
	
	 public abstract void mueve( double tiempoDeMovimiento );
	
	
	
}
