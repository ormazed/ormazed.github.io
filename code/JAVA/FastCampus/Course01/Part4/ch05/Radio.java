package fc.java.poly;

public class Radio extends RemoCon {
    // Radio 이기 때문에 Internet 이 동작해서는 안된다.
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
}
