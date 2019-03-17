package udistrital.thriscud.softwareEducativo.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import udistrital.thriscud.softwareEducativo.Controlador.Controlador;
import udistrital.thriscud.softwareEducativo.Controlador.ManejoUsuario;
import udistrital.thriscud.softwareEducativo.Logica.usuario.Usuario;
import udistrital.thriscud.softwareEducativo.conexionBD.Conection;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtNickname;
	private JTextField txtContrasena;
	private JComboBox cbxTipo;
	private JButton btnRegistrarse;

	public JButton getBtnRegistrarse() {
		return btnRegistrarse;
	}

	public VentanaRegistro() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnRegistrarse = new JButton("");
		btnRegistrarse.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/ElementosInterfaz/btnIngresar.png")));
		btnRegistrarse.setBounds(365, 567, 282, 100);
		btnRegistrarse.setContentAreaFilled(false);
		btnRegistrarse.setBorderPainted(false);
		contentPane.add(btnRegistrarse);

		txtNombres = new JTextField();
		txtNombres.setForeground(new Color(47, 79, 79));
		txtNombres.setFont(new Font("Agency FB", Font.PLAIN, 30));
		txtNombres.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombres.setBounds(497, 207, 205, 42);
		contentPane.add(txtNombres);
		txtNombres.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		txtApellidos.setForeground(new Color(47, 79, 79));
		txtApellidos.setFont(new Font("Agency FB", Font.PLAIN, 30));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(497, 278, 205, 42);
		contentPane.add(txtApellidos);

		txtNickname = new JTextField();
		txtNickname.setHorizontalAlignment(SwingConstants.LEFT);
		txtNickname.setForeground(new Color(47, 79, 79));
		txtNickname.setFont(new Font("Agency FB", Font.PLAIN, 30));
		txtNickname.setColumns(10);
		txtNickname.setBounds(497, 357, 205, 42);
		contentPane.add(txtNickname);

		txtContrasena = new JTextField();
		txtContrasena.setHorizontalAlignment(SwingConstants.LEFT);
		txtContrasena.setForeground(new Color(47, 79, 79));
		txtContrasena.setFont(new Font("Agency FB", Font.PLAIN, 30));
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(497, 425, 205, 42);
		contentPane.add(txtContrasena);

		cbxTipo = new JComboBox();
		cbxTipo.addItem("Profesor");
		cbxTipo.addItem("Estudiante");
		cbxTipo.setForeground(new Color(47, 79, 79));
		cbxTipo.setFont(new Font("Agency FB", Font.PLAIN, 30));
		cbxTipo.setBounds(497, 498, 205, 42);
		contentPane.add(cbxTipo);

		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setForeground(new Color(255, 255, 255));
		lblNombres.setFont(new Font("Agency FB", Font.BOLD, 35));
		lblNombres.setBounds(298, 205, 156, 42);
		contentPane.add(lblNombres);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(new Color(255, 255, 255));
		lblApellidos.setFont(new Font("Agency FB", Font.BOLD, 35));
		lblApellidos.setBounds(298, 276, 156, 42);
		contentPane.add(lblApellidos);

		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setForeground(new Color(255, 255, 255));
		lblNickname.setFont(new Font("Agency FB", Font.BOLD, 35));
		lblNickname.setBounds(298, 355, 156, 42);
		contentPane.add(lblNickname);

		JLabel lblContrasena = new JLabel("Contrase�a");
		lblContrasena.setForeground(new Color(255, 255, 255));
		lblContrasena.setFont(new Font("Agency FB", Font.BOLD, 35));
		lblContrasena.setBounds(298, 423, 156, 42);
		contentPane.add(lblContrasena);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(new Color(255, 255, 255));
		lblTipo.setFont(new Font("Agency FB", Font.BOLD, 35));
		lblTipo.setBounds(298, 498, 156, 42);
		contentPane.add(lblTipo);

		JLabel lblContenedorregistro = new JLabel("");
		lblContenedorregistro
				.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/ElementosInterfaz/contenedorGrande.png")));
		lblContenedorregistro.setBounds(191, 126, 640, 585);
		contentPane.add(lblContenedorregistro);

		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/ElementosInterfaz/Titulo.png")));
		lblTitulo.setBounds(178, 11, 660, 106);
		contentPane.add(lblTitulo);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/ElementosInterfaz/VentanaPrincipal.png")));
		lblFondo.setBounds(10, 0, 984, 711);
		contentPane.add(lblFondo);
	}

	public void clean() {
		txtApellidos.setText("");
		txtNickname.setText("");
		txtNombres.setText("");
		txtContrasena.setText("");
	}

	/** M�todo del boton ingresar, que registra al usuario */

	public int getTipo() {
		if (cbxTipo.getSelectedItem().equals("Profesor"))
			return 1;
		else
			return 2;

	}

	public String getNombres() {
		return txtNombres.getText();
	}

	public String getApellidos() {
		return txtApellidos.getText();
	}

	public String getNickname() {
		return txtNickname.getText();
	}

	public String getPassword() {
		return txtContrasena.getText();
	}

	public void addControlador(Controlador controlador) {
		btnRegistrarse.addActionListener(controlador);
	}
}
