package udistrital.thriscud.softwareEducativo.conexionBD;
/**
 * fecha: 7.3.19
 * @author anfer
 *
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import udistrital.thriscud.softwareEducativo.Logica.usuario.Usuario;

public class UsuarioBD extends Conection {

	public UsuarioBD() {
		super ();
	}
	
	@Override
	public ResultSet getQuery() {
		  Statement state = null;
		  ResultSet resultado = null;
		  
		  try {
		   state = (Statement) conn.createStatement();
		   resultado = state.executeQuery("select * from PERSONA");
		  } catch(SQLException e) {
		   e.printStackTrace();  
		  }
		  
		  return resultado;
		 }


	/**
	  * Modificacion a la Base de Datos.
	  * @param _query
	 * @throws SQLException 
	  */
	public void cambiarContrasena(Usuario u) throws Exception {
		 stmt = conn.prepareStatement("Update \"PERSONA\" set contrasena = "+u.getContrasena()+" where usuario = '"+u.getNickName()+"'" );
		 int retorno = stmt.executeUpdate();
	     if (retorno<0) {
	    	 throw new Exception(":(");
	     } 
	     stmt.getConnection().commit();
	     stmt.close();
		 
	 }

	/**
	 * Permite agregar un nuevo usuario 
	 * @param usuario
	 * @throws Exception
	 */
	public void insertar(Usuario usuario) throws Exception  {
		 stmt = conn.prepareStatement("INSERT INTO \"PERSONA\" (NOMBRE, APELLIDO, USUARIO, CONTRASENA, TIPOPERSONA_IDTIPOPERSONA) "
		 		+ "VALUES (?,?,?,?,?)\r\n" + 
		 		"");
		 
		 stmt.setString(1,usuario.getNombre());
		 stmt.setString(2,usuario.getApellido());
	     stmt.setString(3,usuario.getNickName());
	     stmt.setString(4,usuario.getContrasena());
	     stmt.setInt(5,usuario.getTipoPersona());
	                     
	     int retorno = stmt.executeUpdate();
	     if (retorno<0) {
	    	 throw new Exception(":(");
	     } 
	     stmt.getConnection().commit();
	     stmt.close();
		
	 }
	 
	/**
	 * Elimina un usuario en base al nombre de usuario que este tenga
	 * @param usuario
	 * @throws Exception
	 */
	 public void eliminar(Usuario usuario) throws Exception{
		 stmt = conn.prepareStatement("Delete from  \"PERSONA\" where usuario = '"+usuario.getNickName()+"'");
		 int retorno = stmt.executeUpdate();
	     if (retorno<0) {
	    	 throw new Exception(":(");
	     } 
	     stmt.getConnection().commit();
	     stmt.close();
	 }
	 
	 /**
	  * Método que se utiliza para ingresar al juego con usuario ya creado
	  * @param nickName usuario registrado en el sistema
	  * @param Contrasena contraseña 
	  * @return
	  */
	 public Usuario ingresar (String nickName, String Contrasena) throws Exception {
		 Usuario u = null;
		 ResultSet datos = getQuery();
		 boolean f  = false;
		 while(datos.next() && !f) {
			if (datos.getString("usuario").equals(nickName) && datos.getString("contrasena").equals(Contrasena)) {
				u = new Usuario(datos.getString("nombre"),datos.getString("apellido"),datos.getString("usuario"),datos.getString("contrasena"),datos.getInt("tipopersona_idtipopersona"),
				datos.getInt("idpersona"));
				f = true; 
			}
			System.out.println(datos.getString("usuario")+" "+datos.getString("contrasena"));
		 }
		
		 if(f==false) {
			 throw new Exception ("Usuario y/o contraseña erroneos");
		 }
		return u; 
	 }
	 /**
	  * Método que obtiene los nombres de todos los usuarios registrados en la base de datos
	  * @return ArrayList<String> que contiene todos los nombres registrados
	  * @throws SQLException
	  */
	 public ArrayList<String> getUsuarios() throws SQLException{
		ArrayList<String> nombre = new ArrayList<String>();
		ResultSet r = getQuery();
		while(r.next()) {
			nombre.add(r.getString("usuario"));
	
		}
		return nombre;
	 }
	 //TODO- Agregar método para buscar un usuario que reciba el id del usuario y me retorne el nickName del usuario
	
	 public String getUsuario(int id) throws Exception {
		 ResultSet datos = getQuery();
		 String usuario = "";
		 boolean f=false;
		 do {
			 if (datos.getInt("idpersona")==id) {
				usuario = datos.getString("nombre");
			 }
		 }while (datos.next() && f == false);
		 if(f==false) {
			 throw new Exception ("No existe ningún usuario con esos datos.");
		 }
		 return usuario;
	 }
}
