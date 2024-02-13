package fc.java.part3;

import fc.java.model.PersonVO;

public class ConstructorOverloading {
    public static void main(String[] args) {
        PersonVO vo = new PersonVO();
        PersonVO vo1 = new PersonVO("이순신", 23, "010-6214-1248");
        PersonVO vo2 = new PersonVO("강감찬", 28, "010-6754-1586");
        System.out.println(vo.getName() +"\t"+vo.getAge()+"\t"+ vo.getPhone());
        System.out.println(vo1.getName() +"\t"+vo1.getAge()+"\t"+ vo1.getPhone());
        System.out.println(vo2.getName() +"\t"+vo2.getAge()+"\t"+ vo2.getPhone());
    }
}
