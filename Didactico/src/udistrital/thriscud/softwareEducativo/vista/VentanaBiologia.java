package udistrital.thriscud.softwareEducativo.vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaBiologia extends VentanaMateria {

	public VentanaBiologia() {
		super();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1016, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnInicio.setIcon(
				new ImageIcon(VentanaMatematicas.class.getResource("/ElementosInterfaz/botonCatMatInicio.png")));
		contentPane.add(btnInicio);

		btnPuntaje.setIcon(
				new ImageIcon(VentanaMatematicas.class.getResource("/ElementosInterfaz/botonCatMatPuntaje.png")));
		contentPane.add(btnPuntaje);

		JLabel lblContenedorMientras = new JLabel("contenedor mientras");
		lblContenedorMientras.setIcon(
				new ImageIcon(VentanaBiologia.class.getResource("/ElementosInterfaz/ContenedorMientrasBio.png")));
		lblContenedorMientras.setBounds(322, 168, 678, 147);
		contentPane.add(lblContenedorMientras);

		JLabel lblPanelIzquierdo = new JLabel("");
		lblPanelIzquierdo
				.setIcon(new ImageIcon(VentanaBiologia.class.getResource("/ElementosInterfaz/ContenedorBioIzq.png")));
		lblPanelIzquierdo.setBounds(10, 153, 323, 571);
		contentPane.add(lblPanelIzquierdo);

		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(VentanaBiologia.class.getResource("/ElementosInterfaz/tituloBiologia.png")));
		lblTitulo.setBounds(149, -1, 729, 183);
		contentPane.add(lblTitulo);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(
				new ImageIcon(VentanaBiologia.class.getResource("/ElementosInterfaz/VentanaCategoriaBio.png")));
		lblFondo.setBounds(0, 0, 1000, 721);
		contentPane.add(lblFondo);
	}

}
