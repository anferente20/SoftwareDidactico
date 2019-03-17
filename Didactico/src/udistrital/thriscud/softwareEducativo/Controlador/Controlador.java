/* Clase Controlador
 * 
 * @author: Edwin Aaron Garcia Pulido (edaagapu)
 * 
 * 
 * Esta clase permite relacionar la lógica del programa con las interfaces graficas (GUI),
 * esto se hace con el objetivo de separar la lógica de la vista, para hacer el mantenimiento un
 * poco mas fácil.
 */
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
	// Se crean atributos de todas las ventanas
	VentanaInicioSesion ventanaInicioSesion;
	VentanaMateria ventanaMateria;
	VentanaPrincipal ventanaPrincipal;
	VentanaRegistro ventanaRegistro;

	// Se agrega el atributo que relaciona todo con la persistencia
	UsuarioBD user;

	// Se agrega atributo de tipo usuario para que se aloje el usuario actual
	Usuario usuario;

	// Metodo donde se crean todas las GUI usadas y se les adiciona el controlador
	public Controlador() {
		ventanaInicioSesion = new VentanaInicioSesion();
		ventanaInicioSesion.addControlador(this);
		ventanaRegistro = new VentanaRegistro();
		ventanaRegistro.addControlador(this);
		ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.addControlador(this);
	}

	// Metodo para ejecutar el programa
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

	// El método ayuda a pasar de la ventana de la materia a la ventana principal
	public void volverPrincipal() {
		ventanaPrincipal.setVisible(true);
		ventanaMateria.dispose();
		ventanaMateria = null;
	}

	// El método ayuda a pasar de la ventana de inicio de sesión a la ventana de
	// registro
	public void registrar() {
		ventanaInicioSesion.clean();
		ventanaInicioSesion.setVisible(false);
		ventanaRegistro.setVisible(true);
	}

	// Ayuda a ingresar al aplicativo
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

	// Devuelve al inicio de sesión
	public void pantallaInicial() {
		usuario = null;
		ventanaInicioSesion.setVisible(true);
		ventanaPrincipal.setVisible(false);
	}

	// Pasa de la ventana principal a cualquiera de las de materias
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

	// Método para registrar un usuario
	public void registrarUsuario() {
		ManejoUsuario mu = new ManejoUsuario(new Usuario(ventanaRegistro.getNombres(), ventanaRegistro.getApellidos(),
				ventanaRegistro.getNickname(), ventanaRegistro.getPassword(), ventanaRegistro.getTipo()));
		mu.insertar();
		ventanaRegistro.clean();
		ventanaRegistro.dispose();
		ventanaInicioSesion.setVisible(true);
	}
}
