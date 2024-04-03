package fc.java.course2.part2;

import fc.java.model2.MathOperation;

public class FunctionInterfaceTest implements MathOperation {
    public static void main(String[] args) {
        MathOperation mo = new FunctionInterfaceTest();
        int result = mo.operation(20,50);
        System.out.println("result = " + result);
    }
    @Override
    public int operation(int x, int y) {
        return x+y;
    }
}
