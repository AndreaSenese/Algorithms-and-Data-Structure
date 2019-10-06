package sorting.quicksort;
import java.util.ArrayList;
import java.util.Comparator;
import sorting.SortingArrayException;
import sorting.SortingArray;
import java.util.Random;
/**
 * @author Senese Andrea
 * @param <T>: type of sorted array elements
 */


public class QuickSort<T> extends SortingArray<T> {
    /**
     * It creates an empty ordered array and returns the created array.
     * It accepts as input a comparator implementing the precedence raltion between the array elements.
     * @param comparator: a comparator implementing the precedence relation between the array elements
     */
    public QuickSort(Comparator<? super T> comparator) {
        super(comparator);
    } // QuickSort

    /**
    *
    *   Wrapper
    */
    public void quickSort(){
        quickSort(0,sortedArraySize()-1);
    }
    /**
     * It order the array with the quicksort algorithm.
     * @param start: the position of the first element
     * @param end: the position of the last element
     */
    private void quickSort(int start, int end) {
        int q;

        if(start < end){
            q = partition(start, end);
            quickSort(start, q);
            quickSort(q + 1, end);
        }
    } // quickSort

    /**
     * It divides the array into two subarray where all the elements to the left of q
     * are less than or equal to all the elements to the right of q.
     * @param start: the position of the first element
     * @param end: the position of the last element
     * @return the interested index of structure.
     */
    private int partition(int start, int end) {
        int init = start;
        int length = end;

        Random r = new Random();
        int pivotIndex = nextIntInRange(start, end, r);
        T pivot = (this.sortedarray).get(pivotIndex);

        while (true) {
            while ((this.comparator).compare((this.sortedarray).get(length), pivot) > 0 && length > start){
                length--;
            }
            while ((this.comparator).compare((this.sortedarray).get(init), pivot) < 0 && init < end){
                init++;
            }
            if (init < length) {
                swap(init, length);
                length--;
                init++;
            } else {
                return length;
            }
        }
    } // partition

    /**
     * It find random integer from given range.
     * @param min: the position of the first element
     * @param max: the position of the last element
     * @param range: a stream of pseudorandom numbers
     * @return the index of end range.
     */
    public static int nextIntInRange(int min, int max, Random range) {
        if (min > max) {
            throw new IllegalArgumentException("Invalid range for random int: [" + min + ", " + max + "].");
        }

        int diff = max - min;

        if (diff >= 0 && diff != Integer.MAX_VALUE) {
            return (min + range.nextInt(diff + 1));
        }

        int i;

        do {
            i = range.nextInt();
        } while (i < min || i > max);

        return i;
    } // nextIntInRange

    /**
     * It swaps two elements in the array.
     * @param init: the position of the first element
     * @param length: the position of the second element
     */
    public void swap(int init, int length) {
        T temp = (this.sortedarray).get(init);
        (this.sortedarray).set(init, (this.sortedarray).get(length));
        (this.sortedarray).set(length, temp);
    } // swap
}
