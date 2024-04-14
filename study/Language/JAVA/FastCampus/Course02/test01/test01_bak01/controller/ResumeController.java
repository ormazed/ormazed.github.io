package kr.test01.controller;

import kr.test01.model.Career;
import kr.test01.model.Education;
import kr.test01.model.PersonInfo;
import kr.test01.view.ResumeView;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResumeController {
    public static void main(String[] args) {

        List<Career> careers = new ArrayList<>();
        List<Education> educations = new ArrayList<>();
        List<PersonInfo> personInfos = new ArrayList<>();
        ResumeView view = new ResumeView();


        try{
            XSSFWorkbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("이력서");

            view.inputPersonInfo();
            System.out.println("End : view.inputPersonInfo");
            // 엑셀 항목명 생성
            Row headerRow_personInfo = sheet.createRow(0);
            headerRow_personInfo.createCell(0).setCellValue("사진");
            headerRow_personInfo.createCell(1).setCellValue("이름");
            headerRow_personInfo.createCell(2).setCellValue("이메일");
            headerRow_personInfo.createCell(3).setCellValue("주소");
            headerRow_personInfo.createCell(4).setCellValue("전화번호");
            headerRow_personInfo.createCell(5).setCellValue("생년월일");

            for(int i=0; i  < personInfos.size(); i++){
                PersonInfo person = personInfos.get(i);
                Row row = sheet.createRow(i+1);
                row.createCell(0).setCellValue(person.getPhoto());
                row.createCell(1).setCellValue(person.getName());
                row.createCell(2).setCellValue(person.getEmail());
                row.createCell(3).setCellValue(person.getAddress());
                row.createCell(4).setCellValue(person.getPhoneNumber());
                row.createCell(5).setCellValue(person.getBrithDate());
            }

            view.inputEducationList();
            System.out.println("End : view.inputEducationList");
            Row headerRow_education = sheet.createRow(2);
            headerRow_education.createCell(0).setCellValue("졸업년도");
            headerRow_education.createCell(1).setCellValue("학교명");
            headerRow_education.createCell(2).setCellValue("전공");
            headerRow_education.createCell(3).setCellValue("졸업여부");

            for(int i=0; i  < educations.size(); i++){
                Education edu = educations.get(i);
                Row row = sheet.createRow(i+1);
                row.createCell(0).setCellValue(edu.getGraduationYear());
                row.createCell(1).setCellValue(edu.getSchoolName());
                row.createCell(2).setCellValue(edu.getMajor());
                Cell graduationStatus = row.createCell(4);
                graduationStatus.setCellValue(edu.getGraduationStatus());
            }

            view.inputCareerList();
            System.out.println("End : view.inputCareerList");
            Row headerRow_career = sheet.createRow(5);
            headerRow_career.createCell(0).setCellValue("근무기간");
            headerRow_career.createCell(1).setCellValue("근무처");
            headerRow_career.createCell(2).setCellValue("담당업무");
            headerRow_career.createCell(3).setCellValue("근속연수");

            for(int i=0; i  < careers.size(); i++) {
                Career career = careers.get(i);
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(career.getWorkPeriod());
                row.createCell(1).setCellValue(career.getJobTitle());
                row.createCell(2).setCellValue(career.getCompanyName());
                row.createCell(3).setCellValue(career.getEmploymentYears());
            }

            String filename = "member.xlsx";
            FileOutputStream outputStream =new FileOutputStream(new File(filename));
            workbook.write(outputStream);
            workbook.close();
            System.out.println("엑셀 파일이 저장되었습니다. " + filename);
        }catch(IOException e){
            System.out.println("엑셀 파일 저장 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}
