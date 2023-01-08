import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTableroMultihilo {

	
	public static void main(String[] args )throws IOException, InterruptedException {
		
		System.err.println("SERVIDOR >>> Arranca el servidor, espera peticion");
		ServerSocket socketEscucha = null;
	
		try {
			socketEscucha = new ServerSocket(9876);
		} catch (IOException e) {
		System.err.println("SERVIDOR >>> Error");
		return;
		}
		while (true) {
		Socket conexion = socketEscucha.accept();
		System.err.println("SERVIDOR >>> Conexion recibida --> Lanza hilo");

		TableroMaquinaHilo h = new TableroMaquinaHilo(conexion) ;
		Thread hilo = new Thread(h);
		hilo.start();

		}
	}
}
