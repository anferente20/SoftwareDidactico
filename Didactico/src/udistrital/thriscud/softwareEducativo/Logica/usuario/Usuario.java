package udistrital.thriscud.softwareEducativo.Logica.usuario;

/**
 * fecha: 11.2.19
 * @author anfer
 *
 */
public class Usuario {

	//----------------Atributos-------------------
	
	/**
	 * Atributo tipo String en el que se tendra el registro local del nombre del usuario
	 */
	protected String nombre;
	
	/**
	 * Atributo tipo String en el que se tendrá el registo del nickName del usuario
	 */
	protected String nickName;
	/**
	 * Atributo tipo String en el que se tendra el registro local del APELLIDO
	 del usuario
	 */
	private String apellido;
	
	/**
	 * Atributo tipo String en el que se tendrá el registro de la contrasena del usuario.
	 */
	private String contrasena;
	
	/**
	 * tipo Persona
	 */
	private int tipoPersona;
	

	/**
	 * identificador de la persona en la base de datos
	 */
	private int id;
	//----------------Constructores-------------------
	
	/**
	 * Constructor con paramentros a usarse para registro de usuario
	 * @param nombre Nombre del usuario a registrar.
	 * @param apellido Apelllido del usuario a registrar.
	 * @param nickName Nombre de Usuario del usuario a registrar.
	 * @param contrasena Contrasena del usuario a registrar.
	 * @param tipoPersona define el tipo de la persona
	 */
	public Usuario(String nombre, String apellido, String nickName, String contrasena, int tipoPersona){
		this.nombre = nombre;
		this.apellido = apellido;
		this.nickName = nickName;
		this.contrasena = contrasena;
		this.tipoPersona = tipoPersona;
	}
	/**
	 * Constructor con paramentros a usarse para registro de usuario
	 * @param nombre Nombre del usuario a registrar.
	 * @param apellido Apelllido del usuario a registrar.
	 * @param nickName Nombre de Usuario del usuario a registrar.
	 * @param contrasena Contrasena del usuario a registrar.
	 * @param tipoPersona define el tipo de la persona
	 * @param id es el identificador del usuario en la BD
	 */
	public Usuario(String nombre, String apellido, String nickName, String contrasena, int tipoPersona, int id){
		this.nombre = nombre;
		this.apellido = apellido;
		this.nickName = nickName;
		this.contrasena = contrasena;
		this.tipoPersona = tipoPersona;
		this.id = id;
	}
	//----------------Getters y Setters -------------------
	public String getNombre() {
		return nombre;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(int tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContrasena() {
		return contrasena;
	}

	
	
	//----------------Métodos -------------------

	/**
	 * Método que permite modificar la contrasena
	 * @param contrasenaActual Contrasena Actual del usuario.
	 * @param contrasenaNueva Contrasena por a cuál se va a cambiar
	 * @throws Exception Si la contrasena actual no coincide con la contrasena registrada del usuario
	 */
	public void cambiarContrasena(String contrasenaActual, String contrasenaNueva) throws Exception{
		if (contrasenaActual.equals(this.contrasena)){
			contrasena = contrasenaNueva;
		//TODO- cambiar contraseña	
		}
		else{
			throw new Exception("La contrasena Actual no coincide.");
		}
	}
	
	/**
	 * Cambia la contrasena por medio del nombre de usuari ( si no se sabe la contrasena)
	 * @param nickName Nombre del usuario registrado
	 * @param contrasenaNueva Contrasena con la cual se desea cambiar
	 * @throws Exception si el nombre de usuario no está registrado en la base de datos.
	 */
	public void cambiarContrasenaPorUsuario(String nickName, String contrasenaNueva) throws Exception{
		if (nickName.equals(this.nickName)){
			contrasena = contrasenaNueva;
		}
		else{
			throw new Exception("El nombre de usuario no está registrado.");
		}
	}
}

