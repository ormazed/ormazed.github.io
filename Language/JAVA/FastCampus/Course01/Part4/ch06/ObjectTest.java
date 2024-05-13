packagefc.java.part4l
import fc.java.poly.A;

public class ObjectTest {
	public static void main(String[] args){
	  // 방법1 A객체를 Upcasting 으로 생성
	  // A a = new A();
	  // a.display();

	  Object obj = new A(); // upcasting
	  // obj.display(); -> Object클래스 내부에 display() 가 없기때문에 실행x
	  ((A)obj).dispaly(); // downclasting
	}
}