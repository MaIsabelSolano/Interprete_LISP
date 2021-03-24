import java.util.HashMap;

public class Variable {
    //Utilización de un Hash map para gurdar todos los nombres y los valores de la variable
    private HashMap<String, String> Variables = new HashMap<>();

    /**
     * 
     * @param llave Nombre del la variable
     * @param valor 
     */
    public void DefinirVariable (String llave, String valor){
        Variables.put(llave,valor); //Agregar la nueva variable al HashMap
    }

    /**
     * 
     * @param llave Nombre de la variable
     * @return true si existe y false si no
     */
    public boolean ExisteVariable (String llave){
        return Variables.containsKey(llave);
    }

    /**
     * 
     * @param llave nombre de la variable
     * @return el valor
     */
    public String Valor(String llave){
        return Variables.get(llave);
    }
}

