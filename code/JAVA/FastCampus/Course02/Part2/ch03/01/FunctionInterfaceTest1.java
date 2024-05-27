package fc.java.course2.part2;

import fc.java.model2.MathOperationImpl;
import fc.java.model2.MathOperation;

public class FunctionInterfaceTest1{
    public static void main(String[] args) {
        MathOperation mo = new MathOperationImpl();
        int result = mo.operation(20, 54);
        System.out.println("result = " + result);
    }
}
