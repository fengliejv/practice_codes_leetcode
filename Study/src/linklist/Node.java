package linklist;

import java.util.HashMap;
import java.util.List;

import javax.naming.directory.SearchControls;

public class Node {
	Node next = null;
	int data;

	public Node(int data) {
		this.data = data;
	}

	public static void main(String arg[]) {
		Node d ;
		MyLinkedList list = new MyLinkedList();
		MyLinkedList list2=new MyLinkedList();
		list.addNode(5);
		list.addNode(3);
		list.addNode(2);
		list.addNode(4);
		list.addNode(1);		
	//----------------------------
		list2.addNode(1);
		list2.addNode(3);
		list2.addNode(5);
		list2.addNode(6);
		list2.addNode(7);
		list2.addNode(4);
		list2.addNode(3);
		list2.addNode(2);
		list2.addNode(4);
		list2.addNode(1);
		
		d=list.theFirstIntersect(list,list2);
		System.out.println(d.data);
//		System.out.println(list.length());
//		list.printList();
//		list.orderList();
//		list.printList();
//		list.deleteBup();
//		list.printList();
//		System.out.println(list.lastK_Node(5));
//		list.printReverse(list.head);
//		System.out.println();
//		list.reversLink();
//		list.printList();
//		d=list.searchMid();
//		System.out.println(d.data);
//		list.deleteNode(d);
//		list.printList();
	}
}

class MyLinkedList {

	Node head = null;

	//增加节点
	public void addNode(int data) {

		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			head.next = null;
			return;
		}

		Node tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = newNode;
	}
	
	//删除指定索引的节点
	public Boolean deleteNode(int index) {
		if (index < 0 || index > length() - 1) {
			return false;
		}
		if(index==0){		
			head=head.next;
			return true;
		}
		Node tmp = head;
		while (index != 1) {
			index--;
			tmp = tmp.next;
		}
		Node deletetmp = tmp.next;
		tmp.next = deletetmp.next;
		deletetmp.next = null;
		return true;
	}
	
	//删除指定节点
	public Boolean deleteNode(Node n){
		if(n==null||n.next==null){
			return false;		
		}
		n.data=n.next.data;
		n.next=n.next.next;
		//n.next.next=null;
		return true;
	}

	//链表长度
	public int length() {
		int length = 0;
		Node tmp = head;
		while (tmp != null) {
			length++;
			tmp = tmp.next;
		}
		return length;
	}

	//从头到尾打印链表
	public void printList() {
		Node tmp = head;
		for (int i = 0; i < length(); i++) {
			System.out.print(tmp.data);
			tmp = tmp.next;
		}
		System.out.println();
	}
	
	//链表排序输出
	public Node orderList() {
		if (length() == 0 || length() == 1) {
			return head;
		}

		int tmp2;
		// for(int i=length()-1;i>0;i--){
		for (int i = 0; i < length() - 1; i++) {
			Node tmp = head;
			for (int j = length() - i - 1; j > 0; j--) {
				if (tmp.data > tmp.next.data) {
					tmp2 = tmp.next.data;
					// System.out.print(tmp.next.data);
					tmp.next.data = tmp.data;
					tmp.data = tmp2;
				}
				tmp = tmp.next;
			}
			// while(tmp.next!=null){
			// if(tmp.data>tmp.next.data){
			// tmp2=tmp.next.data;
			// //System.out.print(tmp.next.data);
			// tmp.next.data=tmp.data;
			// tmp.data=tmp2;
			// }
			// tmp=tmp.next;

			// }
		}
		return head;
	}

	//删除相同的节点
	public void deleteBup() {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		Node tmp = head;
		for (int i = 0; i < length()-1; i++) {
			if (hashMap.containsKey(tmp.data)) {
				tmp=tmp.next;
				deleteNode(i);
				i=i-1;
			} else {
				hashMap.put(tmp.data, 1);
				tmp=tmp.next;
			}			
		}
//		int i=0;
//		while(tmp.next!=null){
//			if (hashMap.containsKey(tmp.data)) {
//				tmp=tmp.next;
//				deleteNode(i);	
//				i=i-1;
//			} else {
//				hashMap.put(tmp.data, 1);
//				tmp=tmp.next;
//			}
//			i++;
//		}
		
	}
	
	//倒數第k個節點
	public int lastK_Node(int k){
		Node tmp = head;
		if(k>length()||k<0){
			return -500;
		}
		while(k!=1){
			tmp=tmp.next;
			k--;
		}
		Node tmp2=head;
		while(tmp.next!=null){
			tmp=tmp.next;
			tmp2=tmp2.next;
		}
		return tmp2.data;
	}
	
	//反轉鏈表
	public void  reversLink(){
		Node tmp = head;
		Node tmp2 =head.next;
		Node tmp3;
		head.next=null;
		while(tmp2 !=null){
			tmp3=tmp2.next;
			tmp2.next=tmp;
			tmp=tmp2;
			tmp2=tmp3;	
		}
		head=tmp;
	}
	
	//倒序打印鏈表
	public void printReverse(Node head){		
		if(head!=null){			
			printReverse(head.next);
			System.out.print(head.data);
		}		
	}
	
	//查找一个链表的中间节点
	public Node searchMid(){
		Node tmp=head;
		Node tmp2=head;
		while(tmp2!=null&&tmp2.next!=null&&tmp2.next.next!=null){
			tmp=tmp.next;
			tmp2=tmp2.next.next;
		}
		return tmp;
	}
  	
	//判断两个单向链表的第一个重合点
	public Node theFirstIntersect(MyLinkedList a,MyLinkedList b){
		Node c;
		Node atmp=a.head;
		Node btmp=b.head;
		int distinct=a.length()-b.length();
		if(distinct<0){
			c=a.head;
			atmp=btmp;
			btmp=c;
			distinct=-distinct;
		}
		while(distinct!=0){
			atmp=atmp.next;
			distinct--;
		}
		while(atmp!=null){
			if(atmp.data==btmp.data){
				return atmp; 
			}
			atmp=atmp.next;
			btmp=btmp.next;
		}
		return null;
	}
	
	//判断一个链表是否为环形
	public boolean isLoop(){
		Node tmp = head;
		Node tmp2=head;
		if(head==null){
			return false;
		}
		while(tmp!=null&&tmp.next!=null&&tmp.next.next!=null){
			tmp=tmp.next.next;
			tmp2=tmp2.next;
			if(tmp.equals(tmp2))
				return true;
		}
		return false;
	}
}
