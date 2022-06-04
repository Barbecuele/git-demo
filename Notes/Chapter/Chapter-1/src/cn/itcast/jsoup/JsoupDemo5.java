package cn.itcast.jsoup;

/**
 * 选择器查询
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo5.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        //查询name标签
        Elements name = document.select("name");
        System.out.println(name);

        System.out.println("*****************");

        //查询id值为itcast的元素
        Elements elements = document.select("#itcast");
        System.out.println(elements);

        System.out.println("-----------------");

        //获取student标签并且number属性值为黑马_0001的age子标签
        Elements elements1 = document.select("student[number='heima_0001']");
        System.out.println(elements1);

        System.out.println("*****************");

        Elements elements2 = document.select("student[number='heima_0001']>age");
        System.out.println(elements2);
    }
}
