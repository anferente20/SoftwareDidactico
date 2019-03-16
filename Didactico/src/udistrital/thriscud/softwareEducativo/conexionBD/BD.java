package udistrital.thriscud.softwareEducativo.conexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;

import udistrital.thriscud.softwareEducativo.Logica.usuario.Usuario;
/**
 * fecha: 7.3.19
 * @author anfer
 *
 */
public interface BD {

	 /**
	  * Consultas a la Base de Datos.
	  * @param _query
	  * @return
	  */
	 abstract public ResultSet getQuery();
	 
	 /**
	  * Modificacion a la Base de Datos de usuario.
	  * @param _query
	 * @throws SQLException 
	  */
	abstract public void cambiarContrasena(Usuario u) throws Exception;
	
	/**
	 * Permite agregar un nuevo usuario 
	 * @param usuario
	 * @throws Exception
	 */
	abstract public void insertar(Usuario usuario) throws Exception;
	
	/**
	 * Elimina un usuario en base al nombre de usuario que este tenga
	 * @param usuario
	 * @throws Exception
	 */
	 abstract public void eliminar(Usuario usuario) throws Exception;
}
