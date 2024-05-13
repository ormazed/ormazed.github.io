package fc.java.course2.part1;

import java.util.ArrayList;

public class CollectionBasic {
    public static void main(String[] args) {
        // ArrayList 에 10,20,30,40,50 5개의 정수를 저장하고 출력하시오
        // ArrayList -> Object[] : int 형 자료형 입력이 불가하다(Integer 로만 입력가능); Wrapper class 사용
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10); // = list.add(new Integer(10)); = new Integer(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        for(int data:list){
            System.out.println(data);
        }
    }
}
