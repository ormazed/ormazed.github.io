package fc.java.part4;

import fc.java.model.Animal;
import fc.java.model.Cat;
import fc.java.model.Dog;

public class DogCatUpcastingTest {
    public static void main(String[] args) {
        Animal ani = new Dog();
        ani.eat(); // 동물은 먹는다 -> 개가 먹는다

        //Animal ani = new Cat();
        ani = new Cat();
        ani.eat(); // 동물은 먹는다 -> 고양이가 먹는다.
    }
}
