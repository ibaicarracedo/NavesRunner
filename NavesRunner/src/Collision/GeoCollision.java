package Collision;

public abstract class GeoCollision {
	
	public boolean isCollision (GeoCollision g1, GeoCollision g2) {
		CircleBox aux, aux2;
		
		if ((g1  instanceof CircleBox) && (g2 instanceof CircleBox)) {
			aux = (CircleBox) g1;
			aux2 = (CircleBox) g2;
			
			if (Math.sqrt(Math.pow((aux.getX()-aux2.getX()), 2.0)	+Math.pow((aux.getY()-aux2.getY()), 2.0))	<= (aux.getRad() + aux2.getRad())) {
				return true;
			}
		}
		
		return false;
	}
	
}
