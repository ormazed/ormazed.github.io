package fc.java.poly;

public class TV implements RemoCon{
    @Override
    public void chUp() {
        System.out.println("TV 동작 : chUp");
    }

    @Override
    public void chDown() {
        System.out.println("TV 동작 : chDown");
    }

    @Override
    public void volUp() {
        System.out.println("TV 동작 : volUp");
    }

    @Override
    public void volDown() {
        System.out.println("TV 동작 : volDown");
    }

    @Override
    public void internet() {
        System.out.println("인터넷 TV 입니다.");
    }
    // chUp, chDown, volUp, volDown
}
