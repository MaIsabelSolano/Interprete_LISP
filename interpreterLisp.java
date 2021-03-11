import java.util.Stack;
import java.util.*;

public class interpreterLisp{
    StackVector<String> stackCode = new StackVector<String>();
    ArrayList<Function> funciones = new ArrayList<Function>();

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

                System.out.println(arit.Calculo(sCadenaInvertida));
                break;
            }

            if(dato.equals("defun")){
                stackCode.Popfirst();
                String nombre = stackCode.Popfirst();
                String parametro = stackCode.Popfirst();
                String codigo = "";

                for (int y = 0; y < stackCode.Size(); y++) {
                    codigo += stackCode.get(y);
                }
                Function f = new Function(nombre, parametro, codigo);
                funciones.add(f);
                funciones.get(0).show();           
            }
        }
    }

    public StackVector<String> getStackSigns() {
        return stackCode;
    }
}