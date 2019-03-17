package udistrital.thriscud.softwareEducativo.vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import udistrital.thriscud.softwareEducativo.Controlador.Controlador;

public class VentanaInicioSesion extends JFrame {

	private JTextField txtUsuario;
	private JButton btnIngresar;
	private JPasswordField pwdContrasena;
	private JButton btnRegistrarse;

	public VentanaInicioSesion() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(105, 11, 723, 666);
		panel.setOpaque(false);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Agency FB", Font.BOLD, 35));
		lblUsuario.setBounds(253, 238, 220, 39);
		panel.add(lblUsuario);

		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasena.setForeground(Color.WHITE);
		lblContrasena.setFont(new Font("Agency FB", Font.BOLD, 35));
		lblContrasena.setBounds(253, 371, 220, 39);
		panel.add(lblContrasena);

		btnIngresar = new JButton("");
		btnIngresar.setIcon(new ImageIcon(VentanaInicioSesion.class.getResource("/ElementosInterfaz/btnIngresar.png")));
		btnIngresar.setBounds(237, 548, 274, 107);
		btnIngresar.setBorderPainted(false);
		btnIngresar.setContentAreaFilled(false);
		panel.add(btnIngresar);

		txtUsuario = new JTextField();
		txtUsuario.setForeground(new Color(47, 79, 79));
		txtUsuario.setFont(new Font("Agency FB", Font.PLAIN, 30));
		txtUsuario.setBounds(253, 288, 220, 52);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		pwdContrasena = new JPasswordField();
		pwdContrasena.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pwdContrasena.setBounds(253, 434, 220, 52);
		panel.add(pwdContrasena);

		JLabel lblFondopanel = new JLabel("");
		lblFondopanel
				.setIcon(new ImageIcon(VentanaInicioSesion.class.getResource("/ElementosInterfaz/contenedor.png")));
		lblFondopanel.setBounds(176, 134, 391, 464);
		panel.add(lblFondopanel);

		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(VentanaInicioSesion.class.getResource("/ElementosInterfaz/Titulo.png")));
		lblTitulo.setBounds(56, 39, 657, 107);
		panel.add(lblTitulo);

		btnRegistrarse = new JButton("");
		btnRegistrarse
				.setIcon(new ImageIcon(VentanaInicioSesion.class.getResource("/ElementosInterfaz/btnRegistrarse.png")));
		btnRegistrarse.setBounds(837, 565, 147, 146);
		btnRegistrarse.setContentAreaFilled(false);
		btnRegistrarse.setBorderPainted(false);
		getContentPane().add(btnRegistrarse);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(
				new ImageIcon(VentanaInicioSesion.class.getResource("/ElementosInterfaz/VentanaPrincipal.png")));
		lblFondo.setBounds(0, 0, 984, 711);
		getContentPane().add(lblFondo);
	}

	public void addControlador(Controlador controlador) {
		btnIngresar.addActionListener(controlador);
		btnRegistrarse.addActionListener(controlador);
	}

	public JButton getBtnRegistrarse() {
		return btnRegistrarse;
	}

	public String getUsuario() {
		return txtUsuario.getText();
	}

	public String getPassword() {
		String rta = new String(pwdContrasena.getPassword());
		return rta;
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public void clean() {
		pwdContrasena.setText("");
		txtUsuario.setText("");
	}
}
