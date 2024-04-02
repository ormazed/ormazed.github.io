package fc.java.course2.part2;
import fc.java.model2.Movie;

import java.util.*;

public class ArrayListGeneric {
    public static void main(String[] args) {
        //List list = new ArrayList();
        List<Movie> list = new ArrayList();
        // Object[] 로 생성되어 있기 때문에 어떠한 Type 도 입력가능하다. -> 데이터 타입 일관성이 훼손될 수 있다.
        list.add(new Movie("괴물","봉준호","2006","한국영화"));
        // list.add("hello");

        System.out.println(list.get(0)); // Movie{title='괴물', director='봉준호', year='2006', country='한국영화'}
        //System.out.println(list.get(1)); // hello

    }

}
