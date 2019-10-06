/**
 * @author Senese Andrea
 */

public class EditDistance{


		/**
		* This methods is the editDistance_not_Dynamic , calculate the minimum distance of two string. This is a Wrapper of a method. 
		* @param s : the first string
		* @param r : the second string
		*/

		public static int editDistance(String s, String r){
			return edit(s,r);
		}

		/**
		* This methods is the editDistance_not_Dynamic , calculate the minimum distance of two string. 
		* @param s : the first string
		* @param r : the second string
		*/


		private static int edit(String s,String r){
			if(s.length() == 0)
				return r.length();
			else if(r.length() == 0)
				return s.length();
			int nop;
			if(s.charAt(0) == r.charAt(0))
				nop = edit(s.substring(1),r.substring(1));
			else
				nop = Integer.MAX_VALUE;
			int dcanc = 1 + edit(s,r.substring(1));
			int dins = 1 + edit(s.substring(1),r);
			return mindistance(mindistance(nop,dcanc),dins);
			
		}

		private static int mindistance(int slength, int rlength){
			return (slength < rlength) ? slength : rlength;
		}

}	

