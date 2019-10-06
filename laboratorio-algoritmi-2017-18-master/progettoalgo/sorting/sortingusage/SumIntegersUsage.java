package sorting.sortingusage;

/**
*
*import mie
*
*/
import sorting.sortingusage.RecordSortingLong;
import sorting.sumintegers.SumIntegers;
import sorting.SortingArrayLongException;
import sorting.SortingArrayLong;

/**
*
*import java
*
*/

import java.io.BufferedReader; 
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Senese Andrea
 *
 */
public class SumIntegersUsage {
  
  static class LongComparator implements Comparator<Long>{
    @Override
    public int compare(Long i1, Long i2){
      return i1.compareTo(i2);
    }
  }

  private static final Charset ENCODING = StandardCharsets.UTF_8;


  private static void loadArray(String filepath, SumIntegers sortedarray) throws IOException, SortingArrayLongException{
    System.out.println("\nLoading data from file for insert into sortedarray...\n");
    
    Path inputFilePath = Paths.get(filepath);
    try(BufferedReader fileInputReader = Files.newBufferedReader(inputFilePath, ENCODING)){
      String line = null;
      while((line = fileInputReader.readLine()) != null){      
        String[] lineElements = line.split(",");       
        Long record1 = Long.parseLong(lineElements[0]);
        sortedarray.sortedArrayAdd(record1);
      }
    } 
    System.out.println("\nData loaded\n");
  }


  private static void printArray(SumIntegers sortedarray) throws SortingArrayLongException{
    Long currRec;
    int sizeArr;
    
    System.out.println("\nORDERED ARRAY OF RECORDS\n");
    sizeArr = sortedarray.sortedArraySize();
    for(int i=0;i < sizeArr;i++){
      currRec = sortedarray.getSortingArrayElement(i);
      System.out.println("<" + currRec.longValue() + ">\n");
    }
  }

  private static void testWithComparisonFunction(String integers,String sums, Comparator<Long> comparator) throws IOException, SortingArrayLongException{
    SumIntegers sortedarray = new SumIntegers(comparator);
    loadArray(sums,sortedarray);
    SumIntegers sort = new SumIntegers(comparator);
    loadArray(integers,sort);
    sort.mergeSort();
    for(int size = 0; size < sort.sortedArraySize() && size < sortedarray.sortedArraySize(); size++)
        sort.sumIntegers(sortedarray.getSortingArrayElement(size));
  }


  /**
   * @param args the command line arguments. It should contain only one argument
   * specifying the filepath of the data file
   */
  public static void main(String[] args) throws IOException, SortingArrayLongException, Exception {
    if(args.length < 1)
      throw new Exception("Usage: InsertionSortUsage <file_name>");
    testWithComparisonFunction(args[0],args[1], new LongComparator());
  } 
}
