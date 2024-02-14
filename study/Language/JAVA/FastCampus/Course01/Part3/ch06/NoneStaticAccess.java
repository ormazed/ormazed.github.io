package fc.java.part3;
import fc.java.model.MyUtil_none;

public class NoneStaticAccess {
// hap 이 static 멤버가 아닌 경우
// 객체 생성을 하지 않고 int sum = MyUtil.hap(a, b); => java: non-static method hap(int,int) cannot be referenced from a static context
    public static void main(String[] args) {
        int a=10; int b=20;
        MyUtil_none mu = new MyUtil_none();
        int sum = mu.hap(a,b);
        System.out.println("sum = " + sum );
    }
}

