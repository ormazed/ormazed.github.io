// 대문자로된 APPLE 를 소문자 apple 로 출력하세요.
public class AppleExam {
    public static void main(String[] args) {
        char[] c = {'A','P','P','L','E'};

        char[] tmp = {'a','p','p','l','e'};

        for( int i = 0 ; i < c.length ; i++){
            c[i] = tmp[i];
            System.out.println("c = " + c[i]);
        }

    }
}
