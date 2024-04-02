package fc.java.course2.part2;

public class ObjectArr<T> {
    private T[] array;
    private int size;
    public ObjectArr(int size){
        array = (T[]) new Object[size];// 어떤 Type 일지 모르기 때문에 Object 로 생성 후 Downcasting 하는  방법으로 작성
    }

    public void set(int index, T value){
        array[index] = value;
        size++;
    }

    public T get(int index){
        return array[index];
    }

    public int size(){
        //return array.length; --> 이렇게 입력하면 GenericTest 에서 for 돌리니까 결과에 null 도 보이네..
        return size;
    }
}
