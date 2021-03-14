import java.util.HashMap;

public class Variable {
    private HashMap<String, String> Variables = new HashMap<>();

    public void DefinirVariable (String llave, String valor){
        Variables.put(llave,valor);
    }

    public boolean ExisteVariable (String llave){
        return Variables.containsKey(llave);
    }

    public String Valor(String llave){
        return Variables.get(llave);
    }
}
