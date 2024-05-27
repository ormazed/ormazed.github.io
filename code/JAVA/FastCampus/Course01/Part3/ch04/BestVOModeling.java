package fc.java.part3;

import fc.java.model.MovieVO;

public class BestVOModeling {
    public static void main(String[] args) {
        // Q. 잘 설계된 영화 객체를 설계하고 데이터를 저장한 후 출력
        MovieVO vo = new MovieVO("아바타", "2022-12-14", "제이크설리", "액션", 192.0f, 12);
        System.out.println(vo.toString()); // 전체 값을 확인하기 위해서는 toString() 사용
        System.out.println(vo.getLevel()); // 특정 값을 확인하기 위해서는 getter 사용
    }
}
