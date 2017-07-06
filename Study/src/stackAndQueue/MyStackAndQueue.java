package stackAndQueue;

import java.util.Arrays;

import javax.swing.Popup;

public class MyStackAndQueue {
	public static void main(String arg[]){
		MyLinkedQueue stack1=new MyLinkedQueue();
		stack1.put(1);
		stack1.put(2);
		stack1.put(5);
		stack1.put(5);
		System.out.println(stack1.size());
		System.out.println(stack1.pop());	
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.size());
	}
	
	
	
}
class MyStack2<E>{
	Node1 top=null;
	public Boolean isEmpty(){
		if(top==null){
		return true;
		}
		return false;
	}
	
	public E Pop(){
		if(isEmpty()){
		return null;	
		}
		E a = (E) top.value;
		top=top.next;
		return a;
	}
	
	public void push(E value){
		Node1 node1 = new Node1(value);
		node1.next=top;
		top=node1;
	}

	public E peek(){
		if(isEmpty()){
			return null;
		}else{
		E e = (E) top.value;
		return e;
		}
		
	}
	


	
}


class Node1<E>{
	public Node1(E value) {
		// TODO Auto-generated constructor stub
		this.value=value;
	}
	E value=null;
	Node1 next=null;
}


//数组实现栈
class MyStack1<E>{
	private Object[] stack;
	private int size=0;
	
	public MyStack1(){
		stack = new Object[10];
	}
	
	public Boolean isEmpty(){
		return size==0?true:false;
	}
	
	public E peek(){
		if(isEmpty()){
			return null;
		}
		return (E) stack[size-1];
	}
	
	public E pop(){
		if(isEmpty()){
			return null;
		}
		E a = peek();	
		stack[size-1]=null;
		size--;
		return a;
	}
	
	public void push(E a){
		//size++;
		ensureCapacity(size);
		stack[size++]=a;
	}
	
	private void ensureCapacity(int size){
		if(size>stack.length){
			int newLen=10;
			//Arrays工具类*****************************
			stack=Arrays.copyOf(stack, newLen);
		}
	}
}

class MyLinkedQueue<E>{
	Node1 preNode1=new Node1(null);
	Node1 endNode1=preNode1;
	
	public void put(E value){
		if(endNode1.value==null){
			endNode1.value=value;
		}else{
		Node1 e=new Node1(value);
		endNode1.next=e;
		endNode1=endNode1.next;
		}
	}
	
	public E pop(){
		if(preNode1.value==null){
			return null;
		}
		E e = (E) preNode1.value;
		Node1 node1=preNode1.next;
		preNode1.next=null;
		preNode1=node1;
		return e;	
	}
	
	public int size(){
		int lenth=0;
		Node1 tmp=preNode1;
		while(tmp!=null){
			lenth++;
			tmp=tmp.next;
		}
		return lenth;
	}
}