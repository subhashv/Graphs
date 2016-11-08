package basics;

public class Neighbor {

	public int vertexNum;
	
	public Neighbor next;
	
	public Neighbor(int vertexNum, Neighbor neighbor){
		this.vertexNum = vertexNum;
		this.next = neighbor;
	}
}
