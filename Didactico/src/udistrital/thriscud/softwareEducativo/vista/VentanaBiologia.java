package udistrital.thriscud.softwareEducativo.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VentanaBiologia extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBiologia frame = new VentanaBiologia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaBiologia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1016, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
