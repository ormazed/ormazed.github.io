package fc.java.part4;

import fc.java.model.Animal;
import fc.java.model.Cat;
import fc.java.model.Dog;

public class OverrideTest {
    public static void main(String[] args) {
        // Upcasting : Animal 이 가지고 있는 정보를 상속받아 Dog() 와 Cat() 에 적합한 내용으로 재정의가 가능해진다.
        // 동적바인딩 : 하위 클래스에서 상위클래스가 가진 정보를 재정의하였는지 확인한 후 그에 맞는 정보를 반환하는 것 : 컴파일 시점이 아닌 러닝시점에 인지.
        Animal ani = new Dog();
        ani.eat(); // Animal -- (동적바인딩) --> Dog
        ani = new Cat();
        ani.eat(); // Animal -- (동적바인딩) --> Cat
    }
}
