/**
 * @author Ben Grass
 * @version 1.0
 * 11/14/14
 * This interface describes methods for a LispList object
 */
public interface LispList {
    boolean isEmpty();
    Object head();
    LispList tail();
    int length();
    boolean contains(Object o);   
    public LispList merge(LispList other);
    public String toString();
    public LispList cons(Object o);
}
