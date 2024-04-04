package fc.java.course2.part2;

import fc.java.model2.StringOperation;

public class LambdaApply {
    public static void main(String[] args) {
        StringOperation toUpperCase = s -> s.toUpperCase();
        StringOperation toLowerCase = s -> s.toLowerCase();

        String input = "Lambda Expressions";
        System.out.println(processString(input, toUpperCase));
        System.out.println(processString(input, toLowerCase));
    }

    public static String processString(String input, StringOperation operation){
        return operation.apply(input);
    }
}
