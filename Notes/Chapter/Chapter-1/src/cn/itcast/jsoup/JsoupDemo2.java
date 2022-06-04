package cn.itcast.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Jsoup对象功能
 */
public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
        //1.导入jar包
        //2.获取document对象，根据xml文档来获取
        //2.1获取student.xml的路径
        String path = JsoupDemo2.class.getClassLoader().getResource("student.xml").getPath();

        URL url = new URL("https://baike.baidu.com/item/jsoup/9012509?fr=aladdin");
        Document parse = Jsoup.parse(url, 3000);
        System.out.println(parse.text());
    }
}
