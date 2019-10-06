package editdistancedyn;
import java.lang.Math;

/**
 *
 * @author Senese Andrea
 *
 */

public class Edit_Distance_Dyn {


  /**
  *This is a Dynamic approach of edit_distance algorithms.
  * This methods implements one matrix to reduce the repetition with dynamic approach(not recalculate the subproblem previously encountered).
  * @param 1 : <String s1> : word on file correctme.
  * @param 2: <String s2> : word on file dictionary.
  */


  public static int distance(String s1, String s2) {
    int gaps1, gaps2, sub;
	int[][] table = new int[s1.length() + 1][s2.length() + 1];

		//Inizialized
		table[0][0] = 0;
		for (int i = 1; i <= s1.length(); i++)
			table[i][0] = table[i - 1][0] + 1;
		for (int j = 1; j <= s2.length(); j++)
			table[0][j] = table[0][j - 1] + 1;

		//New Table
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (Character.toLowerCase(s1.charAt(i - 1)) == Character.toLowerCase(s2.charAt(j - 1)))
					//Use Character.toLowerCase because the virtual machine of java considers "2" the  distance between maius e minusc
					sub = table[i - 1][j - 1];		
				else
					sub = Integer.MAX_VALUE;
				
				gaps1 = table[i][j - 1] + 1;	
				gaps2 = table[i - 1][j] + 1;	
		
				table[i][j] = Math.min(Math.min(gaps1, gaps2), sub);
			}
		}
		return table[s1.length()][s2.length()];	
	}
}
