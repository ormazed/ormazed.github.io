package fc.java.course2.part2;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple"); // 중복된 Apple 은 알아서 제외되는 듯.
        set.add("apple");

        System.out.println(set.size());
        set.remove("apple");
        for(String element : set){
            System.out.println(element); // Set 은 List 와 달리 순서가 정해져있지 않다.
        }

        // Set 내부에 값이 저장되어 있는지 확인
        boolean contains = set.contains("Cherry");
        System.out.println("Set contains Cherry? " + contains);

        // set 내부의 값을 모두 제거
        set.clear();
        boolean empty = set.isEmpty();
        System.out.println("Set is empty? " + empty);
    }
}
