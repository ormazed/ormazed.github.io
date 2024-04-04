package fc.java.course2.part2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamExample {
    public static void main(String[] args) {
        // 1. numbers 리스트를 스트림으로 변환한다.
        List<Integer> numbers = Arrays.asList(1,23,3,4,5,6,7,8,9);

        // 자바에서 제공하는 함수형 인터페이스를 사용한 짝수 여부 판별
        Predicate<Integer> isEven = n -> n%2 ==0;
        int sumOfStream = numbers.stream()
                .filter(isEven) // 2. filter() 메서드를 사용해 짝수 필터(Predicate 사용)
                .sorted()  // 3. sorted() 함수로 정렬
                .map(n-> n*n) // 4. 각 숫자를 제곱(주어진 함수를 스트림의 모든 원소에 적용한 결과로 새로운 스트림을 생성)
                .reduce(0, Integer::sum); // 5. 합계를 계산(스트림의 요소를 결합하여 하나의 결과값을 생성하는데 사용)
        System.out.println("짝수의 제곱의 합 = " + sumOfStream);

    }
}
