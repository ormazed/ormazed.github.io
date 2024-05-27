package fc.java.poly;

public abstract  class Animal {
    // 추상메서드
    public abstract  void eat();
    // 구현메서드
    public void move(){
        System.out.println("무리를 지어서 이동한다.");
    }
}
