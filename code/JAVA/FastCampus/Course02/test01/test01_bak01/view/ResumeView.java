package kr.test01.view;

import kr.test01.model.Career;
import kr.test01.model.Education;
import kr.test01.model.PersonInfo;

import java.util.Scanner;

public class ResumeView {
    private Scanner scanner = new Scanner(System.in);

    // 개인정보
    public PersonInfo inputPersonInfo(){
        System.out.println("사진을 입력하세요.");
        System.out.print("사진: ");
        String photo = scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("이메일: ");
        String email = scanner.nextLine();
        System.out.print("주소: ");
        String address = scanner.nextLine();
        System.out.print("전화번호: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("생년월일: ");
        String brithDate = scanner.nextLine();
        scanner.nextLine();
        return new PersonInfo(photo, name, email, address, phoneNumber, brithDate);
    }

    // 학력사항
    public Education inputEducationList(){
        System.out.println("경력사항을 입력하세요.");
        System.out.print("졸업년도: ");
        String graduationYear = scanner.nextLine();
        System.out.print("학교명: ");
        String schoolName = scanner.nextLine();
        System.out.print("전공: ");
        String major = scanner.nextLine();
        System.out.print("졸업여부: ");
        boolean graduationStatus = scanner.nextBoolean();
        scanner.nextLine();
        return new Education(graduationYear, schoolName, major, graduationStatus);
    }

    // 경력사항 입력
    public Career inputCareerList(){
        System.out.println("경력사항을 입력하세요.");
        System.out.print("근무기간: ");
        String workPeriod = scanner.nextLine();
        System.out.print("근무처: ");
        String companyName = scanner.nextLine();
        System.out.print("담당업무: ");
        String jobTitle = scanner.nextLine();
        System.out.print("근속연수: ");
        int employmentYears = scanner.nextInt();
        scanner.nextLine();
        return new Career(workPeriod, companyName, jobTitle, employmentYears);
    }

    // 자기소개서 본문
    public void inputSelfIntroduction(){
        String content = scanner.nextLine();
    }
    // 결과 메세지를 화면에 표현하는 메서드
    public void printMessage(String message){
        System.out.println(message);
    }

}
