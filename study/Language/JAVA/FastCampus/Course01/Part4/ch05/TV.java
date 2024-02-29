package fc.java.poly;

public class TV extends RemoCon{
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
    // chUp, chDown, volUp, volDown
}
