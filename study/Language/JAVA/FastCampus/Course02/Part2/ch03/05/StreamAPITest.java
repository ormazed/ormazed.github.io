package fc.java.course2.part2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamAPITest {
    public static void main(String[] args) {
        int[] numbers={1,23,3,5,4,6};
/*      초기 단계 구조
        int even=0;
        for(int num : numbers){
            if(num%2==0){
                even += num;
            }
        }
        System.out.println("even = " + even);
        */
        //IntStream stream = Arrays.stream(numbers);
        int sumOfEvens = Arrays.stream(numbers)
                            .filter(n->n%2==0) // n->n%2==0 : 람다식
                            .sum();
        System.out.println("even = " + sumOfEvens);

        int[] arrayEvens = Arrays.stream(numbers)
                .filter(n->n%2==0)
                .toArray();
        for(int even : arrayEvens){
            System.out.println("even array = " + even);
        }

    }
}
