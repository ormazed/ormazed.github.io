package fc.java.model;

public class Dog extends Animal{
    public Dog(){
        super(); // new Animal
    }

    public void eat(){ // Animal 에 eat() 이 존재하지만 Dog 클래스에 맞게 Override
        System.out.println("강아지처럼 먹다.");
    }

}
