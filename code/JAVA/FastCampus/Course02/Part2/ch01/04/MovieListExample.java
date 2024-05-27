package fc.java.course2.part2;

import fc.java.model2.Movie;

import java.util.ArrayList;

public class MovieListExample {
    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<Movie>(); // Movie[] 가 생성된다.
        //Movie movie = new Movie("괴물","봉준호","2006","한국영화");
        list.add(new Movie("괴물","봉준호","2006","한국영화"));
        list.add(new Movie("기생충","봉준호","2019","한국영화"));
        list.add(new Movie("완벽한 타인","이재규","2018","한국영화"));

        for (Movie m : list){
            System.out.println(m);
        }
        System.out.println("+-------------+---------+------+---+");
        System.out.println("+영화제목      |감독      |개봉년도|국가|");
        System.out.println("+-------------+---------+------+---+");
        for (Movie m : list){
            System.out.printf("|%-11s|%-8s|%-4s|%-4s|\n", m.getTitle(),m.getDirector(),m.getYear(),m.getCountry());
        }
        System.out.println("+-------------+---------+------+---+");

        // 순차검색 -> 이진검색(*)
        String searchTitle="기생충";
        boolean rst = false;
        for(Movie m :list){
            rst = m.getTitle().equals(searchTitle);
            if(rst==true){
                System.out.println(m);
                break;
            }
        }


    }
}

/* comment
* (1) list.add(new Movie("괴물","봉준호","2006","한국영화"));
* (2) list.add("괴물","봉준호","2006","한국영화");의 차이
* 첫 번째 방법은 Movie 클래스의 새 인스턴스를 생성하여 ArrayList에 추가하는 올바른 방법입니다.
* 두 번째 방법은 올바른 방식이 아니므로 오류가 발생합니다.
*
list.add(new Movie("괴물","봉준호","2006","한국영화"));와 list.add("괴물","봉준호","2006","한국영화");의 차이는 다음과 같습니다:

인수 전달 방식:
(1) new Movie("괴물","봉준호","2006","한국영화")를 통해 Movie 클래스의 새 인스턴스를 생성하고 그 인스턴스를 add() 메서드에 전달합니다.
(2) "괴물","봉준호","2006","한국영화"와 같이 여러 개의 인수를 전달하여 add() 메서드에 직접 전달합니다.

* 데이터 형식:
(1) Movie 클래스의 인스턴스를 ArrayList에 추가합니다.
(2) String 값을 ArrayList에 추가하려고 시도합니다.
 *
 */
