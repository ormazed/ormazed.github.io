package fc.java.course2.part2;

import fc.java.model2.MathOperation;
import fc.java.model2.MathOperationImpl;
public class FunctionInterfaceTest2 {
    // MathOperation 인터페이스를 내부 익명 내부 클래스로 구현
    public static void main(String[] args) {
       // MathOperation mo = new MathOperation(); => 인터페이스는 객체를 만들 수 없기에 에러가 발생.
        MathOperation mo = new MathOperation(){
            @Override
            public int operation(int x, int y) {
                return x+y;
            }
        }; // class 가 존재한다는 것은 구현체가 존재한다는 의미이다.
        int result = mo.operation(501,123);
        System.out.println("result : " + result);
    }

}
