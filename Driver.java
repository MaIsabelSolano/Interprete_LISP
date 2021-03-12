import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String instruccion="";
        interpreterLisp iL = new interpreterLisp();

        while(!instruccion.equalsIgnoreCase("salir")){
            System.out.println("\nBienvenido al interprete de lisp");
            System.out.println("Por favor, escribir el codigo en una unica linea de texto\n");
            instruccion = scan.nextLine();

            iL.readLine(instruccion);

            iL.executeLine();
        }
    }
}
