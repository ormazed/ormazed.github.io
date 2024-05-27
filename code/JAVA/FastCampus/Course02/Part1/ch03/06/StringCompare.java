package fc.java.course2.part1;

public class StringCompare {
    public static void main(String[] args) {
        // equals()
        String str1 = "Hello";
        String str2 = "World";

        if(str1.equals(str2)){
            System.out.println("str1 == str2");
        }else {
            System.out.println("str1 != str2");
        }
        // compateTo()

        String str3 = "apple";
        String str4 = "apple";
        //String str4 = "Banana";
        int rst = str3.compareTo(str4);
        if(rst == 0){
            System.out.println("str3 == str4");
        }else {
            System.out.println("str3 != str4");
        }
    }
}
