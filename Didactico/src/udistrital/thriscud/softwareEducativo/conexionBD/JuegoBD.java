package udistrital.thriscud.softwareEducativo.conexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import udistrital.thriscud.softwareEducativo.Logica.juego.Juego;
import udistrital.thriscud.softwareEducativo.Logica.usuario.Usuario;

/**
 * fecha: 7.3.19
 * @author anfer
 *
 */
public class JuegoBD extends Conection  {
	@Override
	public ResultSet getQuery() {
		Statement state1 = null;
		ResultSet resultado1 = null;  
		try {
			state1 = (Statement) conn.createStatement();
			resultado1 = state1.executeQuery("select * from JUEGO");
		} catch(SQLException e) {
			e.printStackTrace();  
		}
		return resultado1;
	}
	@Override
	public void cambiarContrasena(Usuario u) throws Exception {	
	}
	@Override
	public void insertar(Usuario usuario) throws Exception {	
	}
	@Override
	public void eliminar(Usuario usuario) throws Exception {	
	}
	
	//----------------------------------CONSTRUCTOR------------------------------
	public JuegoBD(){
		super();	
	}
	
	
	//----------------------------------MÉTODOS----------------------------------
	/**
	 * Método que obtiene la información de un juego buscandolo por su nombre.
	 * @param nombreJ nombre del juego
	 * @return el juego que corresponde
	 * @throws Exception si el juego no se encuentra
	 * 					 si no se tiene datos del juego
	 */
	public Juego consultarPuntaje(String nombreJ) throws Exception {
		Juego j = null;
		//Consulto los puntajes
		Statement state = null;
		ResultSet resultado = null;  
		try {
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery("select * from PUNTAJE");
		} catch(SQLException e) {
			e.printStackTrace();  
		}
		
		//Consulto los juego
		Statement state1 = null;
		ResultSet resultado1 = null;  
		try {
			state1 = (Statement) conn.createStatement();
			resultado1 = state1.executeQuery("select * from JUEGO");
		} catch(SQLException e) {
			e.printStackTrace();  
		}
		
		//Buscamos el juego
		boolean f = false,f1 = false;
		String nombre="", descripcion="";
		int id=0, categoria=0, idPersona =0;
		long puntaje = 0;
		do {
			 if(resultado1.getString("nombrejuego").equals(nombreJ)) {
				 nombre = resultado1.getString("nombrejuego");
				 descripcion = resultado1.getString("descripcion");
				 id = resultado1.getInt("idjuego");
				 categoria = resultado1.getInt("categoria_idcategoria");
				 f = true;
			 }
		
		}while (resultado1.next() && f == false);
		if(f==false) {
			throw new Exception ("No se encuentran datos de este juego");
		}
		//Relaciono las dos tablas 
		do {
			 if(resultado.getInt("juego_idJuego")==id) {
				 idPersona = resultado.getInt("persona_idPersona");
				 puntaje  = resultado.getLong("puntaje");
				 
				 f1 = true;
			 }
		
		}while (resultado1.next() && f1 == false);
		if(f==false) {
			throw new Exception ("El juego no tiene puntaje máximo registrado");
		}
		
		j = new Juego(nombre,descripcion,puntaje,idPersona,categoria);
		
		
		return j;
	}
	
	 /**
	  * Método que obtiene los nombres de todos los juegos registrados en la base de datos
	  * @return ArrayList<String> que contiene todos los juegos registrados
	  * @throws SQLException
	  */
	public ArrayList<String> getJuegos() throws SQLException{
		ArrayList<String> nombre = new ArrayList<String>();
		ResultSet r = getQuery();
		while(r.next()) {
			nombre.add(r.getString("nombreJuego"));
		}
		return nombre;
	}
	
}
