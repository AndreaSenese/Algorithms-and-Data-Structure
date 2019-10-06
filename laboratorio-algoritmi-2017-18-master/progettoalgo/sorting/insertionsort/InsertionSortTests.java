package sorting.insertionsort;

import java.util.ArrayList;
import java.util.Comparator; 
import sorting.SortingArray;

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

public class InsertionSortTests{
	
	class LongComparator implements Comparator<Long>{
		@Override
		public int compare(Long i1, Long i2){
			return i1.compareTo(i2);
		}
	}//inner class

	private Long i1, i2, i3;
	private InsertionSort<Long> insertionsort;
	
	@Before //before each tests
	public void InsertionSortTests(){
		i1 = new Long(2);
		i2 = new Long(0);
		i3 = new Long(4);
		insertionsort = new InsertionSort<>(new LongComparator());
	}
	@Test
	public void testIsEmpty_zeroEl(){
		assertTrue(insertionsort.getsortedArray().isEmpty());
	}

	@Test
	public void testIsEmpty_oneEl() throws Exception{
		insertionsort.getsortedArray().add(i1);
		assertFalse(insertionsort.getsortedArray().isEmpty());
	}
	
	@Test
	public void testSize_zero(){
		assertEquals(0,insertionsort.getsortedArray().size());
	}

	
	@Test
	public void testSize_oneEl() throws Exception{
		insertionsort.getsortedArray().add(i1);
		assertEquals(1,insertionsort.getsortedArray().size());
	}
	
	@Test
	public void testSize_twoEl() throws Exception{
		insertionsort.getsortedArray().add(i1);
		insertionsort.getsortedArray().add(i2);
		assertEquals(2,insertionsort.getsortedArray().size());
	}
	
	@Test
	public void testAddGet_oneEl() throws Exception{
		insertionsort.getsortedArray().add(i1);
		assertTrue(i1 == insertionsort.getsortedArray().get(0));
	}
	
	@Test
	public void testArray_threeEl() throws Exception{
		
		insertionsort.getsortedArray().add(i1);
		insertionsort.getsortedArray().add(i2);
		insertionsort.getsortedArray().add(i3);
		
		insertionsort.insertion_Sort();
		
		Long[] arrExpected = {i2, i1, i3};
		
		Long[] arrActual = new Long[3];
		
		for(int i=0; i<3; i++){
			arrActual[i] = insertionsort.getsortedArray().get(i);
		}
			
		assertArrayEquals(arrActual, arrExpected);
	}
	
	
} // class