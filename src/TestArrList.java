import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

public class TestArrList {
    ArrList list = new ArrList(10);
    public void assignment(Integer[] arr){
        for (Integer integer : arr) list.append(integer);
    }
    @Test
    public void testISP_1(){  //minVAl<maxVal,true,exists
        Integer[] arr =new Integer[]{1,5,3,8,2};
        assignment(arr);
        Object[] res = list.findLargestNumber(3,7);
        Object[] expect = new Object[]{5,1,"odd"};
        assertEquals(expect,res);
    }
    @Test
    public void testISP_2(){ //minVAl==maxVal,true,exists
        Integer[] arr =new Integer[]{1,3,2,5};
        assignment(arr);
        Object[] res = list.findLargestNumber(3,3);
        Object[] expect = new Object[]{3,1,"odd"};
        assertEquals(expect,res);
    }
    @Test(expected = AssertionError.class)
    public void testISP_3(){ //minVAl>maxVal,true,not exists
        Integer[] arr =new Integer[]{};
        assignment(arr);
        list.findLargestNumber(7,3);
    }
    @Test
    public void testISP_4(){ //minVAl==null,true,exists
        Integer[] arr =new Integer[]{1,8,5,2,3};
        assignment(arr);
        Object[] res=list.findLargestNumber(null,10);
        Object[] expect = new Object[]{8,1,"even"};
        assertEquals(expect,res);
    }
    @Test
    public void testISP_5(){ //maxVal==null,true,exists
        Integer[] arr =new Integer[]{1,8,5,2,3};
        assignment(arr);
        Object[] res=list.findLargestNumber(2,null);
        Object[] expect = new Object[]{8,1,"even"};
        assertEquals(expect,res);
    }
    @Test(expected = NullPointerException.class)
    public void testISP_6(){ //minVAl<maxVal,false,not exists
        Integer[] arr =new Integer[]{};
        assignment(arr);
        list.findLargestNumber(2,5);
    }
    @Test
    public void testISP_7(){ //minVAl<maxVal,true,not exists
        Integer[] arr =new Integer[]{1,8,5,2,3};
        assignment(arr);
        Object[] res=list.findLargestNumber(9,10);
        assertNull(res);
    }
    //图覆盖
    @Test
    public void testPrimePath_1(){
        //{1,2,3,1,2,3,1,7,8,12}
        Integer[] arr=new Integer[]{8,9,7};
        assignment(arr);
        Object[] res = list.findLargestNumber(2,5);
        assertNull(res);
    }
    @Test
    public void testPrimePath_2(){
        //{1,2,3,1,2,4,6,1,7,9,11,12}
        Integer[] arr=new Integer[]{8,5,3};
        assignment(arr);
        Object[] res = list.findLargestNumber(2,6);
        Object[] expect = new Object[]{5,1,"odd"};
        assertEquals(expect,res);

    }
    @Test
    public void testPrimePath_3(){
        //{1,2,4,6,1,2,4,6,1,7,9,11,12}
        Integer[] arr=new Integer[]{5,2,3};
        assignment(arr);
        Object[] res = list.findLargestNumber(1,6);
        Object[] expect = new Object[]{5,0,"odd"};
        assertEquals(expect,res);
    }
    @Test
    public void testPrimePath_4(){
        //{1,2,3,1,2,4,5,6,1,7,9,11,12}
        Integer[] arr=new Integer[]{8,5,7};
        assignment(arr);
        Object[] expect=new Object[]{7,2,"odd"};
        Object[] res = list.findLargestNumber(2,7);
        assertEquals(expect,res);
    }
    @Test
    public void testPrimePath_5(){
        //{1,2,4,6,1,7,9,11,12}
        Integer[] arr=new Integer[]{5,4};
        assignment(arr);
        Object[] res = list.findLargestNumber(2,5);
        Object[] expect = new Object[]{5,0,"odd"};
        assertEquals(expect,res);
    }
    @Test
    public void testPrimePath_6(){
        //{1,2,4,5,6,1,7,9,11,12}
        Integer[] arr=new Integer[]{4,5};
        assignment(arr);
        Object[] res = list.findLargestNumber(2,5);
        Object[] expect = new Object[]{5,1,"odd"};
        assertEquals(expect,res);
    }
    @Test
    public void testPrimePath_7(){
        //{1,2,4,6,1,7,9,10,11,12}
        Integer[] arr=new Integer[]{6,4};
        assignment(arr);
        Object[] res = list.findLargestNumber(2,7);
        Object[] expect = new Object[]{6,0,"even"};
        assertEquals(expect,res);
    }
    @Test
    public void testPrimePath_8(){
        //{1,2,4,5,6,1,7,9,10,11,12}
        Integer[] arr=new Integer[]{5,6};
        assignment(arr);
        Object[] res = list.findLargestNumber(2,7);
        Object[] expect = new Object[]{6,1,"even"};
        assertEquals(expect,res);
    }
    //谓词覆盖
    @Test
    public void testPredicate_1(){
        //{T,T,T,T,F,T}
        Integer[] arr=new Integer[]{3,4};
        assignment(arr);
        Object[] res = list.findLargestNumber(2,5);
        Object[] expect = new Object[]{4,1,"even"};
        assertEquals(expect,res);
    }
    @Test
    public void testPredicate_2(){
        //{F,T,F,T,F,F}
        Integer[] arr=new Integer[]{2,3};
        assignment(arr);
        Object[] res = list.findLargestNumber(null,5);
        Object[] expect = new Object[]{3,1,"odd"};
        assertEquals(expect,res);
    }
    @Test
    public void testPredicate_3(){
        //{T,F,n/a,n/a,T,n/a}
        Integer[] arr=new Integer[]{8};
        assignment(arr);
        Object[] res = list.findLargestNumber(2,7);
        assertNull(res);
    }
    @Test
    public void testPredicate_4(){
        //{T,T,F,F,F,F}
        Integer[] arr=new Integer[]{3,2};
        assignment(arr);
        Object[] res = list.findLargestNumber(2,5);
        Object[] expect = new Object[]{3,0,"odd"};
        assertEquals(expect,res);
    }
    @Test
    public void testCACC1_1(){
        //{T,T,T,F}
        Integer[] arr=new Integer[]{2,5,8};
        assignment(arr);
        Object[] res = list.findLargestNumber(3,6);
        Object[] expect = new Object[]{5,1,"odd"};
        assertEquals(expect,res);
    }
    @Test
    public void testCACC1_2(){
        //{T,F,T,F}
        Integer[] arr=new Integer[]{5,8,2,4};
        assignment(arr);
        Object[] res = list.findLargestNumber(2,8);
        Object[] expect = new Object[]{8,1,"even"};
        assertEquals(expect,res);
    }
    @Test
    public void testCACC1_3(){
        //{T,F,T,T}
        Integer[] arr=new Integer[]{8,3,1,5};
        assignment(arr);
        Object[] res = list.findLargestNumber(2,5);
        Object[] expect = new Object[]{5,3,"odd"};
        assertEquals(expect,res);
    }
    @Test
    public void testCACC2_1(){
        //{T,T,T,T,T}
        Integer[] arr=new Integer[]{5,6};
        assignment(arr);
        Object[] res = list.findLargestNumber(2,8);
        Object[] expect = new Object[]{6,1,"even"};
        assertEquals(expect,res);
    }
    @Test
    public void testCACC2_2(){
        //{F,T,T,T,T}
        Integer[] arr=new Integer[]{5,3,6,9};
        assignment(arr);
        Object[] res = list.findLargestNumber(2,5);
        Object[] expect = new Object[]{5,0,"odd"};
        assertEquals(expect,res);
    }
    @Test
    public void testCACC2_3(){
        //{T,T,T,F,F}
        Integer[] arr=new Integer[]{5,100,4,2};
        assignment(arr);
        Object[] res = list.findLargestNumber(5,null);
        Object[] expect = new Object[]{100,1,"even"};
        assertEquals(expect,res);
    }
    @Test
    public void testCACC2_4(){
        //{T,T,T,T,F}
        Integer[] arr=new Integer[]{2,5,8,1};
        assignment(arr);
        Object[] res = list.findLargestNumber(2,3);
        Object[] expect = new Object[]{2,0,"even"};
        assertEquals(expect,res);
    }
}
