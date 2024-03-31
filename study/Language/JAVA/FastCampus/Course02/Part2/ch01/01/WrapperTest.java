package fc.java.course2.part1;

public class WrapperTest {
    public static void main(String[] args) {
        // 정수형 변수에 10을 저장하세요.
        int a=10; // 기본 자료형
        // Integer aa = new Integer(10); // 사용자정의 자료형
        Integer aa =10; // Auto-boxing
        System.out.println(aa);
        System.out.println(aa.getClass());
        System.out.println(aa.intValue()); // Unboxing

        Integer bb = new Integer(20); // Auto-boxing
        // Integer bb = 20;
        int b = bb; // Unboxing

        float f=10.5f;
        Float ff = new Float(10.5);

        System.out.println(ff); // ff type : class java.lang.Float
        System.out.println(ff.getClass());
        System.out.println(ff.floatValue());
    }
}
