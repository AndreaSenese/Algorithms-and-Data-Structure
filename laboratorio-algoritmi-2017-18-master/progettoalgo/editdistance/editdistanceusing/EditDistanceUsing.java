package editdistanceusing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import editdistancedyn.Edit_Distance_Dyn;

/**
*
* @author Andrea Senese
*
*/

public class EditDistanceUsing {
    
  private static int countElements(String filepath) {
    File file = new File(filepath);
    int count=0;
    try {
      Scanner sc = new Scanner (file);
        for (; sc.hasNext(); count++)
          sc.next();
        sc.close();
      } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return count;
  }

  private static String[] loadStrings(String filepath) throws IOException {
    System.out.println("Loading data from file "+filepath+"\n");
    String[] tmp=new String[countElements(filepath)];
    File file = new File(filepath);
    try {
      Scanner sc = new Scanner (file);
      for (int i=0; sc.hasNext(); i++)
        tmp[i] = sc.next();
      sc.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    System.out.println("Data loaded");
    return tmp;
  }
  
  private static void testWithComparisonFunction(String filepath1, String filepath2) throws IOException {
    String[] dictionary;
    String[] correct;

    //Caricamento Stringhe
    dictionary=loadStrings(filepath1);
    correct=loadStrings(filepath2);

    //Scorro tutte le parole che devo analizzare
    for (int i=0, dist_min=Integer.MAX_VALUE; i<correct.length; i++, dist_min=Integer.MAX_VALUE) {
      System.out.println("\n\nPer la parola '"+correct[i]+"': ");
      //Confronto la singola stringa w con tutte quelle nel dictionary e trovo la dist_mi
      for (int j=0; j<dictionary.length; j++) {
        int tmp=(Edit_Distance_Dyn.distance(correct[i], dictionary[j]));
        if (tmp<dist_min) dist_min=tmp;
      }
      //Stampo solo quelle con la dist_min
      for (int j=0; j<dictionary.length; j++) {
        if (Edit_Distance_Dyn.distance(correct[i], dictionary[j])==dist_min)
          System.out.print(dictionary[j]+", ");
      }
    }
    System.out.println("-------Finito!-------");
  }
  
  public static void main(String[] args) throws IOException {
    if(args.length == 2)
      testWithComparisonFunction(args[0], args[1]);
  }  
    
}
