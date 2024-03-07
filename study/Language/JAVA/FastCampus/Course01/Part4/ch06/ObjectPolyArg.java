import java.lang.*;

public class ojbectpolyteest{
	public void main(String[] args){
	  A a = new A();
	  display(a);
	  B b = new B();
	  display(b);
	}

	/*public static void dispaly(A a){
	  a.printGo();
	}

	public static void display(B b){
	  b.printGo();
	}*/

	// Object 를 이용한 다형성 인수사용
	public static void dispaly(Object obj){
	 if(obj instanceof A){
		((A))a.printGo();
	  }else {
		((B))b.printGo();
	  }
	}
}