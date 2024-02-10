package fc.java.part3;

public class PackageNameTest {
    public static void main(String[] args) {
        // Q. 지금까지 자바에서 제공해주어서 사용해본 클래스
        java.lang.String str="홍길동";
        java.util.Scanner scan = new java.util.Scanner(System.in);
        java.lang.System.out.println("Hello World");

        // Q. 직접 만들어서 사용해본 클래스
        fc.java.model.CarDAO dao = new fc.java.model.CarDAO();
    }
}
