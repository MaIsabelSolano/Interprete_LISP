import java.util.*;

public class interpreterLisp{
    StackVector<String> stackCode = new StackVector<String>();
    ArrayList<Function> funciones = new ArrayList<Function>();
    Scanner scan = new Scanner(System.in);
    Variable var = new Variable();

    public void readLine(String expresion) {
        

        // Se separa la expresion y se mete a la lista de ops
        String[] separado = expresion.split(" ");
        for (int i = 0; i < separado.length; i++) {
            if(!separado[i].equals("(") && !separado[i].equals(")")){
                // System.out.println(separado[i]);
                stackCode.Push(separado[i]);
                
            }
        }
    }

    // en este codigo es donde ustedes tiene que enargarse
    // de que el java lea el primer valor y detecte una palabra
    public void executeLine(){
        // se revisa cual de las principales operaciones de Lisp es la primera palabra 
        for (int i = 0; i < stackCode.Size(); i++) {

            // se obtiene el primer dato de Stackcode
            String dato = stackCode.get(i);

            // En caso de ser una operacion aritmetica se realiza este codigo
            if(dato.equals("+") || dato.equals("/") || dato.equals("*") || dato.equals("-")){
                Arithmetic arit = new Arithmetic();
                String expresion = "";
                
                //verificar si se utiliza alguna variable
                for (int j = 0; j < stackCode.Size(); j++){
                    if (var.ExisteVariable(stackCode.get(j))){
                        //remplazar variable
                        String llave = stackCode.get(j);
                        stackCode.Set(j,var.Valor(llave));
                    }
                }
                // Se construye la expresion segun el codigo ingresado
                while(stackCode.Empty() == false) {
                    expresion += stackCode.Pop();
                    expresion += " ";
                }

                // Se inserta en al calculadora
                System.out.println(arit.Calculo(expresion));

                // Se limpia la lista para recibir otra instruccion
                stackCode.Clear();
                break;
            }

            // En caso de ser una condicion, se active este codigo
            if(dato.equalsIgnoreCase("COND")){
		// Crea una instancia de la clase Predicados poniendo la variable de error como false
                Predicados niu = new Predicados(false);

		// Corre el comando de Predicados Pred
                System.out.println(niu.Pred(stackCode));
		
		// Si la variable de error es true
                if(niu.isErr() == true){
                    System.out.println("No se logro verificar");
                }

                // Se limpia el codigo apra una siguiente instruccion
                stackCode.Clear();
                
                break;
            }

            // En caso de detectar un defun
            // Se ejecuta el codgio para guardar una funcion

            // Probar: ( defun convert-F-C ( x ) ( ( * ( - 32 x ) ( / 5 9.0 ) ) ) )  
            if(dato.equals("defun")){

                // Se hace pop de los valores importantes para almacenar la info
                // En una variable del tipo function
                stackCode.Popfirst();
                String nombre = stackCode.Popfirst();
                String parametro = stackCode.Popfirst();
                String codigo = "";

                // Se construye el codigo de la funcion
                for (int y = 0; y < stackCode.Size(); y++) {
                    codigo += stackCode.get(y);
                    codigo += " ";
                }

                // Los valores estan listos para formar parte de una funcion
                Function f = new Function(nombre, parametro, codigo);

                // Se añaden las funciones a la lsita de funciones
                funciones.add(f);

                // Se muestra la informacion al usuario
                f.show();
                System.out.println("La funcion se ha creado correctamente");

                // Se limpia la lista para recibir otra instruccion
                stackCode.Clear();
                break;           
            }

            else if(dato.equals("'") || dato.toUpperCase().equals("QUOTE") ){
                //quote
                String expresion = "";
                for (int j = 1; j < stackCode.Size(); j++) {
                    expresion += stackCode.get(j);
                }
                Quote quote = new Quote();
                quote.DevolverQuote(expresion);
                stackCode.Clear();

                break;
            }

            else if (dato.equals("defvar") || dato.equals("setq")){
                //Definir una variable
                try {
                    var.DefinirVariable(stackCode.get(1), stackCode.get(2));
                    System.out.println(var.Valor(stackCode.get(1)));
                }
                catch (IndexOutOfBoundsException e){
                    System.out.println("No se puede definir una variable vacía");
                    scan.nextLine();
                    break;
                }
                stackCode.Clear();
                break;
            }

            // en caso de que no sea ninguna de las anteriores, el codigo se trata de una funcion
            else {
                if(!funciones.isEmpty()){
                    for (int j = 0; j < funciones.size(); j++) {
                        Function fun = funciones.get(j);
                        if(dato.equals(fun.getName())){
                            // se procede a descomponer el codigo para ingresarlo al interperete
                            // se reemplazara el parametro elegido por el usuario
                            int valor = Integer.parseInt(stackCode.Pop());
                            String linea = fun.insertParameter(valor);
                            stackCode.Clear();
                            readLine(linea);
                            executeLine();
                        }
                    }
                // Se rompre la lectura ya que ya se cumplio la funcion
                stackCode.Clear();
                break;
                } else{
                    System.out.println("El valor ingresado es invalido o la funcion aun no se ha creado");
                }
            }
        }
    }

    public StackVector<String> getStackSigns() {
        return stackCode;
    }

    public ArrayList<Function> getFunciones() {
        return funciones;
    }
}
