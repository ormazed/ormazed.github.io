package fc.java.part4;

import fc.java.model.Animal;
import fc.java.model.Cat;
import fc.java.model.Dog;

public class PolyArray {
    public static void main(String[] args) {
        Dog d = new Dog();
        Cat c = new Cat();

        // Animal[] ani = { new Cat(), new Dog()}
        Animal[] ani = new Animal[2];
        ani[0] = c; // new Cat()
        ani[1] = d; // new Dog()
        display(ani);
    }

    public static void display(Animal[] ani){
        for(int i = 0 ; i < ani.length ; i ++){
            ani[i].eat();
            if( ani[i] instanceof Cat){
                ((Cat) ani[i]).night();
            }
        }
    }
}
