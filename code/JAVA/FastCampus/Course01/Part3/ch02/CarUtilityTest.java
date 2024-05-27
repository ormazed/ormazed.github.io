package fc.java.part3;
import fc.java.model.CarDTO;
import fc.java.model.CarUtility;

public class CarUtilityTest {
    public static void main(String[] args) {
        // Q. 자동차 정보를 출력하는 동작을 가지는 Utility 클래스를 설계
        int carSn = 1110;
        String carName = "BMW828i";
        int carPrice=90000;
        String carOwner = "홍길동";
        int carYear = 2015;
        String carType = "G";

        // 개별 정보 6가지(carSn/carName/carPrice/carOwner/carYear/carType) 가 모여서 car 라는 단일 객체를 표현한다.
        CarDTO car = new CarDTO();
        car.carPrice=carPrice;
        car.carSn=carSn;
        car.carOwner=carOwner;
        car.carYear=carYear;
        car.carType=carType;
        car.carName=carName;

        CarUtility carUtil = new CarUtility();
        carUtil.carPrint(car);


    }
    // 매개변수로 자동차의 정보를 입력받아서 출력하는 메서드를 정의

}
