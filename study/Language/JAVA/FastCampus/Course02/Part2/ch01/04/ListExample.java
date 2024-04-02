package fc.java.course2.part2;

import java.util.ArrayList;

public class ListExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add(new String("apple")); // list.add("apple");
        list.add(new String("banana"));
        list.add(new String("cherry"));
        list.add(new String("banana"));

        System.out.println("list 입력 순서 확인 : " + list.get(3)); // banana
        for(String str : list){
            System.out.println(str);
        }

        // 데이터 삭제
        list.remove(3);
        System.out.println("list.remove 동작 후");
        for(String str : list){
            System.out.println(str);
        }

        // 데이터 변경
        list.set(1, "orange");
        for(String str : list){
            System.out.println(str);
        }
    }
}
