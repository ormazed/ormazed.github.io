package fc.java.part3;

import fc.java.model.PersonVO;

public class ToStringPrint {
    public static void main(String[] args) {
        // Q. 생성자 메서드를 통해 PersonVO객체에 원하는 이름, 나이, 전화번호로 저장하고 toString() 메서드로 출력
        PersonVO vo2 = new PersonVO("정약용", 28, "010-6754-8412");
        System.out.println(vo2.getName() +"\t"+vo2.getAge()+"\t"+ vo2.getPhone());
        System.out.println(vo2.toString());
        System.out.println(vo2);
    }
}

/*
정약용	28	010-6754-8412
정약용	28	010-6754-8412
정약용	28	010-6754-8412
*/
