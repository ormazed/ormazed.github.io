package fc.java.part3;

import fc.java.model.AllStatic;

public class AllStaticTest {
    public static void main(String[] args) {
        int a=39; int b=21;
        // 정상적인 사용의 경우
        System.out.println(AllStatic.hap(a,b));
        System.out.println(AllStatic.max(a,b));
        System.out.println(AllStatic.min(a,b));
    }
}


/*
// 객체를 생성하여 사용하고자 할 경우 
// 아래의 방법을 사용하여 호출하는 것이 사용불가한 방법은 아닌데 바람직하지 못하다. 
// 이 방법을 차단하기 위해 AllStatic 의 생성자를 private 로 생성
AllStatic as = new AllStatic();
System.out.println(as.hap(a,b));
System.out.println(as.max(a,b));
System.out.println(as.min(a,b));
*/
