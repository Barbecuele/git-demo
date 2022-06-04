package cn.itcast.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Document/Element对象功能
 */
public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {

        //1.获取student.xml的路径
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();

        //获取Document对象
        Document document = Jsoup.parse(new File(path),"utf-8");

        //获取所有student对象
        Elements elements = document.getElementsByTag("student");
        for (Element e:elements
             ) {
            System.out.println(e);
        }

        System.out.println("-------------");

        //获取属性名
        Elements itcast = document.getElementsByAttribute("id");
        System.out.println(itcast);

        System.out.println("-------------");

        //获取number属性值为heima_0001的元素对象
        Elements number = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(number);

        System.out.println("-------------");

        Element itcast1 = document.getElementById("itcast");
        System.out.println(itcast1);

        System.out.println("-------------");
        Elements elements1 = document.getElementsByAttributeValue("id", "itcast");
        System.out.println(elements1);
    }
}
