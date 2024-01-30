
public class MethodMakeTest {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        int rst = add(num1,num2);
    }
    public static int add(int num1, int num2){
        int sum = num1 + num2;
        return sum;
    }
}





// Non-static method 'add(int, int)' cannot be referenced from a static context
// main 메서드가 static 일 때 add 메서드에 static 을 넣지 않으면 발생하는 에러.
/*    public int add(int num1, int num2){
        int sum = num1 + num2;
        return sum;
    }
*/
