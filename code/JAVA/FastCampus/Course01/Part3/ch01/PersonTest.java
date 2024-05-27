package fc.java.part3;

public class PersonTest {
    public static void main(String[] args) {
        // Q. 한 사람의 데이터를 저장할 변수를 선언
        // 모델링 된 Person 클래스를 이용하여 객체를 메모리에 생성
        // 인스턴스 생성과정
        Person p = new Person();
        // Q. 사람의 이름,나이,전화번호를 저장할 객체를 생성
        p.name = "홍길동";
        p.age = 27;
        p.phone = "123-4567-8901";
        System.out.println(p.name + "\t" + p.age +"\t" + p.phone);

        p.play();
        p.eat();
        p.walk();

        Person p1 = new Person();
        // Q. 사람의 이름,나이,전화번호를 저장할 객체를 생성
        p1.name = "고길동";
        p1.age = 47;
        p1.phone = "023-4326-8101";
        System.out.println(p1.name + "\t" + p1.age +"\t" + p1.phone);

        p1.play();
        p1.eat();
        p1.walk();
    }
}
