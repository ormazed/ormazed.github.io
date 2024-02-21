package fc.java.poly;

public class Cat extends Animal{
    // 재정의를 하지 않는 경우 반응(x) --> 오류가 발생하지 않는다.
    public void night(){
        System.out.println("눈에서 빛이난다.");
    }

    @Override
    public void eat() {
        System.out.println("고양이가 먹는다.");
    }
}
