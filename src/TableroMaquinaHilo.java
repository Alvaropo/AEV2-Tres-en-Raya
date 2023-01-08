import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

									/*FALTA POR TERMINAR SISTEMA INICIO DE TURNO*/

/**
 * 
 * @author alvar
 *
 */
public class TableroMaquinaHilo implements Runnable {

    static Socket socket;
    static int omitir[] = {0,0,0,0,0,0,0,0,0};

    public TableroMaquinaHilo(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bf = new BufferedReader(isr);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);

            String pos = bf.readLine();
            System.err.println("SERVIDOR >>> Recibiendo valor: "+pos);
            //Los siguientes condicionales no estan implementados aun
            
            Thread.sleep(100);
            
            if (Integer.parseInt(pos) == 111) {
                System.err.println("SERVIDOR >>> SACA MAQUINA");
                Enviar(os, pw, bf);
                Recibir(is, isr, bf);  
            }
            
            if (Integer.parseInt(pos) == 222) {
            	System.err.println("SERVIDOR >>> SACA CLIENTE");
            	Recibir(is, isr, bf);
                Enviar(os, pw, bf);
            } else {
            	MeterPosiciones(pos);
            	Enviar(os, pw, bf);
                Recibir(is, isr, bf);
			}
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.err.println("SERVIDOR >>> Hilo " + Thread.currentThread().getName() + ">>> Error.");
        } 
    }

    /**
     * 
     * @param os
     * @param pw
     * @param bf
     * @throws IOException
     */
    public static void Enviar(OutputStream os, PrintWriter pw, BufferedReader bf) throws IOException {

        if (ArrayCompleto()) {
            bf.close();
        } else {
            pw.write(PosicionAleatoria() + "\n"); //retorna un num aleatorio para poner la x en el tablero
            System.err.println("SERVIDOR >>> Enviando posicion elegida de Maquina...");
            pw.flush();
            System.err.println("SERVIDOR >>> Espera nueva peticion ");
        }
        //bucle para mostrar el contenido del array por consola(es mi manera de pasar e interpretar los datos)
        for (int i = 0; i < omitir.length; i++) {
            System.err.println("SERVIDOR >>> MOSTRANDO ARRAY: " + omitir[i]);
        }
    }

    /**
     * 
     * @param is
     * @param isr
     * @param bf
     * @throws IOException
     */
    public static void Recibir(InputStream is, InputStreamReader isr, BufferedReader bf) throws IOException {
        System.err.println("SERVIDOR >>> Lee datos  ");
        String pos = bf.readLine();
        MeterPosiciones(pos);
    }

    /**
     * 
     * @return true si el array esta completo
     */
    public static boolean ArrayCompleto() { 				//comprueba si el array esta completo(es decir si las casillas del tablero estan llenas)
    	
        if (omitir[0] == 1 && omitir[1] == 2 && omitir[2] == 3 && omitir[3] == 4 && omitir[4] == 5 && omitir[6] == 7 &&
            omitir[7] == 8 && omitir[8] == 9) {
            return true;
        }
        return false;
    }

    /**
     * 
     * @param datos son las posiciones del tablero elegidas por el cliente y la maquina
     */
    public static void MeterPosiciones(String datos) { 		//Metodo para meter las posicion del cliente en el array del servidor
        switch (datos) {
            case "1":
                omitir[0] = 1;
                break;
            case "2":
                omitir[1] = 2;
                break;
            case "3":
                omitir[2] = 3;
                break;
            case "4":
                omitir[3] = 4;
                break;
            case "5":
                omitir[4] = 5;
                break;
            case "6":
                omitir[5] = 6;
                break;
            case "7":
                omitir[6] = 7;
                break;
            case "8":
                omitir[7] = 8;
                break;
            case "9":
                omitir[8] = 9;
                break;
        }
    }

    /**
     * 
     * @return random numero generado aleatoriamente  evitando las posiciones(numeros) ya usadas
     */
    public static int PosicionAleatoria() {
        int random = 1;
        boolean interruptor = true;
        
        do {
            random = (int)(Math.random() * 9 + 1);

            if (random != omitir[0] && random != omitir[1] && random != omitir[2] && random != omitir[3] &&
                random != omitir[4] && random != omitir[5] && random != omitir[6] && random != omitir[7] && random != omitir[8]) {
                interruptor = false;
            }
        } while (interruptor);
        MeterPosiciones(String.valueOf(random)); 			//Meto la posicion generada en el array de la maquina

        return random;
    }
}