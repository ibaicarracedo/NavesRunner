package PanelesYVentanas;
import java.awt.Toolkit;

/**
 * Todas las Constantes usadas en el programa
 * @author iCarr
 *
 */
public final class Constantes {
	
	// Constantes ventana
	public static final int FRAME_ANCHO = 990;
	public static final int FRAME_ALTO = 540;
	public static final int FUENTE_SCORE = 14;
	
	// Constantes obstaculos
	public static int OB_VEL = -20; 
	public static final double OC_ACC = 2.5f;
	
	//Naves
	public static final int JLABEL_ANCHO = 76; // Tambien vale para asteroides
	public static final int JLABEL_ALTO = 76;
	public static final int POS_INICIAL_ANCHO = 0;
	public static final int POS_INICIAL_ALTO = 220;
	public static final int TIEMPO_PARPADEO = 2; //Cuando choca impl mas adelante con vidas (Si da tiempo)
	
	//Asteroides
	public static int PROB_AST = 5; // Podemos ponerla en tanto por 1 o tanto por 100. No final porque mas dificil con tiempo (reduce)
	
	//Hitbox
	public static final double RAD_HIT = 27.0d; // Pitagoras A^2 = 2*(38^2)
	public static final double RAD_HIT_AST = 30;
	
	//Frames
	public static final long TASA_REFRESCO = 15; // Así se consigue la pantalla a 60hz 1s/16.66ms = 60
	
	//Puntuacion
	public static final double INC_PUNT = 2.5d;
	
	//NOmbres de BD
	public static final String nomBD= "usuariosypuntuaciones";
	
}
