package com.itheima.test;

import com.itheima.anno.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-anno.xml")
public class AnnoTest {

    @Autowired
    private TargetInterface target;

    @Test
    public void test1(){
        //target.save();
        Set<Integer> sa=new HashSet<>();
        Random r=new Random();
        for(int i=0;i<6;i++){
            sa.add(r.nextInt(32)+1);
        }

        Integer[] sb = sa.toArray(new Integer[sa.size()]);
        for (Integer a:sb
             ) {
            System.out.println(a);
        }
    }

}
