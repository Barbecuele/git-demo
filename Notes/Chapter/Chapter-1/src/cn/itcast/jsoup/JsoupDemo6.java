package cn.itcast.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * XPath查询
 */
public class JsoupDemo6 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path = JsoupDemo6.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        //根据document对象创建JXDocument对象
        JXDocument jxDocument = new JXDocument(document);

        //结合XPath语法进行查询
        //查询所有的student标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jn:jxNodes
             ) {
            System.out.println(jn);
        }

        System.out.println("************************");

        //查询所有student标签下的name标签
        List<JXNode> jxNodes1 = jxDocument.selN("//student/name");
        for (JXNode jn:jxNodes1
             ) {
            System.out.println(jn);
        }

        System.out.println("************************");

        //查询student标签下带有id属性的name标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name[@id]");
        for (JXNode jn:jxNodes2
        ) {
            System.out.println(jn);
        }

        System.out.println("************************");

        //查询student标签下带有id属性的name标签,并且id属性值为itcast
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id='itcast']");
        for (JXNode jn:jxNodes3
        ) {
            System.out.println(jn);
        }
    }
}
