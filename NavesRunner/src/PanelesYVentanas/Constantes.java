package PanelesYVentanas;
import java.awt.Toolkit;

public final class Constantes {
	
	// Constantes ventana
	public static final int FRAME_ANCHO = Toolkit.getDefaultToolkit().getScreenSize().width/2;
	public static final int FRAME_ALTO = Toolkit.getDefaultToolkit().getScreenSize().height/2;
	public static final int FUENTE_SCORE = 14;
	
	// Constantes obstaculos
	public static int OB_VEL = 10;
	public static final double OC_ACC = 2.5f;
	
	//Naves
	public static final int JLABEL_ANCHO = 76;
	public static final int JLABEL_ALTO = 76;
	public static final int POS_INICIAL_ANCHO = FRAME_ANCHO/2;
	public static final int POS_INICIAL_ALTO = FRAME_ALTO/3;
	public static final int TIEMPO_PARPADEO = 2;
	
	
}
