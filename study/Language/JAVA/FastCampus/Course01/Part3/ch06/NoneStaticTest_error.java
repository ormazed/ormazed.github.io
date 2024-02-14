package fc.java.part3;

// 매개변수로 2개의 정수를 입력받아서 총합을 구하여 리턴하는 메서드를 정의
public class NoneStaticTest_error {
    public static void main(String[] args){
        int a=10; int b=20;        
        // int sum=hap(a,b);
        int sum= NoneStaticTest.hap(a,b);
        System.out.println(sum);
    }
  // hap() 이 static zone 에 적재되지 못하고 있는 상태이기 때문에(static 키워드 x) 에러가 발생한다.
    public int hap(int a, int b){
        int v=a+b;
        return v;
    }
}
