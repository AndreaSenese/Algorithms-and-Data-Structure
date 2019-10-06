package sorting.sumintegers;

import java.util.ArrayList;
import java.util.Comparator;

import sorting.SortingArrayLong;

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

public class SumIntegersTests{
	
	class LongComparator implements Comparator<Long>{
		@Override
		public int compare(Long i1, Long i2){
			return i1.compareTo(i2);
		}
	}//inner class

	private Long i1, i2, i3;
	private SumIntegers sumint;
	
	@Before //before each tests
	public void InsertionSortTests(){
		i1 = new Long(2);
		i2 = new Long(0);
		i3 = new Long(4);
		sumint = new SumIntegers(new LongComparator());
	}
	@Test
	public void testIsEmpty_zeroEl(){
		assertTrue(sumint.getSortedArray().isEmpty());
	}

	@Test
	public void testIsEmpty_oneEl() throws Exception{
		sumint.getSortedArray().add(i1);
		assertFalse(sumint.getSortedArray().isEmpty());
	}
	
	@Test
	public void testSize_zero(){
		assertEquals(0,sumint.getSortedArray().size());
	}

	
	@Test
	public void testSize_oneEl() throws Exception{
		sumint.getSortedArray().add(i1);
		assertEquals(1,sumint.getSortedArray().size());
	}

	@Test
	public void testSize_twoEl() throws Exception{
		sumint.getSortedArray().add(i1);
		sumint.getSortedArray().add(i2);
		assertEquals(2,sumint.getSortedArray().size());
	}
	
	@Test
	public void testAddGet_oneEl() throws Exception{
		sumint.getSortedArray().add(i1);
		assertTrue(i1 == sumint.getSortedArray().get(0));
	}
	@Test
	public void testArray_threeEl() throws Exception{
		
		sumint.getSortedArray().add(i1);
		sumint.getSortedArray().add(i2);
		sumint.getSortedArray().add(i3);

		Long[] arrExpected = {i1, i2, i3};
		
		Long[] arrActual = new Long[3];
		
		for(int i=0; i<3; i++){
			arrActual[i] = sumint.getSortedArray().get(i);
		}
			
		assertArrayEquals(arrActual, arrExpected);
	}

	@Test
	public void testSearch_Elem() throws Exception{
		long tmp = i1.longValue();
		Long cent = new Long(tmp/2);
		sumint.getSortedArray().add(cent);
		sumint.getSortedArray().add(cent);
		long[] array = sumint.sumIntegersTest(i1);
		long temp = 0;
		for(int i = 0; i < array.length; i++){
			temp += array[i];
		}
		if(array != null)
			assertEquals(i1.longValue(),temp);
	}
	
} // class