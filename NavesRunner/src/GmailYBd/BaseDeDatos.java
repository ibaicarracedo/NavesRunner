package GmailYBd;

import java.sql.*;
import java.util.ArrayList;

import javax.mail.search.SentDateTerm;

import PanelesYVentanas.Constantes;
import PanelesYVentanas.LoginFrame;

public class BaseDeDatos {

	private static Connection conexionBD;
	private static Statement state;
	private static String user = "root";
	private static String pass = "root";
	private static int existe = 0;
	
	/**
	 * Funcion que devuelve la conexion a la BD
	 * @return la conexion a la bd
	 */
	public static Connection getConexionBD() {
		return conexionBD;
	}



	/**
	 * Funcion que pone la conexion
	 * @param conexionBD setea la conexion
	 */
	public static void setConexionBD(Connection conexionBD) {
		BaseDeDatos.conexionBD = conexionBD;
	}



	/**
	 * @return nos devuelve el statement a la bd
	 */
	public static Statement getState() {
		return state;
	}



	/**
	 * Pone un nuevo statement
	 * @param state un nuevo statment
	 */
	public static void setState(Statement state) {
		BaseDeDatos.state = state;
	}



	/** Crea BD y tablas y deja la conexion abierta
	 * @param nomBD: Nombre de la base de datos
	 * @throws ClassNotFoundException Si no adjuntas la libreria no encuentra la clase
	 */
	public static void crearBD(String nomBD) throws ClassNotFoundException {
		
		Class.forName("org.sqlite.JDBC");
		
		try { // Abre la conexion a la base de datos que sea;
			conexionBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/", user, pass);
			state = conexionBD.createStatement();
			
			
			ResultSet rs = state.executeQuery("show databases;"); // Comprueba si existe la BD
			
			while (rs.next()) { // Comprobamos si existe
				if (rs.getString(1).equalsIgnoreCase(Constantes.nomBD))
					existe = 1;
			}
			
			if (existe != 1) { 
				
				state.executeUpdate("create database " + Constantes.nomBD + ";");
				state.executeUpdate("use " + Constantes.nomBD + ";");
				
				
			} else {
				state.executeUpdate("use " + Constantes.nomBD+";"); // Si existe la usamos
			}
		
			
			// Creamos tablas
			state.executeUpdate("Create table if not exists Usuarios ("
					+ "Nick varchar(8) not null,"
					+ "Email varchar(30) not null,"
					+ "Pass varchar(16) not null,"
					+ "primary key(nick),"
					+ "unique(email));"); // CREA tabla usuarios
			
			state.executeUpdate("Create table if not exists Puntuaciones ("
					+ "nick varchar(8) not null,"
					+ "puntuacion decimal(5,1) default 0.0,"
					+ "primary key(nick),"
					+ "foreign key(nick) references usuarios(nick)); ");
			
			rs = state.executeQuery("Select * from usuarios where nick = 'admin'"); // Si no tienen nada insertamos 
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	
	
	/**
	 * Cierra conexion con BD
	 */
	public static void cerrarBD() {
		try {
			if (conexionBD != null) {
				state.close();
				conexionBD.close();
			}
		}  catch (SQLException e) {}
	}
	
	/**
	 * Funcion que añade un usuario a las tablas solo si no esta
	 * @param nick Nombre de usuario
	 * @param email Email de usuario
	 * @param pass Contraseña a guardar en tabla
	 * @return True si sale bien, false si sale mal
	 */
	public static boolean anadirUsuario(String nick, String email, String pass) {
			
		if (checkUsuario(nick, email) == true) {
			return false;
		}
		
		try {
			state.executeUpdate("insert into usuarios values ('" + nick + "', '" + email + "', '" + pass +"');");
			state.executeUpdate("insert into puntuaciones (nick) values ('"+nick+"');");
			
			if (checkUsuario(nick, email) == true)
				return true;
			
		return false;
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}
	
	
	/**
	 * Funcion que chequea en el Login la contraseña y el nick
	 * @param nick nombre a comprobar
	 * @param pass contraseña a comprobar
	 * @return true si es correcto y false si no
	 */
	public static boolean loginUsuario(String nick, String pass) {
		
		try {
			ResultSet rs = state.executeQuery("Select * from usuarios where nick = '"+nick+"' and pass = '" +pass+"';");
			if (rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}
	
	/**
	 * Funcion que actualiza la puntuacion solo si la nuevaPuntuacion es mayor
	 * @param nick del user a actualizar
	 * @param nuevaPuntuacion 
	 * @return true si se realizo correctamente
	 */
	public static boolean actualizarPuntuacion(String nick, double nuevaPuntuacion) {
		
		double iguales = 0;
		
		try {
			ResultSet rs = state.executeQuery("select puntuacion from puntuaciones where nick = '" + LoginFrame.getNick() + "';");
			
			if (rs.next()) {
				iguales = (Double.parseDouble(rs.getString(1))-nuevaPuntuacion);
			} else {
				return false;
			}
			
			if (iguales < 0.0) {
				state.executeUpdate("update puntuaciones set puntuacion = " + nuevaPuntuacion + " where nick = '" + 
						LoginFrame.getNick() + "';");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	/**
	 * Funcion que comprueba si un usuario esta en la tabla
	 * @param nick del user a comrobar
	 * @return true si esta flase si no
	 */
	public static boolean checkUsuario(String nick, String email) {
		
			boolean nombre = true;
			boolean correo = true;
		
			try {
				ResultSet rs = state.executeQuery("select * from usuarios where nick = '" + nick +"';"); 
				
				if (rs.next() == false) { // No tiene el nick nombre = false
					nombre = false;
				}
				
				rs = state.executeQuery("select * from usuarios where email = '" + email +"';"); // no tiene email por lo que correo falso
				
				if (rs.next() == false) {
					correo = false;
				}
				
				rs = state.executeQuery("select * from puntuaciones where nick = '" + nick + "';");
				
				if (rs.next() == false) {
					nombre = false;
				}
				
				return (nombre || correo); // True si existe una de las dos
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}
	
	/** 
	 * Funcion que llamo para obtener nicks de puntuaciones
	 * @return ArrayList de nicks de la tabla
	 */
	public static ArrayList<String> getNicks() {
		
		ArrayList<String> names = new ArrayList<String>();
		
		try {
			
			ResultSet rs = state.executeQuery("Select nick from puntuaciones;");
			
			while(rs.next())
				names.add(rs.getString(1));
			
		} catch (SQLException e) {
			
		}
		
		return names;
	}
	
	/**
	 * Funcion que se usa en la clase FramePuntuaciones y que devuelve la lista de puntuaciones
	 * @return Un arraylist de puntuaciones
	 */
	public static ArrayList<Double> getPuntuaciones() {
		
		ArrayList<Double> puntuaciones = new ArrayList<Double>();
		
		try {
			
			ResultSet rs = state.executeQuery("Select puntuacion from puntuaciones;");
			
			while(rs.next())
				puntuaciones.add(rs.getDouble(1));
			
		} catch (SQLException e) {
			
		}
		
		return puntuaciones;
	}
}
