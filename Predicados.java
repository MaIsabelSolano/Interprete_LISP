import java.util.ArrayList;

public class Predicados {

    boolean err;

    public Predicados(boolean err) {
        this.err = err;
    }

    public boolean isErr() {
        return err;
    }

    public boolean Pred(String op){
        err = false;
        boolean res = false;

        ArrayList<String> ops = new ArrayList<String>();
        String[] separado = op.split(" ");
        for (int i = 0; i < separado.length; i++) {
            ops.add(separado[i]);
        }

        if(ops.get(0).equalsIgnoreCase("COND") && separado.length == 4){

            if(ops.get(1).equalsIgnoreCase("<")){
                if(ops.get(2).matches("[+-]?\\d*(\\.\\d+)?") && ops.get(3).matches("[+-]?\\d*(\\.\\d+)?")){
                    float number = Float.parseFloat(ops.get(2));
                    float number2 = Float.parseFloat(ops.get(3));
                    System.out.println(number + " < " + number2);
                    res = number < number2;
                    return res;
                } else {
                    System.out.println("Error");
                    err = true;

                    return res;

                }
            }else if (ops.get(1).equalsIgnoreCase(">")){
                if(ops.get(2).matches("[+-]?\\d*(\\.\\d+)?") && ops.get(3).matches("[+-]?\\d*(\\.\\d+)?")){
                    float number = Float.parseFloat(ops.get(2));
                    float number2 = Float.parseFloat(ops.get(3));
                    System.out.println(number + " > " + number2);
                    res = number > number2;
                    return res;
                } else {
                    System.out.println("Error");
                    err = true;

                    return res;
                }
            }else if(ops.get(1).equalsIgnoreCase("=")){
                if(ops.get(2).matches("[+-]?\\d*(\\.\\d+)?") && ops.get(3).matches("[+-]?\\d*(\\.\\d+)?")){
                    float number = Float.parseFloat(ops.get(2));
                    float number2 = Float.parseFloat(ops.get(3));
                    System.out.println(number + " = " + number2);
                    res = number == number2;
                    return res;
                } else {
                    System.out.println("Error");
                    err = true;

                    return res;

                }
            } else {
                System.out.println("Error");
                err = true;
                return res;
            }




        }else if (ops.get(0).equalsIgnoreCase("COND") && separado.length == 3){

            if(ops.get(1).equalsIgnoreCase("ATOM")){
                res = ops.get(2).matches("[+-]?\\d*(\\.\\d+)?");
                System.out.println(ops.get(2) + " es un numero");
                return res;
            } else {
                System.out.println("Error");
                err = true;
                return res;
            }
        }else{
            System.out.println("Error");
            err = true;
            return res;
        }
    }
}
