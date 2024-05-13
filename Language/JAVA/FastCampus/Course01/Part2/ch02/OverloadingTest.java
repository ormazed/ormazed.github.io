public class OverloadingTest {
    public static void main(String[] args) {
        //int num1=4; int num2=5;
        float num1=4.44f; float num2=5.32f;
        sum(num1,num2);
    }
    // Q1. 매개변수로 두개의 정수값을 받아서 총합을 구하여 리턴하는 메서드
    public static void sum(int num1, int num2){
        int result = num1 + num2;
        System.out.println("int sum method 가 동작");
        System.out.println("result : " + result);
    }

    //  Q2. 매개변수로 두개의 실수값을 받아서 총합을 구하여 리턴한느 메서드
    public static void sum(float num1, float num2){
        float result = num1 + num2;
        System.out.println("float sum method 가 동작");
        System.out.println("result : " + result);
    }
}
