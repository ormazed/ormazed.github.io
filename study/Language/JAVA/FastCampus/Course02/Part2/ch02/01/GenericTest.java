package fc.java.course2.part2;
import fc.java.model2.Movie;
public class GenericTest {
    public static void main(String[] args) {
        /*ObjectArr<String> array = new ObjectArr<>(5);
        array.set(0, "hello");
        array.set(1, "hi");
        array.set(2, "nice");
        array.set(3, "good");

        for(int i=0;i<array.size();i++){
            System.out.println(array.get(i)); // 나는 왜 null 값까지 보이는 거지..
        }*/

        ObjectArr<Movie> blist = new ObjectArr<Movie>(5);
        blist.set(0, new Movie("괴물","봉준호","2006","한국영화"));
        blist.set(1, new Movie("기생충","봉준호","2019","한국영화"));
        blist.set(2, new Movie("완벽한 타인","이재규","2018","한국영화"));

        for(int i=0;i<blist.size();i++){
            System.out.println(blist.get(i));
        }
    }
}
