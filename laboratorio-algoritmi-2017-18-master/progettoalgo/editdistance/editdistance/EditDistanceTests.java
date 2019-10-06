package editdistance;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Senese Andrea
 */

public class EditDistanceTests{
	
	private char i1, i2, i3;
	private String s1;
	

	/**
	*
	*
	* L'ho dovuto includere qui perche se provo ad accedere alla classe EDITDISTANCE 
	* mi dice "Cannot access in the class EditDistance".
	*
	*/
	public static int editDistance(String s, String r){
		return edit(s,r);
	}


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

	@Before //before each tests
	public void editDistanceTests(){
		i1 = 'c';
		i2 = 'i';
		i3 = 'p';
		s1 = new String();
	}
	@Test
	public void testIsEmpty_zeroEl(){
		assertTrue(s1.isEmpty());
	}


	@Test
	public void testIsEmpty_oneEl() throws Exception{
		char[] tmp = {i1};
		s1 = new String(tmp);
		assertFalse(s1.isEmpty());
	}
	
	@Test
	public void testSize_zero(){
		assertEquals(0,s1.length());
	}


	@Test
	public void testSize_oneEl() throws Exception{
		char[] tmp = {i1};
		s1 = new String(tmp);
		assertEquals(1,s1.length());
	}
	@Test
	public void testSize_twoEl() throws Exception{
		char[] tmp = {i1,i2};
		s1 = new String(tmp);
		assertEquals(2,s1.length());
	}
	
	@Test
	public void testAddGet_oneEl() throws Exception{
		char[] tmp = {i1};
		s1 = new String(tmp);
		assertTrue(i1 == s1.charAt(0));
	}
	
	@Test
	public void testArray_threeEl() throws Exception{
		char[] tmp = {i1,i2,i3};
		s1 = new String(tmp);

		String s2 = new String(tmp);

		int edit = editDistance(s1,s2);
	
		assertEquals(s1.length() - edit, s1.length());
	}


}	

