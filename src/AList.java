import org.junit.Test;

/** Array-based list implementation */
public class AList {
    private static final int defaultSize = 10; // Default size
    private  int maxSize;        // Maximum size of list
    public int listSize;       // Current # of list items
    public int curr;           // Position of current element
    public  Integer[] listArray;      // Array holding list elements

    /** Constructors */
    /** Create a list with the default capacity. */
    public AList() { this(defaultSize); }
    /** Create a new list object.
     @param size Max # of elements list can contain. */
    @SuppressWarnings("unchecked") // Generic array allocation
    AList(int size) {
        maxSize = size;
        listSize = curr = 0;
//        listArray = (Integer[])(new Object[size]);  // Create listArray
        listArray= new Integer[size];
    }

    public void clear()         // Reinitialize the list
    { listSize = curr = 0; }  // Simply reinitialize values

    /** Insert "it" at current position */

    public void insert(Integer it) {
        assert listSize < maxSize : "List capacity exceeded";
        for (int i=listSize; i>curr; i--) // Shift elements up
            listArray[i] = listArray[i-1];  //   to make room
        listArray[curr] = it;
        listSize++;               // Increment list size
    }

    /** Append "it" to list */
    public void append(Integer it) {
        assert listSize < maxSize : "List capacity exceeded";
        listArray[listSize++] = it;
    }

    /** Remove and return the current element */

    public Integer remove() {
        if ((curr<0) || (curr>=listSize))  // No current element
            return null;
        int it = listArray[curr];   // Copy the element
        for(int i=curr; i<listSize-1; i++) // Shift them down
            listArray[i] = listArray[i+1];
        listSize--;               // Decrement size
        return it;
    }
    public void moveToStart() { curr = 0; } // Set to front
    public void moveToEnd() { curr = listSize; } // Set at end
    public void prev() { if (curr != 0) curr--; }   // Back up
    public void next() { if (curr < listSize) curr++; }

    /** @return List size */
    public int length() { return listSize; }

    /** @return Current position */
    public int currPos() { return curr; }

    /** Set current list position to "pos" */
    public void moveToPos(int pos) {
        assert (pos>=0) && (pos<=listSize) : "Pos out of range";
        curr = pos;
    }

    /** @return Current element */
    public Integer getValue() {
        assert (curr>=0) && (curr<listSize) :
                "No current element";
        return listArray[curr];
    }
}

