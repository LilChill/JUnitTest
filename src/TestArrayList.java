import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class TestArrayList {
    private List<Integer> list;
    private List<Integer> c0;
    private List<Integer> c1;
    private List<String> c2;
    private int[] c3;
    @Before public void setUp(){
        list =new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(null);
        c0 = null;
//        c0.add(null);
        c1 = new ArrayList<Integer>();
        c1.add(2);

        c2 =new ArrayList<String>();
        c2.add("cat");
        c2.add("dog");

        c3=new int[10];
        c3[0]=1;
        c3[1]=2;

    }

    //Test1 of contains():C1-T
    @Test public void testContains(){
        assertTrue(list.contains(1));
    }
    //Test2 of contains():C1-F
    @Test public void testContains_C1(){
        assertFalse(list.contains(4));
    }

    //Test1 of get():C2-T
    @Test public void testGet(){
        assertEquals(new Integer(1),list.get(0));
    }
    //Test2 of get():C2-F
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_C2(){
        list.get(list.size());
    }

    //test1 of addAll:C2-T,C3-T
    @Test
    public void testAddAll_BaseCase(){
        assertTrue(list.addAll(0,c1));
    }
    //test2 of addAll:C2-T,C3-F
    @Test(expected = NullPointerException.class)
    public void testAddAll_C3(){

        list.addAll(0,c0);
    }

    //test3 of addAll:C2-F,C3-F
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAll_C2(){
        list.addAll(-1,c1);
    }
    //test1 of retainAll:C3-T,C4-T
    @Test
    public void testRetainAll_BaseCase(){
        assertTrue(list.retainAll(c1));
    }
    //test2 of retainAll:C3-T,C4-F
    @Test(expected = ClassCastException.class)
    public void testRetainAll_C4(){
        ArrayList list =(ArrayList) Arrays.asList(c3);//数组转成List
        list.retainAll(list);
    }
    //test3 of retainAll:C3-F,C4-T
    @Test(expected = NullPointerException.class)
    public void testRetainAll_C3(){
        list.retainAll(c0);
    }

}

