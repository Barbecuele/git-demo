package cn.icast.test;

import cn.icast.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JacksonTest {
    //将java对象转换为字符串
    @Test
    public void test1() throws IOException {
        //1.创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("male");

        //2.创建Jackson的核心对象，ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //3.转换
        /*
            转换方法：
                writeValue(参数1 obj):
                    File:将字符串转换为json字符串，并保存到指定文件中
                    Writer:将字符串转换为json字符串，并将json数据填充到字符输出流当中
                    OutputStream:将字符串转换为json字符串，并将json数据填充到字节输出流当中
                writeValueAsString(obj):将字符串转换为json字符串
         */
        //String json = mapper.writeValueAsString(p);
        //System.out.println(json);//{"name":"张三","age":23,"gender":"male"}

        //writeValue，将数据写到d://a.txt当中
        //mapper.writeValue(new File("d://a.txt"),p);

        //writeValue将数据关联到writer中
        mapper.writeValue(new FileWriter("d://b.txt"), p);
    }

    @Test
    public void test2() throws IOException {
        //1.创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("male");
        p.setBirthday(new Date());

        //创建ObjectMapper核心对象
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json);

    }


    @Test
    public void test3() throws IOException {
        //1.创建Person对象
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(23);
        p1.setGender("male");

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(23);
        p2.setGender("male");

        Person p3 = new Person();
        p3.setName("张三");
        p3.setAge(23);
        p3.setGender("male");

        List<Person> ps = new ArrayList<>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ps);
        System.out.println(json);
    }

    @Test
    public void test4() throws IOException {
        //1.创建Person对象
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "lisi");
        map.put("age", "23");
        map.put("gender", "male");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
    }


    //JSON对象转换为java对象
    @Test
    public void test5() throws IOException {
        String json = "{\"gender\":\"male\",\"name\":\"lisi\",\"age\":\"23\"}";

        //创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
    }
}
