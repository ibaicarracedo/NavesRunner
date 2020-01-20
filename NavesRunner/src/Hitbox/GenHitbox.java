package Hitbox;

public abstract class GenHitbox { // IMPLEMENTAR MAIXMO NAVE OCN 3 RECTANGLES Y CHOQUE CON CIRC (ASTEROIDE)
	
	protected int x;
	protected int y;
	
	public GenHitbox(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void setPos(int posX, int posY) {
		this.x = posX;
		this.y = posY;
	}
	
	public int getPosX() {
		return this.x;
	}
	
	public int getPosY() {
		return this.y;
	}
	
	public abstract boolean hayChoqueHitbox(GenHitbox c1);
}
