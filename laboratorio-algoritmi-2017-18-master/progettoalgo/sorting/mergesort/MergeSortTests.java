package sorting.mergesort;

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

public class MergeSortTests{
	
	class LongComparator implements Comparator<Long>{
		@Override
		public int compare(Long i1, Long i2){
			return i1.compareTo(i2);
		}
	}//inner class

	private Long i1, i2, i3;
	private MergeSort<Long> mergesort;
	
	@Before //before each tests
	public void InsertionSortTests(){
		i1 = new Long(2);
		i2 = new Long(0);
		i3 = new Long(4);
		mergesort = new MergeSort<>(new LongComparator());
	}
	@Test
	public void testIsEmpty_zeroEl(){
		assertTrue(mergesort.getsortedArray().isEmpty());
	}

	@Test
	public void testIsEmpty_oneEl() throws Exception{
		mergesort.getsortedArray().add(i1);
		assertFalse(mergesort.getsortedArray().isEmpty());
	}
	
	@Test
	public void testSize_zero(){
		assertEquals(0,mergesort.getsortedArray().size());
	}

	
	@Test
	public void testSize_oneEl() throws Exception{
		mergesort.getsortedArray().add(i1);
		assertEquals(1,mergesort.getsortedArray().size());
	}
	
	@Test
	public void testSize_twoEl() throws Exception{
		mergesort.getsortedArray().add(i1);
		mergesort.getsortedArray().add(i2);
		assertEquals(2,mergesort.getsortedArray().size());
	}
	
	@Test
	public void testAddGet_oneEl() throws Exception{
		mergesort.getsortedArray().add(i1);
		assertTrue(i1 == mergesort.getsortedArray().get(0));
	}
	
	@Test
	public void testArray_threeEl() throws Exception{
		
		mergesort.getsortedArray().add(i1);
		mergesort.getsortedArray().add(i2);
		mergesort.getsortedArray().add(i3);
		
		mergesort.mergeSort();
		
		Long[] arrExpected = {i2, i1, i3};
		
		Long[] arrActual = new Long[3];
		
		for(int i=0; i<3; i++){
			arrActual[i] = mergesort.getsortedArray().get(i);
		}
			
		assertArrayEquals(arrActual, arrExpected);
	}
}