package fc.java.course2.part1;

import fc.java.model2.Book;

import java.util.ArrayList;
import java.util.List;

public class ArrayListBestTest {
    public static void main(String[] args) {
        // Book 3권을 배열에 저장하고 출력하세요
/*       // vs ArrayListTest.java 
        ArrayList list = new ArrayList(); // ArrayList 의 기본값은 10
        list.add(new Book("자바", 15000, "한빛", "홍길동"));
        list.add(new Book("파이썬", 25000, "길벗", "이순신"));
        list.add(new Book("Go", 35000, "민음사", "강감찬"));
*/
      // List<클래스지정> list = new ArrayList<클래스지정>(); 하면 ArrayList.java 일때와 달리 downcasting 을 하지 않아도 된다.
        List<Book> list = new ArrayList<Book>(); // Book class 만 사용한다고 한정지었기 때문에 이후에는 downcasting 을 명시할 필요가 없어진다.
        list.add(new Book("자바", 15000, "한빛", "홍길동"));
        list.add(new Book("파이썬", 25000, "길벗", "이순신"));
        list.add(new Book("Go", 35000, "민음사", "강감찬"));

        Object vo_ob = list.get(0);
        System.out.println(vo_ob);

        Book vo_bo = list.get(1);
        System.out.println(vo_bo);

        for(int i=0; i < list.size(); i++) {
            System.out.println("toString 테스트" + list.get(i)); // Object --> Book(JVM 에서 자동으로 Book 의 toString() 을 사용)
        }

    }
}
