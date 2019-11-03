package Collision;

public class CircleBox extends GeoCollision{

	private int x; // Coordenada x
	private int y;	// Coordenada y
	private double rad; // Radio
	
	public CircleBox(int x, int y, double rad) { // Creamos el area del circulo en la posicion de la nave 
		this.x = x;
		this.y = y;
		this.rad = rad;
	}
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public double getRad() {
		return rad;
	}
	public void setRad(double rad) {
		this.rad = rad;
	}


	@Override
	public boolean isCollision(GeoCollision g1, GeoCollision g2) {
		
		if ((g1 instanceof CircleBox) && (g2 instanceof CircleBox)) {
			
		}
		
		
		return false;
	}	
}
