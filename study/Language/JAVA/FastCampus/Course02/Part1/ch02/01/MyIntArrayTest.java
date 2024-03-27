package fc.java.course2.part1;

public class MyIntArrayTest {
    public static void main(String[] args) {
        // 정수 3개를 배열에 저장하고 출력하세요
        IntArray list = new IntArray(); // DEFAULT_CAPACITY 에 의해 5크기의 정수형 배열이 생성됨.
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        // list.add(6); // Index 5 out of bounds for length 5

        for(int i=0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
