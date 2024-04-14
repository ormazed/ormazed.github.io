package kr.book.search;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KakaoBookApi {
    private static final String API_KEY = "e1882fafddb3def63b6ee22e13e804a6"; // Rest API KEY
    private static final String API_BASE_URL="https://dapi.kakao.com/v3/search/book";
    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();

    // 책검색 메서드
    public static List<Book> searchBooks(String title) throws IOException {
        // 연결 URL 생성
        HttpUrl.Builder urlBuilder = HttpUrl.parse(API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter("query", title);

        // 서버에 전달할 Request 생성
        // curl -v -G GET "https://dapi.kakao.com/v3/search/book?target=title" \
        //--data-urlencode "query=미움받을 용기" \
        //-H "Authorization: KakaoAK ${REST_API_KEY}"
        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .addHeader("Authorization","KakaoAK " + API_KEY) //-H "Authorization: KakaoAK ${REST_API_KEY}"
                .build();

        // 서버에 전달
        try(Response response = client.newCall(request).execute()) {
            if(!response.isSuccessful()) throw new IOException("Request failed"  + response);

            JsonObject jsonResponse = gson.fromJson(response.body().charStream(), JsonObject.class); // 반환되는 결과를 json 으로 만들어서 JsonObject 에 전달
            JsonArray documents = jsonResponse.getAsJsonArray("documents");

            List<Book> books = new ArrayList<>(); // 검색된 책의 title, authors, publisher, thumbnail 이 저장된 객체
            for(JsonElement document : documents) {
                JsonObject bookJson = document.getAsJsonObject();
                Book book = new Book(
                        bookJson.get("title").getAsString(),
                        bookJson.get("authors").getAsString().toString(),
                        bookJson.get("publisher").getAsString(),
                        bookJson.get("thumbnail").getAsString()
                ); // end Book
                books.add(book);
            }// end for
            return books;
        }// end try
    }//  end searchBooks()
}
