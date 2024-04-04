package fc.java.course2.part2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapStreamExample2 {
    // 정수 리스트에서 각 원소를 제곱한 값을 출력
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "cherry","banana","orange");
        List<String> upperCase = fruits.stream()
                .map(fruit-> fruit.toUpperCase())
                .collect(Collectors.toList());
        for(String word : upperCase){
            System.out.println("제곱한 값의 리스트 : " + word);
        }
    }
}
