package PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator; //define relationship into a priorityQueue structure.
import java.lang.Math;

/**
* @author : Andrea Senese
* @param <GenericElement> : type of priorityQueue elements.
* @param <E> : Generic type of element. 
* @param <P> : Generic type of Priority.
*/


	public class PriorityQueue<E,P>{

		protected ArrayList<GenericElement<E,P>> priorityQueue; // Generic priorityQueue.
		protected Comparator<? super P> order_comp; // generic comparator.

		/**
		* Initiator : Inizialized the priorityQueue structure.
		* @param order_comparator :  comparator implementing a relation order of priorityQueue between Generic element.
		*
		*/

		public PriorityQueue(Comparator<? super P> order_comparator){
			this.priorityQueue = new ArrayList<GenericElement<E,P>>();
			this.order_comp = order_comparator;
		} // priorityQueue Initiator.

		/**
		* This method return true if and only if the structure is Empty.
		* @return true if and only if the structure is Empty.
		*/

		public boolean isEmpty(){
			return (this.priorityQueue).isEmpty();
		}

		/**
		* This method return a priorityQueue structure.
		* @return the structure.
		*/

		public ArrayList<GenericElement<E,P>> queuegetStruct(){
			return this.priorityQueue;
		}

		/**
		* this methods return the element in a current position.
		*@param position : is the position of element
		*@return : the element in position "n".
		*/

		public GenericElement<E,P> queueGet(int position){
			return (this.priorityQueue).get(position);
		}

		/**
		* This method return a min into priorityQueue.
		*@return the min into priorityQueue : "The min into priorityQueue is the root of priorityQueue."
		*/

		public GenericElement<E,P> getMin(){
			return queueGet(0);
		}

		/**
		*
		* This method calcute the previous parent of the current node(this).
		* @param i : index of the current position in order to calculate the parent of this node.
		* @return : the element parents.
		* @throws PriorityQueueException : if and only if the index passed by parameter not respect the range of structure.
		*/
		public GenericElement<E,P> queueParent(int i) throws PriorityQueueException{
			if(i == 0)
				throw new PriorityQueueException("Impossible : Out Of Bounds");
			else
				return queueGet((i - 1)/2);
		}



		/**
		*
		* This method calcute the previous parent of the current node(this).
		* @param i : index of the current position in order to calculate the parent of this node.
		* @return : index_position of parent.
		* @throws PriorityQueueException : if and only if the index passed by parameter not respect the range of structure.
		*/
		public int queueParentPosition(int i) throws PriorityQueueException{
			if(i == 0)
				throw new PriorityQueueException("Impossible : Out Of Bounds");
			else
				return (i - 1)/2;
		}

		/**
		* this method return a size of priorityQueue structure.
		*/

		public int queueSize(){
			return (this.priorityQueue).size();
		}

		/**
		*
		* This method allows you to move to the left side of the priorityQueue.
		* @param i : index of the current position in order to move to the left side of this node.
		* @return : the position of the left son.
		*/

		public int queueLeftSon(int i){
			return (2 * i) + 1 < queueSize() ? (2 * i) + 1 : i;
		}

		/**
		*
		* This method allows you to move to the left side of the priorityQueue.
		* @param i : index of the current position in order to move to the left side of this node.
		* @return : the element in the left position.
		*/

		public GenericElement<E,P> queueLeftSonElem(int i){
			return (2 * i) + 1 < queueSize() ? queueGet((2 * i) + 1) : queueGet(i);
		}

		/**
		*
		* This method allows you to move to the right side of the priorityQueue.
		* @param i : index of the current position in order to move to the right side of this node.
		* @return : the position of the right son.
		*/

		public int queueRightSon(int i){
			return (2 * i) + 2 < queueSize() ? ((2 * i) + 2) : i;
		}

		/**
		*
		* This method allows you to move to the right side of the priorityQueue.
		* @param i : index of the current position in order to move to the right side of this node.
		* @return : the element in the right position.
		*/

		public GenericElement<E,P> queueRightSonElem(int i){
			return (2 * i) + 2 < queueSize() ? queueGet((2 * i) + 2) : queueGet(i);
		}

		/**
		* this methods set the element in a current position(support of swap).
		*@param position : is the position of element.
		*@param elem : the new element of the structure.
		* @throws PriorityQueueException.
		*/

		private void queueSet(int position,GenericElement<E,P> elem) throws PriorityQueueException{
			(this.priorityQueue).set(position,elem);
		}


		/**
		*
		* This method swap the element into priorityQueue.
		* @param priorityQueuePos : given position of element(this).
		* @param queueParentPos: position of parent of (this).
		* @throws PriorityQueueException.
		*/

		
		public void elementSwap(int priorityQueuePos,int queueParentPos)  throws PriorityQueueException{
			GenericElement<E,P> tmp = queueGet(priorityQueuePos);
			queueSet(priorityQueuePos,queueGet(queueParentPos));
			queueSet(queueParentPos,tmp);
    	} //elementSwap	


		/**
		*
		* This method insert the element into priorityQueue.
		* @param elem : insert this element into priorityQueue.
		* @throws PriorityQueueException.
		*/

		public void queueInsert(GenericElement<E,P> elem) throws PriorityQueueException{
			priorityQueue.add(elem);
			int index = priorityQueue.indexOf(elem);
			int i = 0;
			while(index > 0  && (this.order_comp).compare(queueParent(index).getPriority(),queueGet(index).getPriority()) > 0){
				elementSwap(index,queueParentPosition(index));
				index = queueParentPosition(index);
				i++;
			} 
		}

		/**
    	*
    	*This methods decrease the interested element.
    	* @param pos : position of the current element.
    	* @param elem : the new element.
    	* @throws PriorityQueueException : if and only  the key passed by parameter is higher then the current key.
   		*/

    	public void changeKey(GenericElement<E,P> elem, E newElem) throws PriorityQueueException{
    		int pos = queuegetStruct().indexOf(elem);
    		queueGet(pos).setElem(newElem);
    	}

   		/**
    	*
    	*This methods return the index of element with minimum priority.
    	* @param left : position of the leftson element.
    	* @param right : position of the rightson element.
    	*/

    	private int minIndex(int left,int right){
    		if((this.order_comp).compare(queueGet(left).getPriority(),queueGet(right).getPriority()) > 0)
    			return right;
    		else 
    			return left;

    	}

   		/**
    	*
    	*This methods return the element with minimum priority.
    	* @param left : position of the leftson element.
    	* @param right : position of the rightson element.
    	*/


    	private P minPriority(GenericElement<E,P> left, GenericElement<E,P> right){
    		if((this.order_comp).compare(left.getPriority(),right.getPriority()) < 0)
    			return left.getPriority();
    		else if((this.order_comp).compare(left.getPriority(),right.getPriority()) < 0)
    			return right.getPriority();
    		else
    			return right.getPriority();
    	}

   		/**
    	*
    	*This methods delete the minimum into queue.
    	*@throws PriorityQueueException
    	*/

    	public GenericElement<E,P> extractMin() throws PriorityQueueException{
    		if(queueSize() == 0)
    			throw new PriorityQueueException("The queue cannot contain element");
    		GenericElement<E,P> min = queueGet(0);
    		queueSet(0,queueGet(queueSize() - 1));
    		(this.priorityQueue).remove(queueSize() - 1);
    		int pos = 0;
    		int flag = 0;
    		while(pos < queueSize() && (this.order_comp).compare(queueGet(pos).getPriority(),minPriority(queueLeftSonElem(pos),queueRightSonElem(pos))) > 0){
    			flag =  minIndex(queueLeftSon(pos),queueRightSon(pos));
    			elementSwap(pos,minIndex(queueLeftSon(pos),queueRightSon(pos)));
    			pos = flag;
    		}
    		return min;
    	}



   		/**
    	*
    	*This methods changePriority.
    	*@param elem: element to change priority.
    	*@param newPriority : new Priority.
    	*@throws PriorityQueueException
    	*/
    	
    	public void changePriority(GenericElement<E,P> elem, P newPriority) throws PriorityQueueException{
    		if(queueSize() == 0)
    			throw new PriorityQueueException("The queue cannot contain element");
    		else if((this.order_comp).compare(elem.getPriority(),newPriority) < 0){
    			int pos = queuegetStruct().indexOf(elem);
    			int flag = 0;
    			queueGet(pos).setPriority(newPriority);
    			while(pos < queueSize() && (this.order_comp).compare(queueGet(pos).getPriority(), minPriority(queueLeftSonElem(pos),queueRightSonElem(pos))) > 0){
    				flag =  minIndex(queueLeftSon(pos),queueRightSon(pos));
    				elementSwap(pos,minIndex(queueLeftSon(pos),queueRightSon(pos)));
    				pos = flag;
    			}

    		}else if((this.order_comp).compare(elem.getPriority(),newPriority) > 0){
    			int index = queuegetStruct().indexOf(elem);
    			queueGet(index).setPriority(newPriority);
    			while(index > 0  && (this.order_comp).compare(queueParent(index).getPriority(),queueGet(index).getPriority()) > 0){
    				elementSwap(index,queueParentPosition(index));
    				index = queueParentPosition(index);
    			} 
    		}
    	}	

	    /*this methods print a priorityqueue. */


	    public void print(){
	    	for(int i = 0; i < queueSize(); i++){
	    		System.out.println("\n" + queueGet(i).getElem()  + "---> left son : " + queueLeftSonElem(i).getElem());
	    		System.out.println("\n" + queueGet(i).getElem()  + "---> right son : " + queueRightSonElem(i).getElem());
	    	}
	    }

	   	/** this method return true if and only if the element is in the queue
	   	* @param elem : interested element.
	   	* @return  true if and only if the element is in the queue.
	   	*/

	   	public boolean contains(GenericElement<E,P> elem){
	   		boolean booleano = false;
	   		for(int i = 0; i < queueSize() && !booleano; i++){
	   			if(queueGet(i).getElem().toString().equals(elem.getElem().toString()))
	   				 booleano = true;
	   		}
	   			return booleano;
	   	}
}
