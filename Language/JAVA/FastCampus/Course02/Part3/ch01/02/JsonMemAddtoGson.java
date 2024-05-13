package fc.java.course2.part3;

import com.google.gson.Gson;
import fc.java.model3.Address;
import fc.java.model3.Member;
import fc.java.model3.Person;

public class JsonMemAddtoGson {
    public static void main(String[] args) {

        String json = "{\"name\":\"홍길동\",\"age\":43,\"email\":\"test@djla.com\",\"address\":{\"city\":\"서울\",\"country\":\"대한민국\"}}";
        Gson gson = new Gson();
        Person ps = gson.fromJson(json, Person.class);
        System.out.println("ps = " +  ps);

    }
}
