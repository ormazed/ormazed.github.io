package fc.java.model2;
// BB 는 노출하지 않고 CC 로 BB 의 기능을 사용할 수 있다.
public class BB implements CC {

    @Override
    public void x() {
        System.out.println("BB x() working");
    }

    @Override
    public void y() {
        System.out.println("BB y() working");
    }

    @Override
    public void z() {
        System.out.println("BB z() working");
    }
}
