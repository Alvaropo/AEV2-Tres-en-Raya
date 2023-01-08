import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controlador {
    public static void main(String[] args) throws IOException, InterruptedException {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");

        String className = "ServidorTableroMultihilo";
        List < String > command = new ArrayList < > ();
        command.add(javaBin);
        command.add("-cp");
        command.add(classpath);
        command.add(className);
        ProcessBuilder builder = new ProcessBuilder(command);
        builder.inheritIO().start();

        className = "TableroCliente";
        command = new ArrayList < > ();
        command.add(javaBin);
        command.add("-cp");
        command.add(classpath);
        command.add(className);
        builder = new ProcessBuilder(command);
        builder.inheritIO().start();
    }
}