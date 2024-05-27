package fc.java.model;

public class Cat extends Animal{
    public Cat(){
        super(); // new Animal
    }
    public void night(){
        System.out.println("눈에서 빛이난다.");
    }

    // 재정의
    public void eat(){ // Animal 에 eat() 이 존재하지만 Cat 클래스에 맞게 Override
        System.out.println("고양이처럼 먹다.");
    }
}
