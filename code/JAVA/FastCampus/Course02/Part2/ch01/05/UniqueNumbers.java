package fc.java.course2.part2;

import java.util.HashSet;
import java.util.Set;

public class UniqueNumbers {
    public static void main(String[] args) {
        int[] nums = {8,1,2,3,4,2,4,5,6,7,1,3};

        Set<Integer> uniqueNums = new HashSet<>();
        for(int num : nums){
            uniqueNums.add(num);
        }
        System.out.print("Unique numbers : ");
        for (int num : uniqueNums){
            System.out.print(num+ ", ");
        }
    }
}
