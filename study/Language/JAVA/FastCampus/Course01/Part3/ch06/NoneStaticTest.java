package fc.java.part3;

// None Static 메서드에 접근하는 방법 => 객체를 생성해서 메모리에 로딩
public class NoneStaticTest {
    public static void main(String[] args){
        int a=10; int b=20;
        // NoneStatic 을 위한 객체를 생성하여 Heap Area 에 class 가 적재
        StaticTest st = new StaticTest();
        int sum = st.hap(a,b);
        System.out.println(sum);
    }
    public int hap(int a, int b){
        int v=a+b;
        return v;
    }
}
