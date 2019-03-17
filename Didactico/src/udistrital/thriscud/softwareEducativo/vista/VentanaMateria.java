package udistrital.thriscud.softwareEducativo.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import udistrital.thriscud.softwareEducativo.Controlador.Controlador;

public abstract class VentanaMateria extends JFrame {
	protected JPanel contentPane;
	protected VentanaPrincipal principal;
	protected JButton btnInicio;
	protected JButton btnPuntaje;

	/*
	 * Se deja comentareado el arraylist de todos los distintos juegos para cuando
	 * los creen 
	 */
//  protected ArrayList<PJuego> pnlJuegos;
	public VentanaMateria() {
		btnInicio = new JButton("");
		btnInicio.setBounds(113, 396, 122, 127);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setBorderPainted(false);

		btnPuntaje = new JButton("");
		btnPuntaje.setContentAreaFilled(false);
		btnPuntaje.setBorderPainted(false);
		btnPuntaje.setBounds(113, 534, 122, 118);
	}

	public JButton getBtnPuntaje() {
		return btnPuntaje;
	}

	public JButton getBtnInicio() {
		return btnInicio;
	}

	public void addControlador(Controlador controlador) {
		btnInicio.addActionListener(controlador);
		btnPuntaje.addActionListener(controlador);
	}
}
