/**
 * @author Ben Grass
 * @version 1.0
 * 11/14/14
 * This represents a NonEmptyList which is a LispList that is not empty.
 * Output:
 (A, B)
 (1, 2)
 (A, 1, B, 2)
 */
public class NonEmptyList implements LispList {
    private LispList tail;
    private Object head;
    private static final EmptyList NIL = new EmptyList();
    
    /**
     * Determines length of a NonEmptyList object by using a somewhat recursive solution
     * @return Length of a LispList
     */
    public int length() {
        if(this.tail.isEmpty()) return 1;
        else {
            int x = 1 + this.tail.length();
            return x;
        }
    }
    
    /**
     * Checks whether LispList contains an object.
     * @param o Object to check LispList for
     * @return Does LispList contain a specific object?
     */
    public boolean contains(Object o) {
        if(this.head.equals(o)) return true;
        else if(this.tail.isEmpty()) return false;
        else return this.tail.contains(o);
    }
    
    /**
     * Creates a new NonEmptyList Object
     * @param head Object that represents 'head' of a LispList
     * @param tail LispList that represents the tail of a LispList
     */
    public NonEmptyList(Object head, LispList tail) {
        this.tail = tail;
        this.head = head;
    }
    
    
    /**
     * Adds on an object to the end of the LISP List
     * @param o Object to end onto list
     */
    public LispList cons(Object o) {
        NonEmptyList list = this;
        while(!list.tail().isEmpty()) {
            list = (NonEmptyList)list.tail();
        }
        list.setTail(new NonEmptyList(o, new EmptyList()));
        return this;
    }
    
    /**
     * Returns whether boolean is empty
     * @return Is LispList empty?
     */
    public boolean isEmpty() {
        return false;
    }
    
    /**
     * Returns the head of the list.
     * @return the 'head' of the list
     */
    public Object head() {
        return head;
    }
    
    /**
     * Returns the tail of the list.
     * @return the 'tail' of the list
     */
    public LispList tail() {
        return tail;
    }
    
    /**
     * Sets the tail of the List Object
     * @param list is the list which will become the tail of the object
     */
    public void setTail(LispList list) {
        this.tail = list;
    }
    
    /**
     * Takes in list of objects and creates a new LispList
     * @param objects array of objects
     * @return LispList with all objects
     */
    public static LispList lispListWithObjects(Object ... objects) {
        LispList list = new NonEmptyList(objects[0], new EmptyList());
        for(int i = 1; i < objects.length; i++) {
            list = list.cons(objects[i]);
        }
        return list;
        
    }
    
    /**
     * This method merges two LispLists
     * @param other Other lisp list to merge other than this
     * @return merged Lisp List
     */
    public LispList merge(LispList other) {
        if(other.isEmpty()) {
            return this;
        }
        
        LispList list = new NonEmptyList(this.head,new EmptyList());
        LispList self = this.tail;
        boolean selfLonger = true;
        if(other.length() > self.length()) {
            selfLonger = false;
        }
        
        
        if(selfLonger) {
            while(!other.isEmpty()) {
                
                list = list.cons(other.head());
                other = other.tail();
                list = list.cons(self.head());
                self = self.tail();
            }
            while(!self.isEmpty()) {
                list = list.cons(self.head());
                self = self.tail();
            }
        } else {
            while(!self.isEmpty()) {
                list = list.cons(other.head());
                other = other.tail();
                list = list.cons(self.head());
                self = self.tail();
            }
            while(!other.isEmpty()) {
                list = list.cons(other.head());
                other = other.tail();
            }
        }
        return list;
    }
    
    /**
     * Creates String of LispList
     * @return String of LispList
     */
    public String toString() {
        String retString = "(";
        LispList list = this;
        while(!list.isEmpty()) {
            retString += list.head() + ", ";
            list = list.tail();
        }
        retString = retString.substring(0, retString.length()-2) + ")";
        return retString;
    }
    
    public static void main(String[] args) {
        LispList list1 = NIL.cons("A").cons("B");
        LispList list2 = NIL.cons("1").cons("2");
        LispList list3 = list1.merge(list2);
        LispList list4 = NonEmptyList.lispListWithObjects("A","B","C","D","E","1","2","3");
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);
    }
    
}