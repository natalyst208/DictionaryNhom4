package utility;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import javafx.scene.image.Image;


import java.io.*;

public class UtilsProject {

    public static String getHTMLTextWord(String htmlText) {
        Document document = Jsoup.parse(htmlText, "UTF-8");
        Element element = document.body().select("> p").first();
        return element.text();
    }

    public static Image loadImage(String filePath) {
        Image image = null;
        try {
            FileInputStream inputFile = new FileInputStream(filePath);
            image = new Image(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Load image unsuccessfully " + filePath);
            e.printStackTrace();
        }
        return image;
    }

    public static String setUneditable(String html) {
        if(html.contains("contenteditable=\"true\"")){
            html = html.replace("contenteditable=\"true\"", "contenteditable=\"false\"");
        }
        return html;
    }
}
