package fc.java.poly;

public class Dog extends Animal{
    // 재정의를 하지 않는 경우 반응(x) --> 오류가 발생하지 않는다.
    // 재정의를 반드시 해야한다 = 구현부가 생성되어야 한다. public abstract class Animal
    public void eat(){
        System.out.println("개가 먹는다");
    }
}
