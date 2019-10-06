package sorting.mergesort;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
/**
 *
 * @author Senese Andrea
 */
public class MergeSort_TestsRunner{
    /**
     * @param args : the command line arguments
     */
    public static void main(String[] args){
        Result result = JUnitCore.runClasses(MergeSortTests.class);
        for(Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    } //main
} //class