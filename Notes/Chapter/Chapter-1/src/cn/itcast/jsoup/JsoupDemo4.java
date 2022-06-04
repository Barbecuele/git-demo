package cn.itcast.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Element对象功能
 */
public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo4.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path),"utf-8");

        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());

        System.out.println("*******************");

        //通过Element对象来获取子标签元素
        Element element_stu = document.getElementsByTag("student").get(0);
        Elements ele_name = element_stu.getElementsByTag("name");
        System.out.println(ele_name);

        System.out.println("-------------------");
        //获取student对象的属性值
        String number = element_stu.attr("number");
        System.out.println(number);

        System.out.println("*******************");

        String name = ele_name.text();
        System.out.println(name);

        String html = ele_name.html();
        System.out.println(html);
    }
}
