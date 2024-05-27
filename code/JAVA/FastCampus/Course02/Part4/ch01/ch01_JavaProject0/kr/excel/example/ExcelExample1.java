package kr.excel.example;
//2024-04-09
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formattable;

public class ExcelExample1 {
    public static void main(String[] args) {
        try{
            FileInputStream file = new FileInputStream(new File("example.xlsx")); // ROOT 경로에 존재하는 example.xlsx 파일을 찾음
            Workbook workbook = WorkbookFactory.create(file); // 가상의 excel 공간을 생성함
            Sheet sheet = workbook.getSheetAt(0); // excel sheet first page 를 의미
            for(Row row : sheet){ // 각 행
                for(Cell cell : row){  // 각 열
                    switch (cell.getCellType())  {
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)){
                                Date dateValue = cell.getDateCellValue();
                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                String formattedDate = dateFormat.format(dateValue);
                                System.out.print(formattedDate + "\t");
                            }else{
                                double numbericValue = cell.getNumericCellValue();
                                if(numbericValue == Math.floor(numbericValue)) {
                                    int intValue = (int) numbericValue;
                                    System.out.print(intValue + "\t");
                                }else{
                                    System.out.print(numbericValue + "\t");
                                }
                            }
                            break;
                        case STRING:
                            String stringValue = cell.getStringCellValue();
                            System.out.print(stringValue + "\t");
                            break;
                        case BOOLEAN:
                            boolean booleanValue = cell.getBooleanCellValue();
                            System.out.print(booleanValue + "\t");
                            break;
                        case FORMULA:
                            String formulaValue = cell.getCellFormula();
                            System.out.print(formulaValue + "\t");
                            break;
                        case BLANK:
                            System.out.print("\t");
                            break;
                        default:
                            System.out.print("\t");
                            break;
                    }
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
1	2	3	4	5	6	7	8	9	10
A	B	C	D	E	F	G	H	I	J
가길동	나길동	다길동	라길동	마길동	바길동	사길동	아길동	자길동	차길동
35.6	37.6	38.6	40.2666666666667	41.7666666666667	43.2666666666667	44.7666666666667	46.2666666666667	47.7666666666667	49.2666666666667
2023-04-09	2023-04-10	2023-04-11	2023-04-12	2023-04-13	2023-04-14	2023-04-15	2023-04-16	2023-04-17	2023-04-18
엑셀에서 데이터 읽어오기 끝!
*/