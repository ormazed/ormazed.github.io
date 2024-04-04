package fc.java.course2.part2;

import fc.java.model2.MathOperation;

public class LambdaExample {
    public static void main(String[] args) {
/*        MathOperation add = new MathOperation() {
            @Override
            public int operation(int x, int y) {
                return 0;
            }
        };*/

        //MathOperation add = (int x, int y) -> {return x+y; };
        MathOperation add = (x, y) -> x+y;
        int result = add.operation(10,20);
        System.out.println("result = " + result);
        // 확장성이 좋다.

        MathOperation mul = (x, y) -> x*y;
        int rst = mul.operation(20,40);
        System.out.println("result = " + rst);
    }

}
