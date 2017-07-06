package qunaer;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
	HashMap<String, Node> nodeMap=new HashMap<String, Node>();
	static class Node{
		int id;
		String val;
		List<Node> nextList=new LinkedList<Node>();
		Node(int id,String g){
			this.id=id;
			val=g;
		}
		void putNext(Node node){
			nextList.add(node);
			node.nextList.add(this);
		}
		
	}
	public static void main(String arg[]){
		Scanner scanner=new Scanner(System.in);
		String start=scanner.nextLine();
		String end=scanner.nextLine();
		String []dic=scanner.nextLine().split(" ");
		Node[] nodes=new Node[dic.length+1];
		int endIndex=0;
		for(int i=0;i<dic.length;i++){
			if(end.equals(dic[i]))
				endIndex=i;
			nodes[i]=new Node(i,dic[i]);
			for (int j = 0; j < i; j++) {
				if(check(dic[i], dic[j]))
					nodes[i].putNext(nodes[j]);
			}
		}
		nodes[nodes.length-1]=new Node(nodes.length-1,start);
		for (int j = 0; j < dic.length; j++) {
			if(check(start, dic[j]))
				nodes[nodes.length-1].putNext(nodes[j]);
		}
		
		class Priority implements Comparable<Priority>{
			Node node;
			int p;
			public Priority(Node node) {
				// TODO Auto-generated constructor stub
				this.node=node;
			}
			public Priority(Node node,int t) {
				// TODO Auto-generated constructor stub
				this.node=node;
				p=t;
			}
			public int compareTo(Priority o) {
				return p-o.p;
			};
		}
		
		PriorityQueue<Priority> queue=new PriorityQueue<>();
		queue.add(new Priority(nodes[nodes.length-1]));
		boolean flags[]=new boolean[nodes.length];
		Node from[]=new Node[nodes.length];
		int length[]=new int[nodes.length];
		Arrays.fill(length, Integer.MAX_VALUE);
		length[nodes.length-1]=0;
		while (queue.size()>0) {
			Node node=queue.poll().node;
			if(flags[node.id])
				continue;
			flags[node.id]=true;
			if (node.id==endIndex) {
				break;
			}
			int l=length[node.id]+1;
			for(Node n:node.nextList){
				if (!flags[n.id]) {
					if(l<length[n.id]){
						from[n.id]=node;
						length[n.id]=l;
						queue.add(new Priority(n,l));
					}
				}
			}

		}
		
		System.out.println(length[endIndex]+1);
	
	}
	
	static boolean check(String a,String b){
		int count=0;
		for(int i=0;i<a.length();i++)
			if (a.charAt(i)!=b.charAt(i)) {
				count++;
			}
			
		return count==1;
	}
}
