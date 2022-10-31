public class Heap {
    private static final int maxsize =20;
    public Integer[] heap;   // Pointer to the heap array
    int n;      // Number of things in heap
    public Heap(){

    }
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

}
