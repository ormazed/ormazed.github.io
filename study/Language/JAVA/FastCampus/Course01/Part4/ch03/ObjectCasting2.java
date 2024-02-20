package fc.java.part4;

import fc.java.model.Animal;
import fc.java.model.Cat;
import fc.java.model.Dog;

public class ObjectCasting {
    public static void main(String[] args) {
        // Animal --> Cat, Dog
        Animal ani ; // Animal 이 eat() 이라는 동작을 Cat 과 Dog 에게 전달
        ani = new Cat();
        ani.eat(); // eat() 에 대하여 Cat 이 반응
        ani = new Dog();
        ani.eat(); // eat() 에 대하여 Dog 가 반응

        
        // ani.night(); -> Animal 은 Cat 가지고 있는 night() 를 알지 못한다.
        // Cat 에만 있는 night() 를 사용하기 위함
        Cat c = (Cat) ani;
        c.night();
    }
}
