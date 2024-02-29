package fc.java.poly;

public abstract class RemoCon {
    // chUp, chDown, volUp, volDown
    public abstract void chUp();
    public abstract void chDown();
    public abstract void volUp();
    public abstract void volDown();

    // 추상클래스 : 기능이 비슷한 대상끼리 묶어줘야지 구현 메서드가 있어도 문제가 되지 않는다.
    public void internet(){
        System.out.println("인터넷이 연결된다.");
    }

}
