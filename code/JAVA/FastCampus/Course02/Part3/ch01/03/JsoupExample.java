package fc.java.course2.part3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.annotation.Documented;

public class JsoupExample {
    public static void main(String[] args) {
        try {
            String url = "https://sum.su.or.kr:8888/bible/today";
            Document document = Jsoup.connect(url).get();
            Element bibleText = document.getElementById("bible_text");
            Element bibileInfoBox = document.getElementById("bibleinfo_box");

            System.out.println("bibleText = "  + bibleText.text());
            System.out.println("bibileInfoBox = "+  bibileInfoBox.text());

            Elements num  = document.select(".num");
            Elements info  = document.select(".info");

            for(int i=0 ; i<num.size(); i++){
                System.out.println(num.get(i).text()+" : " + info.get(i).text());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
