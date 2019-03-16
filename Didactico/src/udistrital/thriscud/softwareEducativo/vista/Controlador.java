package udistrital.thriscud.softwareEducativo.vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import udistrital.thriscud.softwareEducativo.conexionBD.UsuarioBD;


public class Controlador implements ActionListener{
	InicioSesion ventanita;
	VentanaPrincipal principal;
	UsuarioBD gg;
	
	public Controlador(InicioSesion ventanita){
		this.ventanita = ventanita;
		gg = new UsuarioBD();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton objeto = (JButton) e.getSource();
		if(objeto.equals(ventanita.btnIngresar)){
			try {
				gg.ingresar(ventanita.getUsuario(), ventanita.getPassword());
				ingresar();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
			
		}
	}

	
	/**Metodo del boton ingresar*/
	public void ingresar(){
		principal = new VentanaPrincipal();	//ESTO ES MACHETAZO, ES PARA QUE VEAN COMO FUNCIONA LA NAVEGACION DE LA APLICACION 
		ventanita.setVisible(false);
		principal.setVisible(true);
	}
}
