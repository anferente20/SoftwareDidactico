package udistrital.thriscud.softwareEducativo.conexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 3fecha: 7.2.19
 * @author anfer
 *
 */
public abstract class Conection implements BD {
	 /*Usuario y pass de la Base de Datos. */
	 protected String user = "C##Rente";
	 protected String pass = "C##Rente";
	  
	 /* URL de la Base de Datos */
	 protected static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	  
	 /* Conexion a la Base de Datos */
	 protected Connection conn = null;
	 protected PreparedStatement stmt;

	 public Conection() {
		 try {
			   Class.forName("oracle.jdbc.OracleDriver");
			   conn = (Connection)DriverManager.getConnection(url, user, pass);
			   
			   if (conn != null) {
			    System.out.println("Conexion a base de datos "+url+" . . . Ok");
			   }
			   
			  } catch(SQLException ex) {
			   System.out.println("Hubo un problema al intentar conecarse a la base de datos"+url);
			   
			  } catch(ClassNotFoundException ex) {
			   System.out.println("Error... "+ex);
			  }  
	 }
	 
	
	 	 
}
