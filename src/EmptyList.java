/**
 * @author Ben Grass
 * @version 1.0
 * 11/14/14
 * This represents an empty LispList object
 */
import java.lang.UnsupportedOperationException;

public class EmptyList implements LispList {
   
    /**
     * Returns that EmptyList is empty
     * @return true
     */
    public boolean isEmpty() {
        return true;
    }
    
    /*
     * Creates new NonEmptyList from an EmptyList object
     * @param o Object to make list with
     * @return NonEmptyList containing o
     */
    public NonEmptyList cons(Object o) {
        return new NonEmptyList(o, new EmptyList());
    }
   
    public LispList tail(){
        throw new UnsupportedOperationException();
    }
    
    public Object head(){
        throw new UnsupportedOperationException();
    }
    
    /**
     * Returns false because EmptyLists don't have heads or tails
     * @param o Object to check LispList for
     * @return false
     */
    public boolean contains(Object o) {
        return false;
    }
    
    /**
     * Returns 0 because that is the length of an EmptyList
     * @return 0
     */
    public int length() {
        return 0;
    }
    
    /**
     * String representation of list but because it is empty, ()
     * @return "()"
     */
    public String toString() {
        return "()";
    }
    
    /**
     * Returns merged LispList
     * @param other other LispList to merge with
     * @return merged LispList
     */
    public LispList merge(LispList other) {
        return other;
    } 
}

