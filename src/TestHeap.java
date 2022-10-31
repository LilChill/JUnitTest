import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestHeap {
    private Integer[] heap;
    int n;
    /** Put element in its correct place */
    void siftdown(int pos) {
        assert (pos >= 0) && (pos < n) : "Illegal heap position";
        while (!isLeaf(pos)) {
            int j = leftchild(pos);
            if ((j<(n-1)) && (heap[j] < heap[j+1]))
                j++; // j is now index of child with greater value
            if (heap[pos] >= heap[j]) return;
            swap(heap, pos, j);
            pos = j;  // Move down
        }
    }

    /** @return True if pos a leaf position, false otherwise */
    public boolean isLeaf(int pos)
    { return (pos >= n/2) && (pos < n); }

    /** @return Position for left child of pos */
    public int leftchild(int pos) {
        assert pos < n/2 : "Position has no left child";
        return 2*pos + 1;
    }

    public static void swap(Integer[] A, int p1, int p2) {
        Integer temp = A[p1];
        A[p1] = A[p2];
        A[p2] = temp;
    }
    public void  initialize(Integer[] list){
        n=list.length;
        heap=list;
//        for (int i=0;i<n;i++){
//            heap[i]=list[i];
//        }
    }
    public int[] transform(Integer[] heap){
        int[] heapList = new int[n];
        for (int i=0;i<n;i++){
            if (heap[i]!=null){
                heapList[i]=heap[i];
            }
            else return null;
        }
        return heapList;
    }
    @Before
    public void setUp(){
        int maxsize = 10;
        heap = new Integer[maxsize];
    }

    @Test
    public void testEdge_1(){//[1,3,4,6,5,7,3,9]
        Integer[] list={5,8,2,3,6,1,9,0,4};
        initialize(list);
        int[] heapList ;
        int[] resList = {5,8,2,4,6,1,9,0,3};
        siftdown(3);
        heapList=transform(heap);
        assertArrayEquals(resList,heapList);

    }
    @Test
    public void testEdge_2(){//[1,3,4,5,8,9]
        Integer[] list={3,2,1};
        initialize(list);
        int[] heapList ;
        int[] resList = {3,2,1};
        siftdown(0);
        heapList=transform(heap);
        assertArrayEquals(resList,heapList);
    }

    @Test(expected = AssertionError.class)
    public void testEdge_3(){//[1,2,9]
        Integer[] list={3,2,1};

        initialize(list);
        siftdown(-1);
    }

    @Test public void testPrimePath_1(){//[1,3,4,5,7,3,4,5,7,3,4,6,5,7,3,4,6,5,7,3,9]

    }
    @Test public void testPrimePath_2(){//

    }
    @Test public void testPrimePath_3(){//

    }
    @Test public void testPrimePath_4(){//

    }
    @Test public void testPrimePath_5(){//

    }
    @Test public void testPrimePath_6(){//

    }
    @Test public void testPrimePath_7(){//

    }
    @Test public void testPrimePath_8(){//

    }
    @Test public void testPrimePath_9(){//

    }
}
