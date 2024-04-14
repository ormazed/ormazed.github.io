package kr.book.search;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BookSearchMain {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("도서제목을 입력하세요: ");
            String bookTitle= scanner.nextLine();
            List<Book> books = KakaoBookApi.searchBooks(bookTitle);

            if(books.isEmpty()){
                System.out.println("검색 결과가 없습니다.");
            }else {
                /*// 테스트용
                for(Book book : books){
                    System.out.println(book);
                }*/

                String fileName = "독서목록.pdf";
                PdfGenerator.generateBookListPdf(books, fileName);
                System.out.println(fileName + " 파일이 생성되었습니다.");

            }// end if
        }catch (IOException e){
            System.out.println("에러가 발생했습니다 : " + e.getMessage());
        } // end try
    }
}
