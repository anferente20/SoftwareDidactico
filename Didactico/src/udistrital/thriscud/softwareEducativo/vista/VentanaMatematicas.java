package udistrital.thriscud.softwareEducativo.vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaMatematicas extends VentanaMateria {

	public VentanaMatematicas() {
		super();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1016, 750);
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

		JLabel lblContenedormientras = new JLabel("");
		lblContenedormientras.setIcon(
				new ImageIcon(VentanaMatematicas.class.getResource("/ElementosInterfaz/ContenedorMientrasMat.png")));
		lblContenedormientras.setBounds(319, 313, 681, 165);
		contentPane.add(lblContenedormientras);

		JLabel lblPanelizquierdo = new JLabel("");
		lblPanelizquierdo.setIcon(
				new ImageIcon(VentanaMatematicas.class.getResource("/ElementosInterfaz/ContenedorMatIzq.png")));
		lblPanelizquierdo.setBounds(10, 156, 329, 555);
		contentPane.add(lblPanelizquierdo);

		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(
				new ImageIcon(VentanaMatematicas.class.getResource("/ElementosInterfaz/tituloMatematicas.png")));
		lblTitulo.setBounds(-16, 0, 1016, 160);
		contentPane.add(lblTitulo);

		JLabel lblContenedorMientras = new JLabel("");
		lblContenedorMientras.setIcon(
				new ImageIcon(VentanaMatematicas.class.getResource("/ElementosInterfaz/ContenedorMientrasMat.png")));
		lblContenedorMientras.setBounds(319, 156, 681, 165);
		contentPane.add(lblContenedorMientras);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(
				new ImageIcon(VentanaMatematicas.class.getResource("/ElementosInterfaz/VentanaCategoriaMat.png")));
		lblFondo.setBounds(0, 0, 1000, 711);
		contentPane.add(lblFondo);
	}
}
