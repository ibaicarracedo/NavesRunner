package GmailYBd;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

/**
 * @author iCarr
 * PEqueño JUnit para probar las funciones de BD
 */
public class BaseDeDatosTest {

	private Connection test;
	private Statement stest;
	private ResultSet rs;
	
	
	/**
	 * Creamos la base de datos y metemos algunos datos para probar el junit
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		BaseDeDatos.crearBD("test");
		BaseDeDatos.anadirUsuario("admin", "hola@gmail.com", "admin");
		BaseDeDatos.actualizarPuntuacion("admin", 10.0);
		test = BaseDeDatos.getConexionBD();
		stest = BaseDeDatos.getState();
		
	}

	/**
	 * Test del JUnit. Se comprueban que los datos son los esperados.
	 */
	@Test
	public void test() {
		try {
			rs = stest.executeQuery("select * from usuarios where nick = 'admin';");
			if(rs.next()) // Admin = admin
				assertEquals("admin", rs.getString(1));
			
			if (rs.next()) // hola@gmail.com = "hola@gmail.com
				assertEquals("hola@gmail.com", rs.getString(1));
			
			if (rs.next()) // "admin" = admin
				assertEquals("admin", rs.getString(1));
			
			BaseDeDatos.actualizarPuntuacion("admin", 7.5);
			
			rs = stest.executeQuery("select puntuacion from puntuaciones where nick = 'admin';");
			
			if (rs.next()) // 7.5 not equal 10.0
				assertNotEquals(7.5, Double.parseDouble(rs.getString(1)), 0.000000001);
				
			test.close();
			stest.close();
			BaseDeDatos.cerrarBD();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
