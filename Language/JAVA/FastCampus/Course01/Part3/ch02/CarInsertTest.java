package fc.java.part3;

import fc.java.model.CarDAO;
import fc.java.model.CarDTO;

import java.util.Scanner;

public class CarInsertTest {
    public static void main(String[] args) {
        // Q. 자동차의 정보를 키보드로부터 입력 받아서 다른 메서드로 이동해야 하는 경우
        Scanner scan = new Scanner(System.in);
        System.out.print("자동차 일련번호 :");
        int carSn= scan.nextInt();

        scan.nextLine();

        System.out.print("자동차 이름 :");
        String carName= scan.nextLine();

        System.out.print("자동차 가격 :");
        int carPrice= scan.nextInt();

        scan.nextLine();

        System.out.print("자동차 소유자 :");
        String carOwner= scan.nextLine();

        System.out.print("자동차 연식 :");
        int carYear= scan.nextInt();

        scan.nextLine();

        System.out.print("자동차 타입 :");
        String carType= scan.nextLine();

        //System.out.println(carSn +"\t"+ carName +"\t"+ carPrice +"\t"+ carYear +"\t"+ carOwner +"\t"+ carType);
        //carInfoPrint(carSn, carName, carPrice, carOwner, carYear, carType);

        // 클래스로 CarDTO, CarVO 모델을 설계
        CarDTO car = new CarDTO();
        car.carName =carName;
        car.carSn=carSn;
        car.carType=carType;
        car.carYear=carYear;
        car.carOwner=carOwner;
        car.carPrice=carPrice;

        CarDAO dao = new CarDAO();
        dao.carInsert(car);
        dao.carSelect(car);

    }
}
