package fc.java.poly;

public class Radio implements RemoCon {
    @Override
    public void chUp() {
        System.out.println("Radio의 동작 : chUp");
    }

    @Override
    public void chDown() {
        System.out.println("Radio의 동작 : chDown");
    }

    @Override
    public void volUp() {
        System.out.println("Radio의 동작 : volUp");
    }

    @Override
    public void volDown() {
        System.out.println("Radio의 동작 : volDown");
    }

    @Override
    public void internet() {
        System.out.println("Radio 에서는 인터넷 지원이 되지 않습니다.");
    }
}
