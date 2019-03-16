package udistrital.thriscud.softwareEducativo.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioSesion extends JFrame {

	private JTextField txtUsuario;
	public JButton btnIngresar;
	private JPasswordField pwdContrasena;
	private VentanaPrincipal principal;

	public InicioSesion() {
		initialize();
	}

	private void initialize() {
		Controlador controlador = new Controlador(this);
		setBounds(100, 100, 1000, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		btnIngresar.addActionListener(controlador);
		btnIngresar.setIcon(new ImageIcon(InicioSesion.class.getResource("/ElementosInterfaz/btnIngresar.png")));
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
		lblFondopanel.setIcon(new ImageIcon(InicioSesion.class.getResource("/ElementosInterfaz/contenedor.png")));
		lblFondopanel.setBounds(176, 134, 391, 464);
		panel.add(lblFondopanel);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(InicioSesion.class.getResource("/ElementosInterfaz/Titulo.png")));
		lblTitulo.setBounds(56, 39, 657, 107);
		panel.add(lblTitulo);
		
		JButton btnRegistrarse = new JButton("");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirRegistro();
			}
		});
		btnRegistrarse.setIcon(new ImageIcon(InicioSesion.class.getResource("/ElementosInterfaz/btnRegistrarse.png")));
		btnRegistrarse.setBounds(837, 565, 147, 146);
		btnRegistrarse.setContentAreaFilled(false);
		btnRegistrarse.setBorderPainted(false);
		getContentPane().add(btnRegistrarse);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(InicioSesion.class.getResource("/ElementosInterfaz/VentanaPrincipal.png")));
		lblFondo.setBounds(0, 0, 984, 711);
		getContentPane().add(lblFondo);
	}

	public void abrirRegistro(){
		VentanaRegistro registro  = new VentanaRegistro();
		registro.main(null);
	}
	
	public String getUsuario() {
		return txtUsuario.getText();
	}
	
	public String getPassword() {
		String rta = new String(pwdContrasena.getPassword());
		return rta;
	}
}
