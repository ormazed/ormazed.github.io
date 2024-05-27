import java.util.*;
// 대문자로된 APPLE 를 소문자 apple 로 출력하세요.
public class AppleExam {
    public static void main(String[] args) {
        char[] c = {'A','P','P','L','E'};
        for( int i = 0 ; i < c.length ; i++){
            System.out.print((char)(c[i]+32));
        }

    }
}
