package fc.java.course2.part1;

public class StringSplit {
    public static void main(String[] args) {
        String str1 = "Hello,World,dear";

        // ',' 를 구분자로 String 을 나눈다
        String[] strArray_c = str1.split(",");
        /*for (int i=0; i < str.length(); i++){
            System.out.println(strArray[i]);
        }*/

        for(String s : strArray_c){
            System.out.println(s);
        }

        String str2 = "Hello World  dear";

        // 공백을 기준으로 String 을 나눈다
        String[] strArray_s = str2.split("\\s+");
        for(String s : strArray_s){
            System.out.println(s);
        }

    }
}
