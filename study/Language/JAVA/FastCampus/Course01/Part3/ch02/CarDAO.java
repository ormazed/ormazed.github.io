package fc.java.model;

public class CarDAO {
    // CRUD
    // Create = insert() 저장
    public  void carInsert(CarDTO car){
        // DB 연결, insert SQL
        System.out.println("car 정보가 DB 에 저장되었습니다.");
    }

    // DB 연결, SELECT SQL
    public void carSelect(CarDTO car){
        System.out.println("car 정보가 검색되었습니다.");
    }

}


