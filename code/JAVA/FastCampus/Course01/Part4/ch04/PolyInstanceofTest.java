package fc.java.part4;

import fc.java.model.Animal;
import fc.java.model.Cat;
import fc.java.model.Dog;

public class PolyInstanceofTest {
    public static void main(String[] args) {
        Dog d = new Dog();
        display(d);
        Cat c = new Cat();
        display(c);
    }
    private static void display(Animal ani){ // 다형성인수 : c.eat() 과 d.eat() 을 ani.eat() 이 커버
        ani.eat();
        if(ani instanceof Cat){
            ((Cat)ani).night();
        }
    }
}
