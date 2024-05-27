package fc.java.part4;

import fc.java.poly.Animal;
import fc.java.poly.Cat;
import fc.java.poly.Dog;

public class isNotOverride {
    public static void main(String[] args) {
        Animal ani;
        // 재정의 x -> 부모가 명령을 내리면 오동작 한다.
        // 다형성을 보장하지 않음 => (다형성을 보장하려고 한다면) : 재정의를 강제로 하도록 만듦   -> 추상클래스와 인터페이스가 등장
        ani= new Dog();
        ani.eat();
        // 재정의 x -> 부모가 명령을 내리면 오동작 한다.
        ani = new Cat();
        ani.eat();
    }
}
