import java.util.Stack;
import java.util.*;

public class interpreterLisp{
    StackVector<String> stackCode = new StackVector<String>();
    ArrayList<Function> funciones = new ArrayList<Function>();
    Scanner scan = new Scanner(System.in);

    public void readLine(String expresion) {
        

        // Se separa la expresion y se mete a la lista de ops
        String[] separado = expresion.split(" ");
        for (int i = 0; i < separado.length; i++) {
            if(separado[i].equals("(")==false && separado[i].equals(")")==false){
                // System.out.println(separado[i]);
                stackCode.Push(separado[i]);
                
            }
        }
    }

    // en este codigo es donde ustedes tiene que enargarse
    // de que el java lea el primer valor y detecte una palabra
    public void executeLine(){
        for (int i = 0; i < stackCode.Size(); i++) {
            String dato = stackCode.get(i);

            if(dato.equals("+") || dato.equals("/") || dato.equals("*") || dato.equals("-")){
                Arithmetic arit = new Arithmetic();
                String expresion = "";
                
                for (int j = 0; j < stackCode.Size(); j++) {
                    expresion += stackCode.get(j);
                }

                StringBuilder builder=new StringBuilder(expresion);
                String sCadenaInvertida=builder.reverse().toString();

                System.out.println(sCadenaInvertida);
                System.out.println(arit.Calculo(sCadenaInvertida));
                stackCode.Clear();
                break;
            }

            if(dato.equals("defun")){
                stackCode.Popfirst();
                String nombre = stackCode.Popfirst();
                String parametro = stackCode.Popfirst();
                String codigo = "";

                for (int y = 0; y < stackCode.Size(); y++) {
                    codigo += stackCode.get(y);
                    codigo += " ";
                }
                Function f = new Function(nombre, parametro, codigo);
                funciones.add(f);
                f.show();
                System.out.println("La funcion se ha creado correctamente");
                stackCode.Clear();
                break;           
            }

            // en caso de que no sea ninguna de las anteriores, el codigo se trata de una funcion
            else {
                if(funciones.isEmpty() == false){
                    for (int j = 0; j < funciones.size(); j++) {
                        Function fun = funciones.get(j);
                        if(dato.equals(fun.getName())){
                            // se procede a descomponer el codigo para ingresarlo al interperete
                            // se reemplazara el parametro elegido por el usuario
                            int valor = scan.nextInt();
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