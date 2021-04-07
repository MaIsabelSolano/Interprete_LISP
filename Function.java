import java.util.ArrayList;

import javax.management.StringValueExp;

public class Function {
    private String name;
    private String parameter;
    private String code;
    private String codeP;
    private boolean recursivo;

    // lista para recursividad
    ArrayList<String> valoresRecursivos = new ArrayList<String>();

    public Function(String nombre, String parametro, String codigo){
        name = nombre;
        parameter = parametro;
        codeP = codigo;
        recursivo = false;
    }

    public void verRecursividad(){
        String[] codigo = codeP.split(" ");

        // Revisar el codigo para detectar si es una funcion recursiva
        for (int i = 0; i < codigo.length; i++) {

            String atom = codigo[i];

            if(atom.equalsIgnoreCase(name)){

                // Indicar que es recursiva
                recursivo = true;
            }
        }
    }

    // referencia 
    public String efectuarRecursividad(int parametro){

        //Primero, insertar el parametro
        insertParameter(parametro);

        String[] codigo = code.split(" ");


        // Revisar el codigo para detectar la condicion
        for (int i = 0; i < codigo.length; i++) {

            String atom = codigo[i];

            // Buscar la condicion
            if(atom.equalsIgnoreCase("cond")){

                // En caso de que se encuentre la condicion, se hara una lista con este y se comprobara la condicion
                Predicados niu = new Predicados(false);
                StackVector<String> condicion = new StackVector<String>();

                // Meter los valores a la condicion
                int indice = i;
                String condition = codigo[indice];
                String pred = codigo[indice+1];
                String value1 = codigo[indice+2];
                String value2 = codigo[indice+3];

                condicion.Push(condition);
                condicion.Push(pred);
                condicion.Push(value1);
                condicion.Push(value2);

                // Verificar la condicion
                boolean booleano = (niu.Pred(condicion));

                System.out.println(booleano);

                // si es cierta, en un stack guardara los resultados para aplciar la recursion
                if(booleano){
                    valoresRecursivos.add(codigo[indice+4]);
                } else{ // si no se cumple la condicion, ya hemos cumplido condiciones anteriores

                    // Verificar el tamaño de la lista de stacks para saber cuantos espacios tenemos que avanzar

                    // Vamos a armar la expresion que se hara en la calculadora
                    // Esta expresion tendra el resultado del stack
                    String expresionRecursiva = "";
                    expresionRecursiva += codigo[indice+6];
                    expresionRecursiva += " ";
                    expresionRecursiva += valoresRecursivos.get(0);
                    expresionRecursiva += " ";
                    expresionRecursiva += codigo[indice+5];

                    // se quita el valor ya que a la siguiente interacion posiblemente guardaremos otro
                    valoresRecursivos.remove(0);

                    // llamar a la calculadora y hacer la operacion
                    Arithmetic calculadora = new Arithmetic();
                    String resultado = calculadora.Calculo(expresionRecursiva.toString());

                    // Finalmente se muestra el resultado
                    valoresRecursivos.add(resultado);

                    return resultado;
                }
            } 
        }

        return null;
    }

    public void clearStack(){
        valoresRecursivos.clear();
    }

    public String insertParameter(int parametro){

        // Metodo para insertar el parametro al codigo de la funcion

        // Se genera un String vacio
        code = "";
        String separar[] = codeP.split("");

        for (int i = 0; i < separar.length; i++) {

            // Ciclo para construir el codigo que sera devuelto
            String caracter = separar[i];

            // Si encuentra el valor que es igual al parametro en el codigo
            // reemplaza ese valor por el parametro seleccionado para dicha funcion
            if(parameter.equalsIgnoreCase(caracter)){
                separar[i]=String.valueOf(parametro);
            }

            // Se genera el codigo devuelto en base a lo anterior
            // Este codigo es el que ejecutara el interprete
            code += separar[i];
        }
        return code;
    }

    public String getCode() {
        return code;
    }

    public String getParameter() {
        return parameter;
    }

    public String getName() {
        return name;
    }

    public String getCodeP() {
        return codeP;
    }

    public boolean getRecursivo(){
        return recursivo;
    }

    public void show() {
        // TODO Auto-generated method stub
        System.out.println("nombre: " + name);
        System.out.println("parametro: " + parameter);
        System.out.println("Codigo: " + codeP);
        System.out.println("Recursiva: " + recursivo);
    }
}
