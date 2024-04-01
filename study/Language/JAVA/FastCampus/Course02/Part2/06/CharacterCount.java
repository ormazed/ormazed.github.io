package fc.java.course2.part2;

import java.util.HashMap;
import java.util.Map;

public class CharacterCount {
    public static void main(String[] args) {
    // 주어진 문자열에서 각 문자가 몇 번 출력되는지를 나타냄.
    String str = "plz,stop to say hello world";
    HashMap<Character, Integer> check = new HashMap<Character, Integer>();
    char[] strToChar = str.toCharArray();
    for(char c:strToChar){
        if(check.containsKey(c)){
            check.put(c,check.get(c)+1);
        }else{
            check.put(c,1);
        }
    }
        System.out.println("Character Counts : ");
        for(char c: check.keySet()){
            System.out.println(c+": "  + check.get(c));
        }
    }
}
