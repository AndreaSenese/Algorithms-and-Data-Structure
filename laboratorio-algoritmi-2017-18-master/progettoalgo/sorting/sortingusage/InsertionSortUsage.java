package sorting.sortingusage;

/**
*
*import mie
*
*/
import sorting.sortingusage.RecordSorting;
import sorting.sortingusage.RecordSortingLong;
import sorting.insertionsort.InsertionSort;
import sorting.SortingArrayException;


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

/**
 * 
 * @author Senese Andrea
 *
 */

public class InsertionSortUsage {
  
  private static final Charset ENCODING = StandardCharsets.UTF_8;


  private static void loadArray(String filepath, InsertionSort<RecordSorting> sortedarray) throws IOException, SortingArrayException{
    System.out.println("\nLoading data from file...\n");
    
    Path inputFilePath = Paths.get(filepath);
    try(BufferedReader fileInputReader = Files.newBufferedReader(inputFilePath, ENCODING)){
      String line = null;
      while((line = fileInputReader.readLine()) != null){      
        String[] lineElements = line.split(",");       
        RecordSorting record1 = new RecordSorting(Long.parseLong(lineElements[0]));
        sortedarray.sortedArrayAdd(record1);
      }
    } 
    System.out.println("\nData loaded\n");
  }
  
  private static void printArray(InsertionSort<RecordSorting> sortedarray) throws SortingArrayException{
    RecordSorting currRec = null;
    int sizeArr;
    
    System.out.println("\nORDERED ARRAY OF RECORDS\n");
    sizeArr = sortedarray.sortedArraySize();
    for(int i=0;i < sizeArr;i++){
      currRec = sortedarray.getSortingArrayElement(i);
      System.out.println("<"+currRec.getRecordLong()+">\n");
    }
  }

  
  private static void testWithComparisonFunction(String filepath, Comparator<RecordSorting> comparator) throws IOException, SortingArrayException{
    InsertionSort<RecordSorting> sortedarray = new InsertionSort<>(comparator);
    loadArray(filepath,sortedarray);
    sortedarray.insertion_Sort();
    printArray(sortedarray);
  }
  
  /**
   * @param args the command line arguments. It should contain only one argument
   * specifying the filepath of the data file
   */
  public static void main(String[] args) throws IOException, SortingArrayException, Exception {
    if(args.length < 1)
      throw new Exception("Usage: InsertionSortUsage <file_name>");
    
    testWithComparisonFunction(args[0],new RecordSortingLong());
  }  
}
