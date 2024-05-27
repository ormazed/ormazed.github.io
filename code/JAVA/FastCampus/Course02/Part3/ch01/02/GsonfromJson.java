package fc.java.course2.part3;

import com.google.gson.Gson;
import fc.java.model3.Member;

public class GsonfromJson {
    public static void main(String[] args) {
        String json="{\"name\":\"홍길동\",\"age\":41,\"email\":\"bit@emaps.com\"}";
        Gson gson = new Gson();
        Member mvo = gson.fromJson(json, Member.class);
        System.out.println("mvo = " +  mvo);
        // 왜 자꾸 주소값이 나오는 걸까..mvo = fc.java.model3.Member@48503868 => Member 애 toString을 안 만들어서 java 의 toString() 이 동작
    }
}
