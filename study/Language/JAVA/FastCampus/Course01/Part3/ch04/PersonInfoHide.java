package fc.java.part3;

import fc.java.model.PersonVO;

public class PersonInfoHide {
    public static void main(String[] args) {
        // Q. 한 사람의 회원 정보를 저장할 객체를 생성
        PersonVO vo = new PersonVO();
        vo.name="홍길동";
        vo.age=25;
        vo.phone="011-0204-5813";

        System.out.println(vo.name+"\t"+vo.age+"\t"+vo.phone+"\t");
    }
}

/*
package fc.java.model;

public class PersonVO {
    private String name;
    private int age;
    private String phone;
}
*/
