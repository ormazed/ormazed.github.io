package fc.java.part4;

import fc.java.model.*;

public class PolyMethodTest {
    public static void main(String[] args) {
        Dog d = new Dog();
        display(d);
        Cat c = new Cat();
        display(c);
    }

/*    private static void display(Dog d){ // Overloading - display() 로 메서드명은 동일하지만 type 이 다르다
        d.eat();;
    }
    private static void display(Cat c){ // Overloading - display() 로 메서드명은 동일하지만 type 이 다르다
        c.eat();;
    }*/

    private static void display(Animal ani){ // 다형성인수 : c.eat() 과 d.eat() 을 ani.eat() 이 커버
        ani.eat();
        // Cat 타입으로 받은 경우에만 실행가능
        // ((Cat)ani).night();
    }
}
