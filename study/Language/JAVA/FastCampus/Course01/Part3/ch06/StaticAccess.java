package fc.java.part3;

import fc.java.model.MyUtil_static;

public class StaticAccess {
// hap 이 static 멤버인 경우
    public static void main(String[] args) {
        int a=10; int b=20;
        int sum = MyUtil_static.hap(a, b);
        System.out.println("sum = " + sum );
    }
}

