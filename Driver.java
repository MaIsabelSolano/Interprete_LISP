public class Driver {
    public static void main(String[] args) {
        interpreterLisp iL = new interpreterLisp();

        iL.readLine("( defun fibonacci ( x ) ( + 1 x ) )");

        System.out.println(iL.getStackSigns());

        iL.executeLine();

        System.out.println(iL.getStackSigns());
    }
}
