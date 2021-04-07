import java.util.*;
/*
@Author Marco Pablo Orozco Saravia, M. Solano, Jose Pablo Diaz
*/

public class Driver {
    
    /** 
     * @param args
     */
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
            iL.cleanLine();
        }
    }
}
