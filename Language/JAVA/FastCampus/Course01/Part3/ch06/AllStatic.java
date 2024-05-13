package fc.java.model;

public class AllStatic {
    private AllStatic(){} // 객체생성방식을 제한하기 위해 private 로 접근제어를 시도
    public static int hap(int a, int b){
        return a+b;
    }

    public static int max(int a, int b){
        return a>b ? a:b;
    }

    public static int min(int a, int b) {
        return a > b ? b : a;
    }
}
