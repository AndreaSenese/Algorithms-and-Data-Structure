package sorting.mergesort;
import java.util.ArrayList;
import java.util.Comparator;
import sorting.SortingArrayException;
import sorting.SortingArray;
import sorting.sortingusage.*;

/**
 * @author Senese Andrea
 */

public class MergeSort<T>  extends SortingArray<T>{

    /**
     *It creates an empty sortedarray and returns the created array.It accepts as input a comparator 
     * implementing the precedence relation between the array elements.
     * @param comparator : a comparator implementing a relation order between the array elements.
     */

    public MergeSort(Comparator <? super T> comparator){
        super(comparator);
     }//initiator

    /**
    *
    *This is the wrapper method.
    *
    */


    public void mergeSort() throws SortingArrayException{
        mergeSort(0,sortedArraySize()-1);
    }//wrapp

    /**
    * this method divide the array in two parts.
    * @param left: is the position of first element; 
    * @param right: is the position of the last element
    */

    private void mergeSort(int left, int right) throws SortingArrayException{
        if(left < right){
            int medium_point = (left + right)/2;
            mergeSort(left,medium_point);
            mergeSort(medium_point +1,right);
            merge(left,medium_point,right);

        }
    }//mergeSort

    /**
    *
    * this method merge the two arrays.
    * @param left : is the position of first element
    * @param medium_point : is the medium_point of array.
    * @param right : is the position of the last element
    */
 
    private void merge(int left, int medium_point, int right) throws SortingArrayException{
        int i = left, j = medium_point + 1,k = 0;

        ArrayList<T> tmp = new ArrayList<>(right-left+1);

        while(i <= medium_point && j <= right){

        	if((this.comparator).compare((this.sortedarray).get(i),(this.sortedarray).get(j)) <= 0){
        		tmp.add(k,(this.sortedarray).get(i));
        		i = i + 1;
        	}else{
        		tmp.add(k,(this.sortedarray).get(j));
        		j = j + 1;
        	}
        	k = k + 1;

        }for(; i <= medium_point;i++,k++)
        	tmp.add(k,(this.sortedarray).get(i));
         for(; j <= right;j++,k++)
         	tmp.add(k,(this.sortedarray).get(j));
         for(k = left; k <= right; k++)
         	(this.sortedarray).set(k,tmp.get(k-left));
    }//merge
}