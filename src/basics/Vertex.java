package basics;

public class Vertex {

	public String name;
	
	public Neighbor adjList;
	
	public Vertex(String name, Neighbor neighbor){
		this.name = name;
		this.adjList = neighbor;
	}
}
