package udistrital.thriscud.softwareEducativo.vista;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import udistrital.thriscud.softwareEducativo.Controlador.Controlador;

public class VentanaPrincipal extends JFrame {
	private JPanel panelPrincipal;
	private JButton btnMat;
	private JButton btnInf;
	private JButton btnBio;
	private JButton btnCrditos;
	private JButton btnCerrarSesion;

	public VentanaPrincipal() {
		setBounds(100, 100, 1000, 750);
		getContentPane().setLayout(null);
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(253, 245, 230));
		panelPrincipal.setLayout(null);

		btnMat = new JButton("");
		btnMat.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ElementosInterfaz/logoMat.png")));
		btnMat.setBounds(72, 264, 270, 250);
		btnMat.setContentAreaFilled(false);
		btnMat.setBorderPainted(false);
		panelPrincipal.add(btnMat);

		btnBio = new JButton("");
		btnBio.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ElementosInterfaz/logoBio.png")));
		btnBio.setBounds(352, 264, 270, 250);
		btnBio.setContentAreaFilled(false);
		btnBio.setBorderPainted(false);
		panelPrincipal.add(btnBio);

		btnInf = new JButton("");
		btnInf.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ElementosInterfaz/logInf.png")));
		btnInf.setBounds(643, 264, 270, 250);
		btnInf.setContentAreaFilled(false);
		btnInf.setBorderPainted(false);
		panelPrincipal.add(btnInf);

		JLabel lblTituloprograma = new JLabel("");
		lblTituloprograma.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ElementosInterfaz/Titulo.png")));
		lblTituloprograma.setBounds(257, 41, 672, 167);
		panelPrincipal.add(lblTituloprograma);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ElementosInterfaz/Logo.png")));
		lblLogo.setBounds(23, 11, 221, 242);
		panelPrincipal.add(lblLogo);

		JLabel lblFondoprincipal = new JLabel("");
		lblFondoprincipal
				.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ElementosInterfaz/VentanaPrincipal.png")));
		lblFondoprincipal.setBounds(0, 0, 984, 711);
		panelPrincipal.add(lblFondoprincipal);

		btnCrditos = new JButton("Cr\u00E9ditos");
		btnCrditos.setBounds(840, 677, 89, 23);
		panelPrincipal.add(btnCrditos);

		btnCerrarSesion = new JButton("cerrar sesion");
		btnCerrarSesion.setBounds(96, 677, 89, 23);
		panelPrincipal.add(btnCerrarSesion);

		anadirCaracteristicas();
	}

	private void anadirCaracteristicas() {
		panelPrincipal.setBounds(0, 0, 984, 711);
		getContentPane().add(panelPrincipal);
	}

	public void addControlador(Controlador controlador) {
		btnBio.addActionListener(controlador);
		btnMat.addActionListener(controlador);
		btnInf.addActionListener(controlador);
		btnCerrarSesion.addActionListener(controlador);
		btnCrditos.addActionListener(controlador);
	}

	public JButton getBtnBio() {
		return btnBio;
	}

	public JButton getBtnMat() {
		return btnMat;
	}
	
	public JButton getBtnInf() {
		return btnInf;
	}
	
	public JButton getBtnCreditos() {
		return btnCrditos;
	}
	
	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}
}
