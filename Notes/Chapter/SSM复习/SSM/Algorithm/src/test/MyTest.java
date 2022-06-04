package test;

import array.Sort;
import org.junit.Test;

public class MyTest {

    @Test
    public void test1(){

        Sort sort = new Sort(20);
        sort.addLast(2);
        sort.addLast(3);
        sort.addLast(2);
        sort.addLast(3);
        sort.addLast(2);
        sort.addLast(3);
        sort.add(2,9);
        System.out.println(sort);
    }

    @Test
    public void test2(){
        Sort sort = new Sort();
        sort.addLast(2);
        sort.addLast(3);
        //int value = sort.getValue(4);
        //System.out.println(value );
        System.out.println(sort);
    }

    @Test
    public void test3(){
        Sort sort = new Sort();
        sort.addLast(2);
        sort.addLast(3);

        sort.delete(1);
        System.out.println(sort);
    }
}
