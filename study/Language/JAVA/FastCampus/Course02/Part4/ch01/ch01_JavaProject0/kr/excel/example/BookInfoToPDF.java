package kr.excel.example;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Year;
import java.util.HashMap;

public class BookInfoToPDF {
    public static void main(String[] args) {
        // iText API 를 이용해서 책정보를 PDF 파일에 생성하는 실습(책정보는 제목, 저자, 출판사, 년도, 가격, 페이지수로 구성)
        HashMap<String, String> bookInfo = new HashMap<>();
        bookInfo.put("title","황금가지");
        bookInfo.put("author","J.프레이저");
        bookInfo.put("publisher","한글 출판사");
        bookInfo.put("year",String.valueOf(Year.now().getValue()));
        bookInfo.put("price","24000");
        bookInfo.put("pages","400");

        try{
            // PDF 생성을 위한 PdfWriter 객체 생성
            PdfWriter writer = new PdfWriter(new FileOutputStream("book_info.pdf"));

            // PdfWriter 객체를 사용하여 PdfDocument 객체 생성
            PdfDocument pdf = new PdfDocument(writer);

            // Document 객체 생성
            Document document = new Document(pdf);

            // 폰트 생성 및 추가
            PdfFont font = PdfFontFactory.createFont("malgunbd.ttf", PdfEncodings.IDENTITY_H, true); // System 에 저장된 font 경로 C:\Windows\Fonts\맑은 고딕
            document.setFont(font);

            // 책 정보를 문단으로 생성하여 Document 에 추가
            for(String key : bookInfo.keySet()){
                Paragraph paragraph = new Paragraph(key + ": " + bookInfo.get(key));
                document.add(paragraph);
            }
            document.close();
            System.out.println("book_info.pdf 파일이 생성되었습니다.");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
