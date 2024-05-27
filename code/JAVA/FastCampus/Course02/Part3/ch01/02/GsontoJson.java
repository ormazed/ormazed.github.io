package fc.java.course2.part3;

import com.google.gson.Gson;
import fc.java.model3.Member;

public class GsontoJson {
    public static void main(String[] args) {
        Member mvo = new Member("홍길동",41,"bit@emaps.com");
        // 객체생성
        Gson gson = new Gson();
        String json = gson.toJson(mvo);
        System.out.println("json = " + json); // json = {"name":"홍길동","age":41,"email":"bit@emaps.com"}

    }
}
