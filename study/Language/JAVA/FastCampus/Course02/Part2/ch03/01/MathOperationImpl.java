package fc.java.model2;
// 인터페이스를 구현한 구현체를 외부에 만들어 놓고 사용하는 방식
public class MathOperationImpl implements MathOperation{ // 일반적인 구현 인터페이스

    @Override
    public int operation(int x, int y) {
        return x+y;
    }
}
