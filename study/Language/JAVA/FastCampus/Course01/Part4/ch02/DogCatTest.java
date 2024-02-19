package fc.java.part4;

import fc.java.model.Cat;
import fc.java.model.Dog;

public class DogCatTest {
    public static void main(String[] args) {
        // Dog 객체를 생성하고 eat() 동작을 구현해보자.
        Dog dog = new Dog();
        dog.eat();

        // Cat 객체를 생성하고 night() 동작을 구현해보자.
        Cat cat = new Cat();
        cat.eat();
        cat.night();
    }
}
