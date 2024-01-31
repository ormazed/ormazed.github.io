package fc.java.part3;

// Object = 상태정보 + 행위정보
public class Person {
    public String name;
    public int age;
    public String phone;

    public void play(){
        System.out.println("운동을 한다.");
    }
    public void eat(){
        System.out.println("음식을 먹는다.");
    }
    public void walk(){
        System.out.println("걷는다.");
    }
}
