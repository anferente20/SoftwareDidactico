import udistrital.thriscud.softwareEducativo.Controlador.Controlador;

public class Launcher {
	public static void main(String[] args) {
		try {
			Controlador controlador = new Controlador();
			controlador.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
