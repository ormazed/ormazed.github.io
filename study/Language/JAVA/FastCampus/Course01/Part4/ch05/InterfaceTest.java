package fc.java.part4;

import fc.java.poly.Radio;
import fc.java.poly.RemoCon;
import fc.java.poly.TV;

public class InterfaceTest {
    public static void main(String[] args) {
        // 리모컨으로 Radio 와 TV 를 동작
        RemoCon remo = new TV();
        remo.chDown();
        remo.chUp();
        remo.volDown();
        remo.volUp();
        remo.internet(); // internet() 기능은 TV 에서만 동작해야한다.

        remo = new Radio();
        remo.volUp();
        remo.chUp();
        remo.volDown();
        remo.chDown();
        remo.internet(); // internet() 기능은 TV 에서만 동작해야한다.

    }
}
