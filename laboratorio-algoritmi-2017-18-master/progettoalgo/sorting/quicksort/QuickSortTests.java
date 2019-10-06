package sorting.quicksort;

import java.util.ArrayList;
import java.util.Comparator; 
import sorting.SortingArray;
import sorting.mergesort.MergeSort;

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

public class QuickSortTests{
	
	class LongComparator implements Comparator<Long>{
		@Override
		public int compare(Long i1, Long i2){
			return i1.compareTo(i2);
		}
	}//inner class

	private Long i1, i2, i3;
	private QuickSort<Long> quicksort;
	
	@Before //before each tests
	public void InsertionSortTests(){
		i1 = new Long(2);
		i2 = new Long(0);
		i3 = new Long(4);
		quicksort = new QuickSort<>(new LongComparator());
	}
	@Test
	public void testIsEmpty_zeroEl(){
		assertTrue(quicksort.getsortedArray().isEmpty());
	}

	@Test
	public void testIsEmpty_oneEl() throws Exception{
		quicksort.getsortedArray().add(i1);
		assertFalse(quicksort.getsortedArray().isEmpty());
	}
	
	@Test
	public void testSize_zero(){
		assertEquals(0,quicksort.getsortedArray().size());
	}

	
	@Test
	public void testSize_oneEl() throws Exception{
		quicksort.getsortedArray().add(i1);
		assertEquals(1,quicksort.getsortedArray().size());
	}
	
	@Test
	public void testSize_twoEl() throws Exception{
		quicksort.getsortedArray().add(i1);
		quicksort.getsortedArray().add(i2);
		assertEquals(2,quicksort.getsortedArray().size());
	}
	
	@Test
	public void testAddGet_oneEl() throws Exception{
		quicksort.getsortedArray().add(i1);
		assertTrue(i1 == quicksort.getsortedArray().get(0));
	}
	
	@Test
	public void testArray_threeEl() throws Exception{
		
		quicksort.getsortedArray().add(i1);
		quicksort.getsortedArray().add(i2);
		quicksort.getsortedArray().add(i3);
		
		quicksort.quickSort();
		
		Long[] arrExpected = {i2, i1, i3};
		
		Long[] arrActual = new Long[3];
		
		for(int i=0; i<3; i++){
			arrActual[i] = quicksort.getsortedArray().get(i);
		}
			
		assertArrayEquals(arrActual, arrExpected);
	}
}