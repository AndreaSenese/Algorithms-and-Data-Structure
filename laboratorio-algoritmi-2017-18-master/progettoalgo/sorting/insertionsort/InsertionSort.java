package sorting.insertionsort;
import java.util.ArrayList;
import java.util.Comparator;
import sorting.SortingArray;
import sorting.SortingArrayException;

/**
 * @author Senese Andrea
 * @param <T>: type of sorted array elements
 */


public class InsertionSort<T> extends SortingArray<T>{

    /**
     * Initiator
     * @param comparator : a comparator implementing a relation order between Integer.
     */
    
    public InsertionSort(Comparator <? super T> comparator){
        super(comparator);
    }//initiator

     /**
     * This is a wrapper.
     */


    public void insertion_Sort() throws SortingArrayException{
        insertion_sort();
    }// wrapper

    /**
     * This method swap the elements when the element do not respect the order relationship.
     * @param  left : the left position of array:
     * @param  right : the right position of array.
     * @throws SortingArrayException.
     */

    private void swap(int left,int right) throws SortingArrayException{
        T tmp = getSortingArrayElement(left);
        setSortingArrayElement(left,getSortingArrayElement(right));
        setSortingArrayElement(right,tmp);
    } //swap

     
     /**
     * This method compare the element of array and call the method swap  
     * if and oly if the previous element  is bigger than the next.
     * @throws SortingArrayException.
     */

    private void insertion_sort() throws SortingArrayException{
        int j = 0;
            for(int sorted = 1; sorted< sortedArraySize(); sorted++) {
                j = sorted;
                while (j > 0 && (this.comparator).compare(getSortingArrayElement(j-1),
                        getSortingArrayElement(j)) > 0 ){
                    swap(j-1, j);
                    j--;
                }
            }
    } //insertionsort
  
    
}