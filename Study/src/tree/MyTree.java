package tree;

import java.util.LinkedList;
import java.util.Queue;

import javax.naming.InitialContext;

public class MyTree {
	Node root;
	
	public MyTree(){
		root=null;
	}
	public MyTree(int[] in ){
		buildTree(in);
	}
	
	//��������������
	public void buildTree(int[] in){
		if(in.length<1)
			System.out.print("input error");
		root=new Node(in[0]);
		for(int i=0;i<in.length-1;i++){
			Node newNode=new Node(in[i+1]);
			insert(newNode);
		}
	}
	//����������ڵ�
	public void insert(Node node){
		Node currentNode = root;
		if(root==null)
			root=node;
		else{
			while(true){
			if(node.value<currentNode.value){
				if(currentNode.lchild==null){
					currentNode.lchild=node;
					//System.out.println(node.value);
					return;
				}else
					currentNode=currentNode.lchild;
			}
			else{
				if(currentNode.rchild==null){
					currentNode.rchild=node;
					//System.out.println(node.value);

					return;
				}else
					currentNode=currentNode.rchild;
				}
			}
		}
	}
	
	//�������������
	public void inorder(Node node){
		if(node!=null){
			inorder(node.lchild);
			System.out.print(node.value);
			inorder(node.rchild);
		}
	}
	public void inorder(){
		inorder(this.root);
	}
	
	//�������������
	public void preorder(Node node){
		if(node!=null){
		System.out.print(node.value);
		preorder(node.lchild);
		preorder(node.rchild);
		}
	}
	public void preorder(){
		preorder(this.root);
	}
	
	//��������������
	public void postorder(Node node){
		if(node!=null){
			postorder(node.lchild);
			postorder(node.rchild);
			System.out.print(node.value);
	}
	}
	public void postorder(){
		postorder(this.root);
	}
	//�������������
	public void layerorder(){
		Queue<Node> queue = new LinkedList<Node>();
		if(root==null)
			System.out.print("the tree is null");
		else{
			queue.offer(root);
			while(queue.size()!=0){
				Node nowNode = queue.poll();
				System.out.print(nowNode.value);
				if(nowNode.lchild!=null)
					queue.offer(nowNode.lchild);
				if(nowNode.rchild!=null)
					queue.offer(nowNode.rchild);
			}
		}
	}
	
	
	//��֪ǰ����������������-------------------------------------------------------------
	public Node initTree(int[] pre, int[] mid){
		return initTree(pre, 0, pre.length-1, mid, 0, mid.length-1);
	}
	public Node initTree(int[] pre,int start1,int end1,int[] mid,int start2,int end2){
		if(start1>end1||start2>end2){
			return null;
		}
		Node headNode = new Node(pre[start1]);
		int indexOfHeadInMid = findHeadIndex(headNode.value,mid,start2,end2);
		int offset = indexOfHeadInMid-start2;
		Node leftNode = initTree(pre, start1+1, start1+offset, mid, start2, start2+offset-1);
		Node rightNode = initTree(pre, start1+offset+1, end1, mid, indexOfHeadInMid+1, end2);
		headNode.lchild=leftNode;
		headNode.rchild=rightNode;
		return headNode;
	}
	//��mid���ҵ�head��index
	private int findHeadIndex(int head,int[] mid, int start2,int end2){
		//int index=0;
		for(int i=start2;i<end2+1;i++){
			if(mid[i]==head){
				return i;
				//index=i;
			//	break;
			}
		}
		return -1;
		//return index;
	}
	
	
	public static void main(String[] arg){
		int[] in={4,2,6,7,5,1,8,3,4};
		int[] pre = {4,2,1,3,6,5,4,7,8};
		int[] mid = {1,2,3,4,4,5,6,7,8};
		MyTree tree = new MyTree();
		//tree.buildTree(in);
		//tree.preorder();
		Node headNode =tree.initTree(pre, mid);
		tree.preorder(headNode);
	}	
}








class Node{
	int value;
	Node lchild;
	Node rchild;
	int height;//AVL����Ϊ�Ƿ���Ҫ����������
	public Node(){
		super();
	}
	
	public Node(int value){
		this.value=value;
		lchild=null;
		rchild=null;
		height=0;
	}
}
