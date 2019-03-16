package udistrital.thriscud.softwareEducativo.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMatematicas extends JFrame {

	private JPanel contentPane;
	private VentanaPrincipal principal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMatematicas frame = new VentanaMatematicas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaMatematicas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1016, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnInicio = new JButton("");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverInicio();
			}
		});
		btnInicio.setIcon(
				new ImageIcon(VentanaMatematicas.class.getResource("/ElementosInterfaz/botonCatMatInicio.png")));
		btnInicio.setBounds(113, 396, 122, 127);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setBorderPainted(false);
		contentPane.add(btnInicio);

		JButton btnPuntaje = new JButton("");
		btnPuntaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPuntaje.setIcon(
				new ImageIcon(VentanaMatematicas.class.getResource("/ElementosInterfaz/botonCatMatPuntaje.png")));
		btnPuntaje.setContentAreaFilled(false);
		btnPuntaje.setBorderPainted(false);
		btnPuntaje.setBounds(113, 534, 122, 118);
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

	public void volverInicio(){ 
		principal = new VentanaPrincipal(); //ESTO ES MACHETAZO, ES PARA QUE VEAN COMO FUNCIONA LA NAVEGACION DE LA APLICACION 
	}
}
