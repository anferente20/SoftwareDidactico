package udistrital.thriscud.softwareEducativo.Controlador;

import udistrital.thriscud.softwareEducativo.Logica.usuario.Usuario;
import udistrital.thriscud.softwareEducativo.conexionBD.UsuarioBD;

/**
 * @author anfer
 * Fecha: 15.3.19
 */

public class ManejoUsuario implements Fachada{

	//----------------Atributos-------------------
	private Usuario us;
	private UsuarioBD usBD;
	
	//-----------------Métodos--------------------

	public ManejoUsuario(Usuario u){
		us = u;
		usBD = new UsuarioBD();
	}
	@Override
	public void insertar() {
		try {
			usBD.insertar(us);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object crear() {
		// TODO Auto-generated method stub
		return null;
	} 
}
