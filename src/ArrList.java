import java.util.*;

public class ArrList {
    private static final int defaultSize = 10; // Default size
    private  int maxSize;        // Maximum size of list
    public int listSize;       // Current # of list items
    public  Integer[] listArray;      // Array holding list elements
    public ArrList(){this(defaultSize);}
    /** Create a new list object.
     @param size Max # of elements list can contain. */
    @SuppressWarnings("unchecked") // Generic array allocation
    ArrList(int size) {
        maxSize = size;
        listSize = 0;
        listArray= new Integer[size];
    }
    public void insert(Integer n,int pos){
        assert listSize<maxSize: "List capacity exceeded";
        assert pos<listSize+1: "illegal position to insert";
        for(int i=listSize;i>pos;i--){
            listArray[i]=listArray[i-1];
        }
        listArray[pos]=n;
        listSize++;
    }
    public void append(Integer n){
        insert(n,listSize);
    }
    public void remove(int pos){
        assert listSize>0:"List is empty" ;
        assert pos>=0&&pos<listSize:"illegal position to remove";
        for(int i=pos;i<listSize-1;i++){
            listArray[i]=listArray[i+1];
        }
        listSize--;
    }
    public Integer search(int pos){
        assert pos>=0&&pos<listSize:"illegal position to search";
        return listArray[pos];
    }
    public int length(){return listSize;}

    /**
     * 该方法用于查找表中值界于minVal和maxVal之间的最大元素，返回最大元素的值、最大元素所在下标，最大元素的奇偶性
     * @param minVal
     * @param maxVal
     * @return largestNumber,largestIndex,evenOrOdd
     */
    public Object[] findLargestNumber(Integer minVal,Integer maxVal){
        //初始化各返回参数的值
        if(minVal!=null&&maxVal!=null)
            assert minVal<=maxVal : "illegal boundary";
        int largestNumber = listArray[0];
        int largestIndex = 0;
        String evenOrOdd ="odd";
        //迭代查询最大元素
        for(int i=1;i<listSize;i++){
            if ((minVal!=null&&largestNumber<minVal)||(maxVal!=null)&&largestNumber>maxVal){
                //If the initial value of largestNumber is out of range,take current element as initial value.
                largestNumber = listArray[i];
                largestIndex = i;
                continue;
            }
            if(listArray[i]>largestNumber&&(minVal==null||minVal<=listArray[i])&&(maxVal==null||maxVal>=listArray[i])){
                largestNumber=listArray[i];
                largestIndex=i;
            }
        }
        //不存在满足要求的元素，返回空
        if ((minVal!=null&&largestNumber<minVal)||(maxVal!=null)&&largestNumber>maxVal) return null;
        //检查最大元素的奇偶性
        if(largestNumber%2==0) evenOrOdd="even";
        return new Object[]{largestNumber,largestIndex,evenOrOdd};
    }
    public static void main(String[] args){
        ArrList list = new ArrList(10);
        list.append(9);
        list.append(8);
        list.append(1);
        list.append(6);list.append(7);
        System.out.println(Arrays.toString(list.findLargestNumber(null,null)));


    }
}
