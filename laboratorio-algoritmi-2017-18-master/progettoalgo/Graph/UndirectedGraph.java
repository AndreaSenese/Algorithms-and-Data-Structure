  package Graph;

  import java.util.HashMap;
  import java.util.Map;
  import java.util.ArrayList;
  import java.lang.Exception;
  import java.util.Set;

  /**
  * @author : Andrea Senese
  * @param <V> : Generic Vertex  of Graph
  * @param <E> : Generic Edge of Graph
  */

    public class UndirectedGraph<V,E> extends Graph<V,E>{


        protected HashMap<Vertex<V>,HashMap<Vertex<V>,Double>> adiacencyList;
        protected HashMap<V,Vertex<V>> vertexes;

        public UndirectedGraph(){
         (this.adiacencyList) = new HashMap<Vertex<V>,HashMap<Vertex<V>,Double>>();
         this.vertexes = new HashMap<V, Vertex<V>>();

        }

        /**
        * @return true if and only if this vertex not exist in the graph.
        * @param vertex interested vertex.
        */

        public boolean vertexExist(Vertex<V> vertex) throws Exception{
          return vertexes.containsKey(vertex.getElem());
        }

        /**
        * @return a first vertex of the graph
        */

        public Vertex<V> getFirstVertex(){
          return adiacencyList.keySet().iterator().next();
        }

        /**
        * @param s : interested vertex.
        * @return a interested vertex of the graph.
        */

        public Vertex<V> getVertex(String s){
          return vertexes.get(s);
        }

  		  /**
      	* Add the specified vertex to the graph.
      	* @param vertex the vertex to be added
      	* @throws Exception if the vertex is already in the graph
      	*/

        public void addVertex(Vertex<V> vertex) throws Exception{
         if(vertexExist(vertex)) return;

         (this.adiacencyList).put(vertex,new HashMap<Vertex<V>,Double>());
         (this.vertexes).put(vertex.getElem(),vertex);
       }

  		  /**
      	* Add the new edge in the graph between two vertex with a weight associated to the edge.
      	* @param startVertex first vertex.
      	* @param endVertex second vertex.
      	* @throws Exception
      	* @return true if and only if the two vertex passed by parameters not exists.
      	*/

      	public boolean addEdge(Vertex<V> startVertex,Vertex<V> endVertex,Double edge) throws Exception{
          if(!vertexExist(startVertex) || !vertexExist(endVertex))
            return false;
          Vertex<V> s = vertexes.get(startVertex.getElem());
          Vertex<V> e = vertexes.get(endVertex.getElem());
          
          adiacencyList.get(s).put(e,edge);
          adiacencyList.get(e).put(s,edge);
          return true;
        }

        /**
        *@return an element of type 'Set' containing all vertices of the graph.
        */

        public Set<Vertex<V>> getAllVertices(){
          return adiacencyList.keySet();
        }

        /**
        * This methods return an adjacent of an interested vertex.
        * @param vertex interested vertex.
        * @return an element of type 'Set' containing the adjacent ones of a given vertex of the graph.
        */

        public Set<Vertex<V>> getNeighbors(Vertex<V> vertex){
          Vertex<V> v = vertexes.get(vertex.getElem());
          return adiacencyList.get(v).keySet();
        }

        /**
        * return a weight of an interested edge when this edge exist.
        * @param startVertex first vertex.
        * @param endVertex second vertex.
        * @throws Exception
        * @return a weight of an interested edge.
        */

        public Double getWeight(Vertex<V> startVertex,Vertex<V> endVertex) throws Exception{
           if(!vertexExist(startVertex) || !vertexExist(endVertex))
             return 0.0;
           Vertex<V> s = vertexes.get(startVertex.getElem());
           Vertex<V> e = vertexes.get(endVertex.getElem());
           return adiacencyList.get(s).get(e);
         }

        /**
        * return a total weight of the graph.
        * @param startVertex first vertex.
        * @param endVertex second vertex.
        * @throws Exception
        * @return a total weight of the graph.   
        */

        public Double getWeight() throws Exception{
          Double sumedge = 0.0;
          for(HashMap<Vertex<V>,Double> mapinterna : adiacencyList.values()){
            for(Double e: mapinterna.values()){
               sumedge += e;
            }
          }return sumedge/2;
        }

        /**
        * @return true if and only if the graph is Empty.
        */

        public boolean graphisEmpty(){
          return (this.adiacencyList).isEmpty();
        }

        /**
        * @return the total number of the vertices.
        */

        public  int getNumVertices(){
          return adiacencyList.keySet().size();
        }

        /**
        * @return an hashmap containing all total vertices of a given vertex.
        * @throws Exception
        */

        public HashMap<Vertex<V>,Double> getEdge(Vertex<V> vertex) throws Exception{
          if(!vertexExist(vertex)) throw new Exception("vertex not exist");
          Vertex<V> v = vertexes.get(vertex.getElem());
          return (this.adiacencyList).get(v);
        }

        /**
        * @return the total number of the edge.
        * @throws Exception
        */

        public int getNumEdges() throws Exception{
           if(graphisEmpty()) throw new Exception("graph is empty and not exist vertices");
            int count = 0;
            for(Vertex<V> vertex : getAllVertices()){
             for(Vertex<V> neighbors : getNeighbors(vertex)){
              count++;
             }
            }return count/2; 
        }

        /**
        *  print the graph. 
        */
        public String toString() {
          String s = "";
          for (Vertex<V> f : getAllVertices()) {
            s += f.toString() + ": ";
            for (Vertex <V> e : getNeighbors(f)) {
              s += "[" + e.getElem().toString() +  ", " + e.getElem().toString() + "] ";
            }
            s += "\n";
          }
          return s;
        }
  }