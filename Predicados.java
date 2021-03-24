import java.util.*;
import java.util.Collections;

public class Predicados {
    public String Calculo(String expresion) {
        // Esta variable es para guardar el progreso de la operacion
        boolean continuacion = false;

        // Stacks para guardar los valores
        StackVector<Float> numbers = new StackVector<Float>();
        StackVector<String> sign = new StackVector<String>();
        // Array para guardar los valores uno por uno
        ArrayList<String> ops = new ArrayList<String>();

        // Se separa la expresion y se mete a la lista de ops
        String[] separado = expresion.split(" ");
        for (int i = 0; i < separado.length; i++) {
            ops.add(separado[i]);
        }

        // Comienza el proceso de calculo
        // Este for guarda los valores
        for (int j = 0; j < ops.size(); j++) {
            try {// En caso de ser un numero lo convertiraa y lo metera a los numeros
                float number = Float.parseFloat(ops.get(j));
                numbers.Push(number);
            } catch (Exception ex) {// En caso de no ser un numero se activara la excepcion y se tomara el texto
                sign.Push(ops.get(j));
                // Primero se comprueba que los numeros no excedan la capacidad de las
                // operaciones
                int verifier = numbers.Size() - sign.Size();
                if (verifier > 2) {
                    return "No se puede operar, hay demasiados numeros";
                }
                try {
                    // Extraer los numeros
                    float num1 = numbers.Pop();
                    float num2 = numbers.Pop();

                    // Extraer el signo que se acaba de detectar
                    String operando = sign.Pop();
                    // Verificar cual es el signo
                    if (operando.equalsIgnoreCase("<")) {
                        if (num2 < num1){
                            continuacion = true;
                        }else {
                            continuacion = false;
                        }
                    } else if (operando.equalsIgnoreCase(">")) {
                        continuacion = num2 > num1;
                    } else if (operando.equalsIgnoreCase("=")) {
                        continuacion = num2 == num1;
                    }

                } catch (Exception e) {// En caso de no haber numeros suficientes se agrega otro automaticamente
                    try {
                        float number = Float.parseFloat(ops.get(j));
                        numbers.Push(number);
                    } catch (Exception r) {// Esta se activa por si ya no quedan numeros y tira el codigo de error
                        return "No se puede operar, hay un error de signos";
                    }
                }
            }
        }

        String F;

        
        if(!continuacion == true){
            F = "true";
        }else {
            F = "false";
        }
        return F;
    }
}