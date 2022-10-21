import org.junit.Test;

import static org.junit.Assert.*;

public class TestJunit {
    AList aList=new AList();
    Integer[] list= new Integer[]{4, 3, 2,1,0};
    @Test
    public void testCase1(){
        //在当前位置插入maxSize个元素，并取aList当前元素的值
        aList.clear();
        for (Integer integer : list) {
            aList.insert(integer);
        }
        assertEquals(new Integer(0),aList.getValue());

    }
    @Test
    public void testCase2(){
        //在当前位置插入list，并移动到指定位置，取当前位置的值。
        aList.clear();
        int pos = 10;
        for (Integer integer : list) {
            aList.insert(integer);
        }
        aList.moveToPos(pos);
        assertEquals("Pos out of range",aList.currPos());
    }
    @Test
    public void testCase3(){
        //在当前位置插入list，并移动到末位，取当前位置的值。
        aList.clear();
        for (Integer integer : list) {
            aList.insert(integer);
        }
        aList.moveToEnd();
        assertEquals(4,aList.currPos());
    }
    @Test
    public void testCase4(){
        //使用next()取下一个位置的元素的值。
        aList.clear();
        for (Integer integer : list) {
            aList.insert(integer);
        }
        aList.moveToPos(aList.length()-1);
        aList.next();
        assertNull(aList.getValue());
    }
    @Test
    public void testCase5(){
        //使用prev()取上一个位置的元素的值。
        aList.clear();
        for (Integer integer : list) {
            aList.insert(integer);
        }
        aList.insert(5);
        aList.prev();
        assertNull(aList.getValue());
    }
    @Test
    public void testCase6(){
        //删除最后一个元素，并取删除后对象中的当前元素。
        aList.clear();
        for (Integer integer : list) {
            aList.insert(integer);
        }
        aList.moveToPos(aList.length()-1);
        aList.remove();
        assertEquals(new Integer(3),aList.getValue());
    }
    @Test
    public void testCase7(){
        //在数组末位append元素，并取最后一个元素的值。
        aList.clear();
        for (Integer integer : list) {
            aList.append(integer);
        }
        aList.moveToEnd();
        assertEquals(new Integer(4),aList.getValue());
    }
}

