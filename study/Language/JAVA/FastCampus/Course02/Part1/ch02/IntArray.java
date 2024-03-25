package fc.java.course2.part1;

import java.util.Arrays;

public class IntArray {
    private static final int DEFAULT_CAPACITY=5; // 수정불가(final) => 상수화
    private int size=0;
    private int[] elements;

    public IntArray(){
        elements=new int[DEFAULT_CAPACITY];
    }

    public void add(int element){
        // 크기제크
        if(size==elements.length){
            // 크기를 2배로 늘리는 작업
            ensureCapacity();
        }
        elements[size++] = element;
    }

    private void ensureCapacity() {
        int newCapacity = elements.length*2;
        elements = Arrays.copyOf(elements, newCapacity);

    }

    // 얻는 동작
    public int get(int index){
        // index체크
       if(index<0||index>=size) {
        throw new IndexOutOfBoundsException("범위초과");
       }
       return elements[index];

    }

    // 원소의 개수를 넘겨주는 동작
    public int size(){
        return size;
    }

}
