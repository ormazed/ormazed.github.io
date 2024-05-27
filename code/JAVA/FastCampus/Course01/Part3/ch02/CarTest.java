package fc.java.part3;

import fc.java.model.CarDTO;

import java.util.Scanner;

public class CarTest {
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
        CarDTO carinfo = new CarDTO();
        carinfo.carName =carName;
        carinfo.carSn=carSn;
        carinfo.carType=carType;
        carinfo.carYear=carYear;
        carinfo.carOwner=carOwner;
        carinfo.carPrice=carPrice;
        carInfoPrint(carinfo);
        
    }
    // Q. 매개변수로 자동차의정보를 받아서 출력하는 메서드를 정의하세요

    private static void carInfoPrint(CarDTO carinfo) {
        System.out.println(carinfo.carSn +"\t"+ carinfo.carName +"\t"+ carinfo.carPrice +"\t"+ carinfo.carYear +"\t"+ carinfo.carOwner +"\t"+ carinfo.carType);
    }


}
