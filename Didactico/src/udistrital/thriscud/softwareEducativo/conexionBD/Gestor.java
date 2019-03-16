package udistrital.thriscud.softwareEducativo.conexionBD;
/**
 * fecha: 7.3.19
 * @author anfer
 *
 */
public class Gestor {

	/**
	 * Objeto encargado de manejar la base de datos de los usuarios
	 */
	public Conection usuario;
	
	public Gestor() {
		usuario = new UsuarioBD();
	}
}
