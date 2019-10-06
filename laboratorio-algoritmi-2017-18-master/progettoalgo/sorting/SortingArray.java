package sorting;
import java.util.ArrayList;
import java.util.Comparator; //define order relationship of elements into ArrayList
/**
 *
 * @author Senese Andrea
 * @param <T> : type of sorted array elements
 */

    public class SortingArray <T>{
        protected ArrayList<T> sortedarray = null;
        protected Comparator<? super T> comparator;

    /**
     * Create an empty Sorting ArrayList
     * @param comparator : a comparator implementing a relation order between Generic element.
     */
    public SortingArray(Comparator <? super T> comparator){
        this.sortedarray = new ArrayList<T>();
        this.comparator = comparator;
    } // SortingArray initiator

    /**
     * @return : this methods return true if and only if sortedarraylist is Empty.
     */

    public boolean sortingArrayIsEmpty(){
        return ((this.sortedarray).isEmpty());
    } //when Sorted array is empty!!

     /**
     * @return : this methods return structure.
     */

    public ArrayList<T> getsortedArray(){
        return this.sortedarray;
    }


    /**
     *
     * @return : this methods return a size of sortedarraylist.
     */

    public int sortedArraySize(){
        return ((this.sortedarray).size());
    }// size of sortedarraylist

    /**
     * @return : this methods add in arraylist a new elements in the right position.
     * @throws SortingArrayException.
     */


    public boolean sortedArrayAdd(T element) throws SortingArrayException{
        return (this.sortedarray).add(element);
    }

    /**
     * @param element
     * @throws SortingArrayException : if and only if the index passed by parameter not respect the range of structure.
     * @return : this methods return an element in the position given by parameter
     */

    public T getSortingArrayElement(int position) throws SortingArrayException{
        if (position < 0  || position > sortedArraySize())
            throw new SortingArrayException("this index : " + position + "is out of bounds");
        return ((this.sortedarray).get(position));
    }

    /**
     * @param1 position
     * @param2 element
     * @throws SortingArrayException : if and only if the index passed by parameter not respect the range of structure.
     * @return : this methods return an element in the position given by parameter
     */

    public T setSortingArrayElement(int position,T element) throws SortingArrayException{
        if(position < 0 || position > sortedArraySize())
            throw new SortingArrayException("this index : " + position + "is out of bounds");
        return (this.sortedarray).set(position,element);
    }


     /**
     *  this methods print sortedarray.
     */

    public void print(){
        for(T elem : sortedarray)
            System.out.println(elem + " ");
    }
}