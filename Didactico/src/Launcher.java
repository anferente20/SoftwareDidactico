import java.awt.EventQueue;

import udistrital.thriscud.softwareEducativo.vista.InicioSesion;

public class Launcher {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion hola = new InicioSesion();
					hola.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
