import java.util.ArrayList;

public class Predicados {
    
    // Crea la variable de error 
    boolean err;

    public Predicados(boolean err) {
        this.err = err;
    }

    public boolean isErr() {
        return err;
    }

    public boolean Pred(StackVector<String> op){
        err = false;
        boolean res = false;

        ArrayList<String> ops = new ArrayList<String>();

        // Se crea una lista segun el tamaño del codigo anterior
        String[] separado = new String[op.Size()];

        // Alamcenar en ops
        for (int i = 0; i < separado.length; i++) {
            separado[i] = op.get(i);
            ops.add(separado[i]);
        }
        
        // Revisa que tenga la sintaxis de condicionales y no tenga mas de 4 elementos contando cond, las variables a comparar y el tipo de comparacion
        if(ops.get(0).equalsIgnoreCase("COND") && separado.length == 4){
            
            // Si se compara con menor que
            if(ops.get(1).equalsIgnoreCase("<")){
                // Se verifica qe las variables a comparar sean numeros
                if(ops.get(2).matches("[+-]?\\d*(\\.\\d+)?") && ops.get(3).matches("[+-]?\\d*(\\.\\d+)?")){
                    // Se meten en variables
                    float number = Float.parseFloat(ops.get(2));
                    float number2 = Float.parseFloat(ops.get(3));
                    System.out.println(number + " < " + number2);
                    // Se comparan
                    res = number < number2;
                    return res;
                } else {
                    // Si ambas no son numeros
                    System.out.println("Error");
                    err = true;

                    return res;
                }
            // Si se compara con mayor que    
            }else if (ops.get(1).equalsIgnoreCase(">")){
                // Se verifica qe las variables a comparar sean numeros
                if(ops.get(2).matches("[+-]?\\d*(\\.\\d+)?") && ops.get(3).matches("[+-]?\\d*(\\.\\d+)?")){
                    // Se meten en variables
                    float number = Float.parseFloat(ops.get(2));
                    float number2 = Float.parseFloat(ops.get(3));
                    System.out.println(number + " > " + number2);
                    // Se comparan
                    res = number > number2;
                    return res;

                } else {
                    // Si ambas no son numeros
                    System.out.println("Error");
                    err = true;

                    return res;
                }
            // Si se compara con igual    
            }else if(ops.get(1).equalsIgnoreCase("=") || ops.get(1).equalsIgnoreCase("equals")){
                // Se verifica qe las variables a comparar sean numeros
                if(ops.get(2).matches("[+-]?\\d*(\\.\\d+)?") && ops.get(3).matches("[+-]?\\d*(\\.\\d+)?")){
                    float number = Float.parseFloat(ops.get(2));
                    float number2 = Float.parseFloat(ops.get(3));
                    System.out.println(number + " = " + number2);
                    // Se comparan
                    res = number == number2;
                    return res;
                } else {
                    //Si ambas no son numeros
                    System.out.println("Error");
                    err = true;

                    return res;
                }
            } else {
                // Si no se comparan por los metodos esperados
                System.out.println("Error");
                err = true;
                return res;
            }
            
            // Revisa que tenga la sintaxis de condicionales y no tenga mas de 3 elementos incluyendo las sintaxis Atom, Cond y la variable a comparar     
        }else if (ops.get(0).equalsIgnoreCase("COND") && separado.length == 3){
            
            if(ops.get(1).equalsIgnoreCase("ATOM")){
                // Revisa si es numero
                if (res = ops.get(2).matches("[+-]?\\d*(\\.\\d+)?")){
                    System.out.println(ops.get(2) + " es un numero");
                } else {
                    System.out.println(ops.get(2) + " no es un numero");
                }
                
                
                return res;
            } else {
                // Si no es Atom
                System.out.println("Error");
                err = true;
                return res;
            }
        }else{
            // Si no contiene COND y/o no cumple con las condiciones del numero de elementos
            System.out.println("Error");
            err = true;
            return res;
        }
    }
}