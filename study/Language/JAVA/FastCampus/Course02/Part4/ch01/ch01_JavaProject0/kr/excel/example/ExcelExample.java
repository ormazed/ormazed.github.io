package kr.excel.example;
//2024-04-09
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelExample {
    public static void main(String[] args) {
        try{
            FileInputStream file = new FileInputStream(new File("example.xlsx")); // ROOT 경로에 존재하는 example.xlsx 파일을 찾음
            Workbook workbook = WorkbookFactory.create(file); // 가상의 excel 공간을 생성함
            Sheet sheet = workbook.getSheetAt(0); // excel sheet first page 를 의미
            for(Row row : sheet){ // 각 행
                for(Cell cell : row){  // 각 열
                    System.out.print(cell.toString()+"\t"); // 각 cell 의 내용을 받아옴
                }
                System.out.println(); // 줄바꿈
            }
            file.close();
            System.out.println("엑셀에서 데이터 읽어오기 끝!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
/*
1.0	2.0	3.0	4.0	5.0	6.0	7.0	8.0	9.0	10.0
A	B	C	D	E	F	G	H	I	J
가길동	나길동	다길동	라길동	마길동	바길동	사길동	아길동	자길동	차길동
35.6	37.6	38.6	40.2666666666667	41.7666666666667	43.2666666666667	44.7666666666667	46.2666666666667	47.7666666666667	49.2666666666667
09-4월-2023	10-4월-2023	11-4월-2023	12-4월-2023	13-4월-2023	14-4월-2023	15-4월-2023	16-4월-2023	17-4월-2023	18-4월-2023
엑셀에서 데이터 읽어오기 끝!
=> excel 에 작성된 값의 셀타입이 고려되지 못하고 있다.
*/