import javax.swing.*;


public class VentanaGrafica extends JFrame {
	
	public VentanaGrafica() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Alien Runner");
		setSize(800,600);
		setLocationRelativeTo(null);
		
//		JPanel pJuego = new JPanel(); // Iniciamos los diferentes paneles
//		JPanel pLogin = new JPanel(); // Sin mostrarlos hasta que sea necesario
//		JPanel pSeleccion = new JPanel(); // Comenzaremos con la parte del juego > guardar partida > login 
		
		

		
		setVisible(true);
	}
	
	public static void main (String[] args) {
		VentanaGrafica v = new VentanaGrafica();
	}
}
