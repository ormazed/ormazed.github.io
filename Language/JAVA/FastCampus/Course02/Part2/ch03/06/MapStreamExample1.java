package fc.java.course2.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MapStreamExample1 {
    // 정수 리스트에서 각 원소를 제곱한 값을 출력
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> squaredNumbers = numbers.stream()
                .map(n->n*n)
                .collect(Collectors.toList());
        System.out.println("제곱한 값의 리스트 : " + squaredNumbers);
    }
}
