package cn.itcast.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Jsoup的快速入门
 */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        //1.导入jar包
        //2.获取document对象，根据xml文档来获取
        //2.1获取student.xml的路径
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();

        //2.2解析xml文档，加载文档进入内存。获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");

        //获取元素对象 Element对象
        Elements elements = document.getElementsByTag("name");

        //打印输出元素属性值
        for (Element e:elements
             ) {
            System.out.println(e.text());
        }
    }
}
