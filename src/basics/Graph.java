package basics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {

	Vertex[] adjLists;
	
	public Graph() throws FileNotFoundException{
		
		Scanner sc = new Scanner(new File("C:/Abcd/Graphs/data/frendship.txt"));
		//Scanner sc = new Scanner(new File("C:/Abcd/Graphs/data/websites.txt"));
		
		String graphType = sc.next();
		boolean isDirected = true;
		if("directed".equals(graphType)){
			isDirected = false;
		}
		
		this.adjLists = new Vertex[sc.nextInt()];
		
		for(int i=0;i<adjLists.length;i++){
			adjLists[i] = new Vertex(sc.next(), null);
		}
		
		while(sc.hasNext()){
			int v1 = indexForName(sc.next());
			int v2 = indexForName(sc.next());
			
			this.adjLists[v1].adjList = new Neighbor(v2, adjLists[v1].adjList);
			if(isDirected){
				this.adjLists[v2].adjList = new Neighbor(v1, adjLists[v2].adjList);
			}
		}
		
		print();
	}
	
	private int indexForName(String name){
		
		for(int i=0;i<this.adjLists.length;i++){
			if(this.adjLists[i].name.endsWith(name)){
				return i;
			}
		}
		return -1;
	}
	
	private void print(){
		
		for(int i=0;i<this.adjLists.length;i++){
			Vertex vertex = this.adjLists[i];
			System.out.print(vertex.name);
			for(Neighbor nbr = vertex.adjList;nbr!=null;nbr=nbr.next){
				System.out.print("-->"+adjLists[nbr.vertexNum].name);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		try {
			new Graph();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
