

public class Function {
    String name;
    String parameter;
    String code;
    String codeP;
    int pValue;

    public Function(String nombre, String parametro, String codigo){
        name = nombre;
        parameter = parametro;
        codeP = codigo;
    }

    public void setpValue(int value){
        // Buscar el parametro y reemplazarlo por el valor ingresado por el usuario
        String[] cP = codeP.split("");
        for (int i = 0; i < cP.length; i++) {
            if(cP[i].equals(parameter)){
                cP[i] = String.valueOf(value);
            }
            code += cP[i];
        }
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


    public void show() {
        // TODO Auto-generated method stub
        System.out.println(name);
        System.out.println(parameter);
        System.out.println(codeP);
    }
}
