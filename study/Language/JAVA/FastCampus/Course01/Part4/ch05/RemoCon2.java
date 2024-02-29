package fc.java.poly;

public interface RemoCon {
    // chUp, chDown, volUp, volDown
    // interface 로 만들 경우 abstract 선언 생략이 가능하다.
    //public abstract void chUp();
    public  void chUp();
    public  void chDown();
    public  void volUp();
    public  void volDown();
   public  void internet();

    // 추상클래스 : 기능이 비슷한 대상끼리 묶어줘야지 구현 메서드가 있어도 문제가 되지 않는다.
    /* interface 이기 때문에 구현메서드를 가져서는 안된다.
    public void internet(){
        System.out.println("인터넷이 연결된다.");
    }
    */
}
