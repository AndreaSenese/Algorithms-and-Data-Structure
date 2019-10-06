package Graph.PriorityQueue;

/**
* @author : Andrea Senese
* @param <E> : type of FibHeap elements.
*/
import java.util.Comparator;

	public class GenericElement<E,P>{
		
		private E elem;
		private P priority;

		public GenericElement(E element, P iniz_priority){
			this.elem = element;
			this.priority = iniz_priority;
		}

		public GenericElement(E element){
			this.elem = element;
		}

		public E getElem(){
			return this.elem;
		}

		public void setElem(E element){
			this.elem = element;
		}

		public P getPriority(){
			return this.priority;
		}

		public void setPriority(P new_priority){
			this.priority = new_priority;
		}
		
   		public String toString(){
   			return " elem : " + getElem() + " priority : " + getPriority();
   		}
	}