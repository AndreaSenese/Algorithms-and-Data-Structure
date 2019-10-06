package sorting.sumintegers;
import java.util.ArrayList;
import java.util.Comparator;
import sorting.SortingArrayLongException;
import sorting.SortingArrayLong;

/**
 * @author Senese Andrea
 */


public class SumIntegers extends SortingArrayLong{


		/**
		* This is the initiator of the class.
		* Create the new sumIntegers Object.
		* @param element: is the element that you will have to look for.
    	*/

	 	public SumIntegers(Comparator <Long> comparator){
        	super(comparator);
    	}//initiator


		/**
		* This is the wrapper.
		* @param element: is the element that you will have to look for.
		* @throws SortingArrayLongException.
    	*/

		public void sumIntegers(Long element) throws SortingArrayLongException{
			sumIntegersOriginal(element); 
		}//Wrapp


		/**
		* This method saved into a variable the first element and call the binary search for search the second element. The sums of this element is the element passed by reference.
		* @param element: is the element that you will have to look for.
		* @throws SortingArrayLongException.
    	*/


		public void sumIntegersOriginal(Long element) throws SortingArrayLongException {
			int trovato = 0;
			boolean stop = false;
			boolean max = false;
			long a = 0;
			Long elem;
			int index = 0;
			for(int i = 0; i < sortedArraySize() && !stop; i++){
			 	
			 	if(element.longValue()  > getSortingArrayElement(i).longValue()){
			 		a = element.longValue() - getSortingArrayElement(i).longValue();
			 		index = i;
			 		elem = new Long(a);
			 		trovato = binarySearchElementOfSum(elem,0,sortedArraySize()-1,index);
			 		max = true;
			 	}else 
			 		max = false;

			 	if(trovato >= 0 && max) {
			 		System.out.println(element.longValue() + " = " + getSortingArrayElement(trovato).longValue() 
			 			+ " + " + getSortingArrayElement(i).longValue());
			 		stop = true;
			 	}
			}if(stop == false) System.out.println("NOT FOUND THE SECOND ELEMENT");
		}

		/**
		* This method is the binarysearch. Takes a key for parameters and breaking the array in two part 
		* for search this key.
		* @param key: is the element that you will have to look for.
		* @param p : is the first position of array;
		* @param r : is the last position of array
		* @param index : allows not to add the same element with itself.
		* @throws SortingArrayLongException.
    	*/

		private int binarySearchElementOfSum(Long key,int p, int r,int index) throws SortingArrayLongException {
			int q = 0,s = -1;
			if(p <= r){
				q = (p + r)/2;
				//System.out.println(p + " " + q + " " + r);
				if((this.comparator).compare(key,getSortingArrayElement(q)) < 0)
					s = binarySearchElementOfSum(key,p,q-1,index);
				else if((this.comparator).compare(key,getSortingArrayElement(q)) > 0)
					s = binarySearchElementOfSum(key,q+1,r,index);
				else if((this.comparator).compare(key,getSortingArrayElement(q)) == 0){
					if(index != q)
						return q;
				}
			}return s;
		}


		/**
		*
		* COPY OF METHOD USED ONLY FOR JUNIT TEST
		* @param element : the element interested to research.
		* @throws SortingArrayLongException.
		* @return the array with the element interested.
		*/

		
		public long[] sumIntegersTest(Long element) throws SortingArrayLongException {
			int trovato = 0;
			boolean stop = false;
			boolean max = false;
			long a = 0;
			Long elem;
			int index = 0;
			long[] array = null;
			for(int i = 0; i < sortedArraySize() && !stop; i++){
			 	
			 	if(element.longValue()  > getSortingArrayElement(i).longValue()){
			 		a = element.longValue() - getSortingArrayElement(i).longValue();
			 		index = i;
			 		elem = new Long(a);
			 		trovato = binarySearchElementOfSum(elem,0,sortedArraySize()-1,index);
			 		max = true;
			 	}else 
			 		max = false;

			 	if(trovato >= 0 && max) {
			 			array = new long[2];
			 			array[0] = getSortingArrayElement(trovato).longValue();
			 			array[1] = getSortingArrayElement(i).longValue();
			 			return array;
			 	}
			}return array;
		}
}
