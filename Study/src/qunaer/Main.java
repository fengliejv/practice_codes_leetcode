package qunaer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	static class Tree{
		int val;
		Tree left;
		Tree right;
		@Override
		public String toString() {
			StringBuilder buidlerBuilder=new StringBuilder();
			Queue<Tree> queue=new LinkedList<>();
			queue.add(this);
			
			while (queue.size()>0) {
				Tree t=queue.poll();
				if (t==null) {
					continue;
				}
				buidlerBuilder.append(t.val+" ");
				queue.add(t.left);
				queue.add(t.right);
			}
			return buidlerBuilder.toString().trim();
		}
	}
	public static void main(String arg[]){
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int []pre=new int[n];
		int []mid=new int[n];
		for	(int i=0;i<n&&scanner.hasNext();i++)
			pre[i]=scanner.nextInt();
		for	(int i=0;i<n&&scanner.hasNext();i++)
			mid[i]=scanner.nextInt();
		Tree tree=getTree(pre,mid,0,n-1,0,n-1);
		System.out.println(tree);
	}
	public  static Tree getTree(int []pre,int mid[],int midstart,int midend,int prestart,int preend) {
		if(midstart>midend)
			return null;
		int root=pre[prestart];
		int index=0;
		for(;index<=midend;index++){
			if (mid[index]==root) {
				break;
			}
		}
		Tree tree=new Tree();
		tree.val=root;
		tree.left=getTree(pre, mid, midstart, index-1, prestart+1, prestart+index-midstart);
		tree.right=getTree(pre, mid, index+1, midend, prestart+index-midstart+1, preend);
		
		return tree;
	}
}
