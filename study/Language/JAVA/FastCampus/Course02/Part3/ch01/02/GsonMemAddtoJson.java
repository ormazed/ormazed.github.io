package fc.java.course2.part3;

import com.google.gson.Gson;
import fc.java.model3.Address;
import fc.java.model3.Person;

public class GsonMemAddtoJson {
    public static void main(String[] args) {
        Address address = new Address("서울", "대한민국");
        Person ps = new Person("홍길동",43,"test@djla.com",address);

        Gson gson = new Gson();
        String json = gson.toJson(ps);
        System.out.println("json =" + json);

    }
}
