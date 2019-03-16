package udistrital.thriscud.softwareEducativo.vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import udistrital.thriscud.softwareEducativo.conexionBD.UsuarioBD;


public class Controlador implements ActionListener{
	InicioSesion ventanita;
	VentanaPrincipal principal;
	UsuarioBD user;
	
	//Se agrega atributo de tipo usuario para que se aloje el usuario actual
	Usuario usuario;
	public Controlador(InicioSesion ventanita){
		this.ventanita = ventanita;
		user = new UsuarioBD();
		usuario = null;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton objeto = (JButton) e.getSource();
		if(objeto.equals(ventanita.btnIngresar)){
			try {
				usuario = user.ingresar(ventanita.getUsuario(), ventanita.getPassword());
				ingresar();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
			
		}
	}

	
	/**Metodo del boton ingresar*/
	public void ingresar(){ 
		principal = new VentanaPrincipal(); 
		ventanita.setVisible(false);
		principal.setVisible(true);
	}
	
}
