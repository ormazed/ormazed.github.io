package fc.java.course2.part1;

public class IntegerStringTest {
    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "123";
        System.out.println(str1+  str1);

        int num = Integer.parseInt(str1) + Integer.parseInt(str2);
        System.out.println(num);

        int su1 = 123;
        int su2 = 123;
        System.out.println(su1+su2);
        String str = String.valueOf(su1)+String.valueOf(su2);
        String s = (su1+""+su2+"");
        System.out.println(str);
        System.out.println(s);
    }

}
