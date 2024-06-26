package fc.java.course2.part2;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> studentScore = new HashMap<>();
        studentScore.put("park", 90);
        studentScore.put("kim", 70);
        studentScore.put("choi", 63);
        studentScore.put("nam", 24);

        // 데이터 조회
        System.out.println("Park's score : " + studentScore.get("park"));
        System.out.println("Choi's score : " + studentScore.get("choi"));

        // 데이터 수정
        System.out.println("Nam's score : " + studentScore.get("nam"));
        studentScore.put("nam", 88);
        System.out.println("Adgusted Nam's score : " + studentScore.get("nam"));

        // 데이터 삭제
        studentScore.remove("nam");
        System.out.println("Checking Nam's data : " + studentScore.get("nam")); // nam 의  값이 제거되어 null 반환.

        // 전체 데이터 출력
        for(Map.Entry<String, Integer> entry : studentScore.entrySet()){
            System.out.println(entry.getKey() + "'s scoure : " + entry.getValue());
        }
        /*이 메서드는 Map에 포함된 키-값 쌍(엔트리)들을 표현하는 Set을 반환합니다. 
        각 엔트리는 Map.Entry 인터페이스의 인스턴스입니다.*/
    }
}
