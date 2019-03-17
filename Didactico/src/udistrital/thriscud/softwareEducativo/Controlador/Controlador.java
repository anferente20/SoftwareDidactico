package udistrital.thriscud.softwareEducativo.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import udistrital.thriscud.softwareEducativo.Logica.usuario.Usuario;
import udistrital.thriscud.softwareEducativo.conexionBD.UsuarioBD;
import udistrital.thriscud.softwareEducativo.vista.VentanaBiologia;
import udistrital.thriscud.softwareEducativo.vista.VentanaInicioSesion;
import udistrital.thriscud.softwareEducativo.vista.VentanaMatematicas;
import udistrital.thriscud.softwareEducativo.vista.VentanaMateria;
import udistrital.thriscud.softwareEducativo.vista.VentanaPrincipal;
import udistrital.thriscud.softwareEducativo.vista.VentanaRegistro;

public class Controlador implements ActionListener {
	VentanaInicioSesion ventanaInicioSesion;
	VentanaMateria ventanaMateria;
	VentanaPrincipal ventanaPrincipal;
	VentanaRegistro ventanaRegistro;
	UsuarioBD user;

	// Se agrega atributo de tipo usuario para que se aloje el usuario actual
	Usuario usuario;

	public Controlador() {
		ventanaInicioSesion = new VentanaInicioSesion();
		ventanaInicioSesion.addControlador(this);
		ventanaRegistro = new VentanaRegistro();
		ventanaRegistro.addControlador(this);
		ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.addControlador(this);
	}

	public void execute() {
		ventanaInicioSesion.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton objeto = (JButton) e.getSource();

		if (objeto.equals(ventanaInicioSesion.getBtnIngresar())) {
			ingresar();
		} else if (objeto.equals(ventanaInicioSesion.getBtnRegistrarse())) {
			registrar();
		} else if (objeto.equals(ventanaPrincipal.getBtnBio())) {
			try {
				escogerMateria(2);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			}
		} else if (objeto.equals(ventanaPrincipal.getBtnMat())) {
			try {
				escogerMateria(1);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			}
		} else if (objeto.equals(ventanaPrincipal.getBtnInf())) {
			try {
				escogerMateria(0);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			}
		} else if (objeto.equals(ventanaPrincipal.getBtnCreditos())) {
			// Ventana de Creditos
		} else if (objeto.equals(ventanaPrincipal.getBtnCerrarSesion())) {
			pantallaInicial();
		} else if (objeto.equals(ventanaMateria.getBtnInicio())) {
			volverPrincipal();
		} else if (objeto.equals(ventanaMateria.getBtnPuntaje())) {
			// Ventana de Puntaje
		}
	}

	public void volverPrincipal() {
		ventanaPrincipal.setVisible(true);
		ventanaMateria.dispose();
		ventanaMateria = null;
	}

	public void registrar() {
		ventanaInicioSesion.clean();
		ventanaInicioSesion.setVisible(false);
		ventanaRegistro.setVisible(true);
	}

	public void ingresar() {
		try {
			usuario = user.ingresar(ventanaInicioSesion.getUsuario(), ventanaInicioSesion.getPassword());
			ventanaInicioSesion.clean();
			ventanaInicioSesion.setVisible(false);
			ventanaPrincipal.setVisible(true);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}

	public void pantallaInicial() {
		usuario = null;
		ventanaInicioSesion.setVisible(true);
		ventanaPrincipal.setVisible(false);
	}

	public void escogerMateria(int materia) throws Exception {
		switch (materia) {
		case 1:
			ventanaMateria = new VentanaMatematicas();
			break;
		case 2:
			ventanaMateria = new VentanaBiologia();
			break;
		case 3:
			// ventanaMateria = new VentanaInformatica();
			break;
		default:
			throw new Exception("La materia que solicita no está disponible");
		}
		ventanaMateria.setVisible(true);
		ventanaMateria.addControlador(this);
		ventanaPrincipal.setVisible(false);
	}

	public void registrarUsuario() {
		ManejoUsuario mu = new ManejoUsuario(new Usuario(ventanaRegistro.getNombres(), ventanaRegistro.getApellidos(),
				ventanaRegistro.getNickname(), ventanaRegistro.getPassword(), ventanaRegistro.getTipo()));
		mu.insertar();
		ventanaRegistro.clean();
		ventanaRegistro.dispose();
		ventanaInicioSesion.setVisible(true);
	}
}
