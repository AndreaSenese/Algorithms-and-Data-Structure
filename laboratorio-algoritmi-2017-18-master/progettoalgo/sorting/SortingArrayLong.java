package sorting;
import java.util.ArrayList;
import java.util.Comparator; //define order relationship of elements into ArrayList
/**
 *
 * @author Senese Andrea
 */

    public class SortingArrayLong{
        protected ArrayList<Long> sortedarray = null;
        protected Comparator<Long> comparator;

    /**
     * Create an empty Sorting ArrayList
     * @param comparator : a comparator implementing a relation order between Long element.
     */
    public SortingArrayLong(Comparator <Long> comparator){
        this.sortedarray = new ArrayList<Long>();
        this.comparator = comparator;
    } // SortingArray

    /**
     * @return : this methods return true if and only if sortedarraylist is Empty.
     */

    public boolean sortingArrayIsEmpty(){
        return ((this.sortedarray).isEmpty());
    } //when Sorted array is empty!!

    /**
     *
     * @return : this methods return a size of sortedarraylist.
     */

    public int sortedArraySize(){
        return ((this.sortedarray).size());
    }// size of sortedarraylist

    /**
     * @param element : the element interested to add.
     * @return : this methods add in arraylist a new elements in the right position.
     * @throws SortingArrayLongException.
     */

    public boolean sortedArrayAdd(Long element) throws SortingArrayLongException{
        return (this.sortedarray).add(element);
    }

    /**
    *
    *@return : this method return my sortedarray.
    */

    public ArrayList<Long> getSortedArray(){
        return (this.sortedarray);
    }

    /**
    *  this methods set sortedarray in a new array.
    * @param sort : new structure.
    */

    public void setSortedArray(ArrayList<Long> sort){
        sortedarray = sort;
    }

    /**
     * @param position: the position of interested element.
     * @throws SortingArrayException: if and only if the index passed by parameter not respect the range of structure.
     * @return : this methods return an element in the position given by parameter
     */

    public Long getSortingArrayElement(int position) throws SortingArrayLongException{
        if (position < 0  || position > sortedArraySize())
            throw new SortingArrayLongException("this index : " + position + "is out of bounds");
        return ((this.sortedarray).get(position));
    }

     /**
     * @param position: the position into insert the element.
     * @param element : the new element.
     * @throws SortingArrayException: if and only if the index passed by parameter not respect the range of structure.
     * @return : this methods return an element in the position given by parameter
     */

    public Long setSortingArrayElement(int position,Long element) throws SortingArrayLongException{
        if(position < 0 || position > sortedArraySize())
            throw new SortingArrayLongException("this index : " + position + "is out of bounds");
        return (this.sortedarray).set(position,element);
    }


     /**
     *  this methods print sortedarray.
     */

    public void print(){
        for(Long elem : sortedarray)
            System.out.println(elem + " ");
    }

    /**
    *
    * Wrapper
    * @throws SortingArrayLongException.
    */

    public void mergeSort() throws SortingArrayLongException{
        mergeSort(0,sortedArraySize()-1);
    }//wrapp

    /**
    * It order the array with the Mergesort algorithm.
    * @param left: is the position of first element; 
    * @param right: is the position of the last element
    * @throws SortingArrayLongException.
    */

    private void mergeSort(int left, int right) throws SortingArrayLongException{
        if(left < right){
            int medium_point = (left + right)/2;
            mergeSort(left,medium_point);
            mergeSort(medium_point +1,right);
            merge(left,medium_point,right);

        }
    }//mergeSort

    /**
    * @param left : is the position of first element
    * @param medium_point : is the medium_point of array.
    * @param right : is the position of the last element
    * @throws SortingArrayLongException.
    */
 
    private void merge(int left, int medium_point, int right) throws SortingArrayLongException{
        int i = left, j = medium_point + 1,k = 0;

        ArrayList<Long> tmp = new ArrayList<Long>(right-left+1);

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