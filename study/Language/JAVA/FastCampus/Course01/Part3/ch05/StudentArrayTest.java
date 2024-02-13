package fc.java.part3;
import fc.java.model.Student;
public class StudentArrayTest {
    public static void main(String[] args) {
        // Q. 객체배열을 이용하여 4명의 학새 ㅇ데이터를 저장하고 출력
        Student[] st = new Student[4];
        st[0] = new Student("간길동", "컴퓨터공학과", 37 , "kang@email.com", 20120310, "010-2315-2312");
        st[1] = new Student("난길동", "전자공학과", 37 , "nang@email.com", 20141210, "010-7685-9123");
        st[2] = new Student("단길동", "유전공학과", 37 , "dnag@email.com", 20130410, "010-2324-2567");
        st[3] = new Student("란길동", "화학공학과", 37 , "rnag@email.com", 20160320, "010-2893-2234");

        for(int i=0; i < st.length; i++){
            System.out.println(st[i].toString());
        }

        for(Student std : st){
            System.out.println(std.toString());
        }
    }
}
