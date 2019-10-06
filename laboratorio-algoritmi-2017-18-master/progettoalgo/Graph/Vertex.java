package Graph;

/**
* @author : Andrea Senese
* @param <V> : Generic Vertex of Graph
*/

public class Vertex<V>{
	
	private V elem; // the element into vertex of the graph.
	private Vertex<V> parent;
	private double key; 

	public Vertex(V vertexElem){
		this.elem = vertexElem;
	}
	
	public V getElem(){
		return this.elem;
	}

	public void setKey(double key){
		this.key = key;
	}

	public double getKey(){
		return this.key;
	}

	public Vertex<V> getParent(){
		return this.parent;
	}

	public void setParent(Vertex<V> parent_1){
		this.parent = parent_1;
	}

   	public String toString(){
   		return getElem() + "";
   	}

}