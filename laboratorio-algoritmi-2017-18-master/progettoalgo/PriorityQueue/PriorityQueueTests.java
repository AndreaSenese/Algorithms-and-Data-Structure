package PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator; 

			

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
	
	public class PriorityQueueTests{
		
			class DoubleComparator implements Comparator<Double>{
				@Override
				public int compare(Double i1, Double i2){
					return i1.compareTo(i2);
				}
			}//inner class
	

			private GenericElement<Double,Double> i1, i2, i3;
			private PriorityQueue<Double,Double> queue;

			@Before //before each tests
			public void FibqueueTests(){
				i1 = new GenericElement<>(new Double(2),new Double(2));
				i2 = new GenericElement<>(new Double(3),new Double(3));
				i3 = new GenericElement<>(new Double(4),new Double(4));
				queue = new PriorityQueue<Double,Double>(new DoubleComparator());
			}

			@Test
			public void testIsEmpty_zeroEl(){
				assertTrue(queue.isEmpty());
			}

			@Test
			public void testIsNotEmpty_oneEl() throws Exception{
				queue.queueInsert(i1);
				assertFalse(queue.isEmpty());
			}


			@Test
			public void testSize_zero(){
				assertEquals(0,queue.queueSize());
			}

			@Test
			public void testSize_oneEl() throws Exception{
				queue.queueInsert(i1);
				assertEquals(1,queue.queueSize());
			}

			@Test
			public void testSize_twoEl() throws Exception{
				queue.queueInsert(i1);
				queue.queueInsert(i2);
				assertEquals(2,queue.queueSize());
			}


			@Test
			public void testMethod_Parent() throws Exception{
				queue.queueInsert(i1);
				queue.queueInsert(i3);
				queue.queueInsert(new GenericElement<>(new Double(1),new Double(1)));
				queue.queueInsert(new GenericElement<>(new Double(9),new Double(9)));
				queue.queueInsert(new GenericElement<>(new Double(19),new Double(19)));
				queue.queueInsert(new GenericElement<>(new Double(29),new Double(29)));
				queue.queueInsert(new GenericElement<>(new Double(15),new Double(15)));
				queue.queueInsert(new GenericElement<>(new Double(10),new Double(10)));
				queue.queueInsert(new GenericElement<>(new Double(11),new Double(11)));
			

				assertEquals(queue.queueParent(1),queue.queueParent(2));
			} 

			@Test
			public void testStructure_EqualsWithHepifyandInsert() throws Exception{
				PriorityQueue<Double,Double> que = queue;
				queue.queueInsert(i1);
				queue.queueInsert(i3);
				queue.queueInsert(new GenericElement<>(new Double(1),new Double(1)));
				queue.queueInsert(new GenericElement<>(new Double(9),new Double(9)));
				queue.queueInsert(new GenericElement<>(new Double(19),new Double(19)));
				queue.queueInsert(new GenericElement<>(new Double(29),new Double(29)));
				queue.queueInsert(new GenericElement<>(new Double(15),new Double(15)));
				queue.queueInsert(new GenericElement<>(new Double(10),new Double(10)));
				queue.queueInsert(new GenericElement<>(new Double(11),new Double(11)));
				que.queueInsert(new GenericElement<>(new Double(29),new Double(29)));
				que.queueInsert(new GenericElement<>(new Double(1),new Double(11)));
				que.queueInsert(new GenericElement<>(new Double(2),new Double(19)));
				que.queueInsert(new GenericElement<>(new Double(3),new Double(10)));
				que.queueInsert(new GenericElement<>(new Double(4),new Double(4)));
				que.queueInsert(new GenericElement<>(new Double(1),new Double(1)));
				que.queueInsert(new GenericElement<>(new Double(15),new Double(15)));
				que.queueInsert(new GenericElement<>(new Double(2),new Double(2)));
				que.queueInsert(new GenericElement<>(new Double(9),new Double(9)));
				assertEquals(que.queuegetStruct(),queue.queuegetStruct());
			
			}

			@Test
			public void testGetMax() throws Exception{
				queue.queueInsert(i1);
				queue.queueInsert(i3);
				queue.queueInsert(new GenericElement<>(new Double(1),new Double(1)));
				queue.queueInsert(new GenericElement<>(new Double(9),new Double(9)));
				queue.queueInsert(new GenericElement<>(new Double(19),new Double(19)));
				queue.queueInsert(new GenericElement<>(new Double(29),new Double(29)));
				queue.queueInsert(new GenericElement<>(new Double(15),new Double(15)));
				queue.queueInsert(new GenericElement<>(new Double(10),new Double(10)));
				queue.queueInsert(new GenericElement<>(new Double(11),new Double(11)));
				assertEquals(queue.queueGet(0).getElem(),queue.getMin().getElem());
			}

			@Test
			public void testchangeKey() throws Exception{
				queue.queueInsert(i1);
				queue.queueInsert(i3);
				queue.queueInsert(new GenericElement<>(new Double(1),new Double(1)));
				queue.queueInsert(new GenericElement<>(new Double(9),new Double(9)));
				queue.queueInsert(new GenericElement<>(new Double(19),new Double(19)));
				queue.queueInsert(new GenericElement<>(new Double(29),new Double(29)));
				queue.queueInsert(new GenericElement<>(new Double(15),new Double(15)));
				queue.queueInsert(new GenericElement<>(new Double(10),new Double(10)));
				queue.queueInsert(new GenericElement<>(new Double(11),new Double(11)));
				queue.changeKey(i1,new Double(7));
				assertEquals(new Double(7),queue.queueGet(2).getElem());
				queue.changeKey(i3,new Double(100));
				assertEquals(new Double(100),queue.queueGet(1).getElem());
			}

			@Test
			public void testchangePriority() throws Exception{
				queue.queueInsert(i1);
				queue.queueInsert(i3);
				queue.queueInsert(new GenericElement<>(new Double(1),new Double(1)));
				queue.queueInsert(new GenericElement<>(new Double(9),new Double(9)));
				queue.queueInsert(new GenericElement<>(new Double(21),new Double(21)));
				queue.queueInsert(new GenericElement<>(new Double(29),new Double(29)));
				queue.queueInsert(new GenericElement<>(new Double(15),new Double(15)));
				queue.queueInsert(new GenericElement<>(new Double(10),new Double(10)));
				queue.queueInsert(new GenericElement<>(new Double(11),new Double(11)));
				queue.changePriority(i3,new Double(100));
				assertEquals(new Double(100),queue.queueGet(7).getPriority());
				queue.changePriority(i1,new Double(0.95));
				assertEquals(new Double(0.95),queue.queueGet(0).getPriority());
				assertEquals(new Double(2),queue.queueGet(0).getElem());
			}
}
