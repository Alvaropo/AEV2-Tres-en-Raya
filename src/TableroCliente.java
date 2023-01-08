import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TableroCliente extends JFrame {

    private JPanel contentPane;
    private static JButton btn1;
    private static JButton btn2;
    private static JButton btn3;
    private static JButton btn4;
    private static JButton btn5;
    private static JButton btn6;
    private static JButton btn7;
    private static JButton btn8;
    private static JButton btn9;
    private static JButton btnPar;
    private static JLabel lblLinea;
    private static JLabel lblEmpieza;
    private JButton btnImpar;
    private static boolean interruptor=false;
    public static int valorEmpieza;
    static int cnt = 0;
    static int omitir[] = {0,0,0,0,0,0,0,0,0};   
    
    
   
    
    								/*FALTA POR TERMINAR SISTEMA INICIO DE TURNO*/

    /**
     * Launch the application.
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TableroCliente frame = new TableroCliente();
                    frame.setVisible(true);
                    DesactivarBotones();  		//este metodo se utilizaria si sistema de inicio de turno estuviera bien implementado
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 
     */
    public TableroCliente() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 663, 343);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        btn1 = new JButton("");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn1.setText(AlternarXO());
                omitir[0] = 1;
                TransmisionDatos(getBtn1());
                Linea();
            }
        });

        System.out.println(btn1.getText());

        btn2 = new JButton("");
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn2.setText(AlternarXO());
                omitir[1] = 2;
                TransmisionDatos(getBtn2());
                Linea();
            }
        });
        btn2.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn2.setBounds(109, 11, 89, 81);
        contentPane.add(btn2);

        btn3 = new JButton("");
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn3.setText(AlternarXO());
                omitir[2] = 3;
                TransmisionDatos(getBtn3());
                Linea();
            }
        });
        btn3.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn3.setBounds(208, 11, 89, 81);
        contentPane.add(btn3);

        btn4 = new JButton("");
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn4.setText(AlternarXO());
                omitir[3] = 4;
                TransmisionDatos(getBtn4());
                Linea();
            }
        });
        btn4.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn4.setBounds(10, 102, 89, 81);
        contentPane.add(btn4);

        btn5 = new JButton("");
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn5.setText(AlternarXO());
                omitir[4] = 5;
                TransmisionDatos(getBtn5());
                Linea();
            }
        });
        btn5.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn5.setBounds(109, 102, 89, 81);
        contentPane.add(btn5);

        btn6 = new JButton("");
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn6.setText(AlternarXO());
                omitir[5] = 6;
                TransmisionDatos(getBtn6());
                Linea();
            }
        });
        btn6.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn6.setBounds(208, 102, 89, 81);
        contentPane.add(btn6);

        btn7 = new JButton("");
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn7.setText(AlternarXO());
                omitir[6] = 7;
                TransmisionDatos(getBtn7());
                Linea();
            }
        });
        btn7.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn7.setBounds(10, 194, 89, 81);
        contentPane.add(btn7);

        btn8 = new JButton("");
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn8.setText(AlternarXO());
                omitir[7] = 8;
                TransmisionDatos(getBtn8());
                Linea();
            }
        });
        btn8.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn8.setBounds(109, 194, 89, 81);
        contentPane.add(btn8);

        btn9 = new JButton("");
        btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn9.setText(AlternarXO());
                omitir[8] = 9;
                TransmisionDatos(getBtn9());
                Linea();
            }
        });
        btn9.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn9.setBounds(208, 194, 89, 81);
        contentPane.add(btn9);

        JLabel lblNewLabel_1 = new JLabel("|");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 99));
        lblNewLabel_1.setBounds(307, -28, 38, 154);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("|");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 99));
        lblNewLabel_2.setBounds(307, 150, 38, 154);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Numero aleatorio generado,\r\nindique si es par o impar.");
        lblNewLabel_3.setBounds(333, 11, 304, 14);
        contentPane.add(lblNewLabel_3);

        lblLinea = new JLabel("");
        lblLinea.setForeground(new Color(255, 0, 0));
        lblLinea.setFont(new Font("Tahoma", Font.PLAIN, 45));
        lblLinea.setBounds(412, 161, 225, 53);
        contentPane.add(lblLinea);

        JLabel lblNewLabel = new JLabel("|");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 99));
        lblNewLabel.setBounds(307, 60, 38, 154);
        contentPane.add(lblNewLabel);
        btn1.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn1.setBounds(10, 11, 89, 81);
        contentPane.add(btn1);

        btnPar = new JButton("Cliente");
        btnPar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                
                    //QuienSaca(getBtnPar());
            	EnviarQuienEmpieza(222);
            	valorEmpieza=222;
            }  
        });
        btnPar.setBounds(380, 49, 89, 23);
        contentPane.add(btnPar);

        btnImpar = new JButton("Servidor");
        btnImpar.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
                
                    
						//QuienSaca(getBtnImpar());
					
                	EnviarQuienEmpieza(111);
                	valorEmpieza=111;
               
            }
        });
        btnImpar.setBounds(508, 49, 89, 23);
        contentPane.add(btnImpar);

        lblEmpieza = new JLabel("Empieza: ");
        lblEmpieza.setBounds(423, 100, 126, 14);
        contentPane.add(lblEmpieza);
    }

    
    
    /**
     * 
     * @param datos es la posicion elegida por el cliente mediante la pulsacion de cualquier boton del tablero, se establece del 1 (primera posicion) al 9 (ultima posicion).
     */
    public static void TransmisionDatos(int datos) { 		//METODO PARA ENVIAR DATOS DE LA CONEXION(ARRAYS)

        try {
            InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);
            Socket socket = new Socket();
            socket.connect(direccion);
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bfr = new BufferedReader(isr);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            Enviar(datos, pw);
            Recibir(is, pw, isr, bfr);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * @param empieza numero entero que recibe la maquina para posteriormente interpretarlo
     * @throws IOException
     */
    public static void EnviarQuienEmpieza(int empieza) { //Envia los datos para determinar quien empieza

    	try {
    		InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);
            Socket socket = new Socket();
            socket.connect(direccion);
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bfr = new BufferedReader(isr);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
        	
            pw.print(empieza+"\n");
            pw.flush();
            System.out.println("CLIENTE >>> Datos EMPIEZA enviados");
            
            
            if (empieza==111) {
            	lblEmpieza.setText("Empieza: SERVIDOR");
	            Recibir(is, pw, isr, bfr);
			}else {
				lblEmpieza.setText("Empieza: CLIENTE");
			}
            ActivarBotones();
           
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    
    /**
     * 
     * @param datos datos es la posicion elegida por el cliente mediante la pulsacion de cualquier boton del tablero, se establece del 1 (primera posicion) al 9 (ultima posicion).
     * @param pw
     */
    public static void Enviar(int datos, PrintWriter pw) {
        pw.print(datos + "\n");
        pw.print(datos + "\n");
        pw.flush();
        System.out.println("CLIENTE >>> Datos enviados");
    }

    /**
     * 
     * @param is
     * @param pw
     * @param isr
     * @param bfr
     * @throws IOException
     * @throws InterruptedException
     */
    public static void Recibir(InputStream is, PrintWriter pw, InputStreamReader isr, BufferedReader bfr) throws IOException, InterruptedException {
        System.out.println("CLIENTE >>> Preparado canal para recibir resultado");

        String resultado = bfr.readLine();
        Thread.sleep(100);
        System.out.println("CLIENTE >>> Recibe resultado: " + resultado);
        
        RecibePosicionMaquina(resultado); 				//Metodo para interpretar el resultado recibido(poner en array)
        Linea();
        
        
        pw.close();
    }

    
    

    /**
     * 
     * @return O/X simbolos utilizados para mostrar en el tablero
     */
    public static String AlternarXO() { 				//METODO PARA ALTERNAR X/O EN CADA TIRADA(es usada en el actionPerformed de cada boton)
        cnt++;

        if (cnt % 2 == 0) {
            return "X";
        } else {
            return "O";
        }
    }
    
    
    public static void DesactivarBotones() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }
    public static void ActivarBotones() {
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
    }

    /**
     * 
     * @param posicion Recibe la posicion generada por la maquina, la introduce en el array y lo muestra por el tablero
     */
    public static void RecibePosicionMaquina(String posicion) {  

        switch (posicion) {
            case "1":
                omitir[0] = 1;
                btn1.setText(AlternarXO());
                break;
            case "2":
                omitir[1] = 2;
                btn2.setText(AlternarXO());
                break;
            case "3":
                omitir[2] = 3;
                btn3.setText(AlternarXO());
                break;
            case "4":
                omitir[3] = 4;
                btn4.setText(AlternarXO());
                break;
            case "5":
                omitir[4] = 5;
                btn5.setText(AlternarXO());
                break;
            case "6":
                omitir[5] = 6;
                btn6.setText(AlternarXO());
                break;
            case "7":
                omitir[6] = 7;
                btn7.setText(AlternarXO());
                break;
            case "8":
                omitir[7] = 8;
                btn8.setText(AlternarXO());
                break;
            case "9":
                omitir[8] = 9;
                btn9.setText(AlternarXO());
                break;
        }

    }
    
    /**
     * 
     * @return retorna true si no ha linea, retorna false en caso de linea
     */
    public static boolean Linea() {			//METODO PARA COMPROBAR LINEA Y TERMINAR EL JUEGO(todas posibles combinaciones)
    	
        if (btn1.getText() == "X" && btn2.getText() == "X" && btn3.getText() == "X" || btn1.getText() == "O" && btn2.getText() == "O" && btn3.getText() == "O") {
            System.out.println("LINEA!");
            lblLinea.setText("LINEA!");
            DesactivarBotones();
            return false;
        }
        if (btn4.getText() == "X" && btn5.getText() == "X" && btn6.getText() == "X" || btn4.getText() == "O" && btn5.getText() == "O" && btn6.getText() == "O") {
            System.out.println("LINEA!");
            lblLinea.setText("LINEA!");
            DesactivarBotones();
            return false;
        }
        if (btn7.getText() == "X" && btn8.getText() == "X" && btn9.getText() == "X" || btn7.getText() == "O" && btn8.getText() == "O" && btn9.getText() == "O") {
            System.out.println("LINEA!");
            lblLinea.setText("LINEA!");
            DesactivarBotones();
            return false;
        }
        if (btn1.getText() == "X" && btn4.getText() == "X" && btn7.getText() == "X" || btn1.getText() == "O" && btn4.getText() == "O" && btn7.getText() == "O") {
            System.out.println("LINEA!");
            lblLinea.setText("LINEA!");
            DesactivarBotones();
            return false;
        }
        if (btn2.getText() == "X" && btn5.getText() == "X" && btn8.getText() == "X" || btn2.getText() == "O" && btn5.getText() == "O" && btn8.getText() == "O") {
            System.out.println("LINEA!");
            lblLinea.setText("LINEA!");
            DesactivarBotones();
            return false;
        }
        if (btn3.getText() == "X" && btn6.getText() == "X" && btn9.getText() == "X" || btn3.getText() == "O" && btn6.getText() == "O" && btn9.getText() == "O") {
            System.out.println("LINEA!");
            lblLinea.setText("LINEA!");
            DesactivarBotones();
            return false;
        }
        if (btn1.getText() == "X" && btn5.getText() == "X" && btn9.getText() == "X" || btn1.getText() == "O" && btn5.getText() == "O" && btn9.getText() == "O") {
            System.out.println("LINEA!");
            lblLinea.setText("LINEA!");
            DesactivarBotones();
            return false;
        }
        if (btn3.getText() == "X" && btn5.getText() == "X" && btn7.getText() == "X" || btn3.getText() == "O" && btn5.getText() == "O" && btn7.getText() == "O") {
            System.out.println("LINEA!");
            lblLinea.setText("LINEA!");
            DesactivarBotones();
            return false;
        }
        if (btn1.getText()!=""&&btn2.getText()!=""&&btn3.getText()!=""&&btn4.getText()!=""&&btn5.getText()!=""&&btn6.getText()!=""&&btn7.getText()!=""&&btn8.getText()!=""&&btn9.getText()!=""&&btn1.getText()!="") {
        	System.out.println("EMPATE!");
            lblLinea.setText("EMPATE!");
            DesactivarBotones();
		}
        return true;
    }

    public static int getBtnPar() {
        return 2;
    }

    public int getBtnImpar() {
        return 1;
    }

    public static int getBtn1() {
        return 1;
    }

    public static int getBtn2() {
        return 2;
    }

    public static int getBtn3() {
        return 3;
    }

    public static int getBtn4() {
        return 4;
    }

    public static int getBtn5() {
        return 5;
    }

    public static int getBtn6() {
        return 6;
    }

    public static int getBtn7() {
        return 7;
    }

    public static int getBtn8() {
        return 8;
    }

    public static int getBtn9() {
        return 9;
    }
}