package fc.java.part4;

import fc.java.model.Animal;
import fc.java.model.Cat;
import fc.java.model.Dog;

public class PolyTest {
    public static void main(String[] args) {
        // Upcasting 으로 객체를 생성
        // 상속관계, 재정의(Override), 동적바인딩
        // 다형성(message polymorphism)
        // 상위클래스가 도일한 메시지로 하위클래스를 서로 다르게 동작시키는 객체지향 원리
        Animal ani = new Animal();
        ani.eat();

        // Upcating
        ani = new Dog();
        ani.eat(); // 실행시점에서 사용될(호출될) 메서드가 결정되는 바인딩(동적바인딩)

        // Downcasting
        Dog d = (Dog) ani;
        d.bite();

        // Upcating
        ani = new Cat();
        ani.eat(); // 실행시점에서 사용될(호출될) 메서드가 결정되는 바이딩(동적바인딩)

        // Downcasting
        Cat c = (Cat) ani;
        c.night();

        // Overloading : 정적 바인딩 = 컴파일 시점에서 사용될 메서드가 결정되는 바인딩
        // -> 프로그램의 실행속도와는 무관.
        // Overrid(재정의) :  동적 바인딩 = 실행시점에서 사용될(호출될)메서드가 결정되는 바인딩
        // -> 프로그램의 실행속도와는 유관.
    }
}
