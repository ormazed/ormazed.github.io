package fc.java.part4;

public class EmployeeTest {
    public static void main(String[] args) {
        // 일반사원 한 명의 객체를 생성하고 데이터를 저장 후 출력을 하세요
        RempVO vo = new RempVO("홍길동", 44, "홍보부", "2024-02-17", "010-4657-4564", true );
        System.out.println(vo.toString());
    }
}
