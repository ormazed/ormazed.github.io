package fc.java.part4;

import fc.java.poly.Radio;
import fc.java.poly.RemoCon;
import fc.java.poly.TV;

public class InterfaceRemoCon {
    // Radio 와 TV 가 공통동작을 가진다 단. TV 에만 인터넷기능이 있다.
    public static void main(String[] args) {
        // 리모컨으로 Radio 와 TV 를 동작
        // 다형성이 완전히 보장된다.
        // 부모가 인터페이스이면 자식의 내부 동작방식을 몰라도 동작을 시킬 수 있다.
        RemoCon remo = new TV();
        remo.chDown();
        remo.chUp();
        remo.volDown();
        remo.volUp();
        remo.internet();

        remo = new Radio();
        remo.volUp();
        remo.chUp();
        remo.volDown();
        remo.chDown();
        remo.internet();

    }
}
