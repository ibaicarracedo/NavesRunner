package GmailYBd;

import java.sql.*;

public class BaseDeDatos {

	private Connection conexionBD;
	private Statement state;
	
	public void abrirBD(String nomBD) throws ClassNotFoundException {
		
		Class.forName("org.sqlite.JDBC");
		
		try { // Abre la conexion a la base de datos que sea;
			conexionBD = DriverManager.getConnection("jdbc:sqlite:" + nomBD);
			state = conexionBD.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { // Si falla por x razon que cierre la conexion a la base de datos
			try {
				if (conexionBD != null)
					conexionBD.close();
			} catch (SQLException e) {
				
			}
		}
		
	}
	
	
	/* 
	 * 
	 */
	public void cerrarBD() {
		try {
			if (conexionBD != null)
				conexionBD.close();
		}  catch (SQLException e) {}
	}
}
