package sorting.sortingusage;
import sorting.sortingusage.RecordSorting;
import java.util.Comparator;

/**
 *
 * @author Senese Andrea
 */

    public class RecordSortingLong implements Comparator<RecordSorting> {
        @Override
        public int compare(RecordSorting r1, RecordSorting r2) {
       		return  (new Long(r1.getRecordLong())).compareTo(r2.getRecordLong());
           
        } //compare
    }
