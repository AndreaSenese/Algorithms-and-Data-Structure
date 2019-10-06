package Graph.prim;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.lang.Exception;
import java.util.Set;
import Graph.*;
import java.util.Comparator;
import Graph.PriorityQueue.*;
import java.lang.Exception;

/**
* @author : Andrea Senese
* @param <V> : Generic Vertex  of Graph
* @param <E> : Generic Edge of Graph
*/

public class Prim<V> extends UndirectedGraph<V,Double>{

	class PriorityQueueComparator implements Comparator<Double>{
		@Override
		public int compare(Double i1, Double i2){
			return i1.compareTo(i2);
		}
	}//inner class

	public Prim(){
		super();
	}

	/**
	* This methods build a minimum spanning tree.
	* @return a Prim minimum spanning tree.
	* @throws Exception
	*/

	public UndirectedGraph<V,Double> primSpanningTree(Vertex<V> startVertex) throws Exception{
		return prim(startVertex);
	}

	public UndirectedGraph<V,Double> prim(Vertex<V> startVertex) throws Exception{


   		Map<Vertex<V>, GenericElement<Vertex<V>,Double>> map = new HashMap<>();
		UndirectedGraph<V,Double> forest = new UndirectedGraph<>();
		PriorityQueue<Vertex<V>,Double> queue = new PriorityQueue<Vertex<V>,Double>(new PriorityQueueComparator());

		for(Vertex<V> u : getAllVertices()){
			u.setKey(Double.POSITIVE_INFINITY);
			u.setParent(null);
		}

		startVertex.setKey(0);
		for(Vertex<V> v : getAllVertices()){
			GenericElement<Vertex<V>,Double> nodo = new GenericElement<Vertex<V>,Double>(v,v.getKey());
			map.put(v, nodo);
			queue.queueInsert(nodo);
		}

		while(!queue.isEmpty()){

			Vertex<V> minimum = queue.extractMin().getElem();

			forest.addVertex(minimum);
			if(minimum.getParent() != null){
				forest.addEdge(minimum.getParent(),minimum,getWeight(minimum.getParent(),minimum));
			}
			for(Vertex<V> v : getNeighbors(minimum)) {
				if(queue.contains(map.get(v))){
					if(v.getKey() > getWeight(minimum,v)){
						v.setKey(getWeight(minimum,v));
						v.setParent(minimum);
						queue.changePriority(map.get(v), getWeight(minimum, v));  
					}
				}
			}
		}
		return forest;
	}
 

}
		