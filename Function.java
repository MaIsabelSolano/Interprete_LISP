import javax.management.StringValueExp;

public class Function {
    private String name;
    private String parameter;
    private String code;
    private String codeP;
    int pValue;

    public Function(String nombre, String parametro, String codigo){
        name = nombre;
        parameter = parametro;
        codeP = codigo;
    }

    public String insertParameter(int parametro){
        code = "";
        String separar[] = codeP.split("");
        for (int i = 0; i < separar.length; i++) {
            String caracter = separar[i];
            if(parameter.equalsIgnoreCase(caracter)){
                separar[i]=String.valueOf(parametro);
            }

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


    public void show() {
        // TODO Auto-generated method stub
        System.out.println("nombre: " + name);
        System.out.println("parametro: " + parameter);
        System.out.println("Codigo: " + codeP);
    }
}
