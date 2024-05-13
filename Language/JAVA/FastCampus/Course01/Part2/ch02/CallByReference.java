public class CallByReference {
    public static void main(String[] args) {
        float a = 10.2f;
        float b = 20.9f;
        sum(a,b);
        System.out.println("sum 메서드 종료");

        int[] num = {4,67,23,4,7};
        add(num);
        System.out.println("add 메서드 종료");
    }

    // Q. 매개변수로 2개의 실수를 받아서 총합을 구하는 출력 메서드 작성. --> CallByValue
    public static void sum(float n1, float n2){
        float sum = n1 + n2;
        //return result;
        System.out.println("두 실수의 합 : " +sum);
    }


    // Q. 매개변수로 정수형 배열을 받아서 배열의 총합을 구하여 리턴하는 메서드를 정의. --> CallByReference
    public static void add(int[] num){
        int result = 0;
        for(int i=0; i < num.length; i++){
            result += num[i];
        }
        System.out.println("int[] num 의 총합 : " + result);
    }
}
