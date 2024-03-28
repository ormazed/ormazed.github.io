package fc.java.course2.part1;

import fc.java.model2.A;
import fc.java.model2.Book;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        // Book 3권을 배열에 저장하고 출력하세요
        ArrayList list = new ArrayList(); // ArrayList 의 기본값은 10
        // ArrayList list = new ArrayList(1);  ArrayList 는 배열의 크기를 자동으로 늘려주는 기능이 존재한다.
        list.add(new Book("자바", 15000, "한빛", "홍길동"));
        list.add(new Book("파이썬", 25000, "길벗", "이순신"));
        list.add(new Book("Go", 35000, "민음사", "강감찬"));


        Object vo_ob = list.get(0);
        System.out.println(vo_ob);

        Book vo_bo = (Book) list.get(1); // Book <-- (Book)Object
        System.out.println(vo_bo);

        for(int i=0; i < list.size(); i++) {
            Book bo = (Book) list.get(i);
            System.out.println("downcastirng 테스트" + bo);
            System.out.println("toString 테스트" + list.get(i)); // Object --> Book(JVM 에서 자동으로 Book 의 toString() 을 사용)
        }

    }
}
