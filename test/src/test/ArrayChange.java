package test;

import java.util.*;

public class ArrayChange {
	public static void main(String[] args){
		String str1="hello";
		String str2="world";
		List<String> a =  arrayToList(str1,str2);
		String[] array = listToArray(str1,str2);
		System.out.println(a);
		System.out.println("数表输出完毕");
		for(int i=0;i<array.length;i++){
		System.out.println(array[i]);
		}
	}
	
	public  static List<String> arrayToList(String str1,String str2){
	String[] arr = new String[] {str1, str2};  
	List<String> list = Arrays.asList(arr); 
	return list;
	}
	
	public static String[] listToArray(String str1,String str2){
		List<String> list = new ArrayList<String>();  
		list.add(str1);  
		list.add(str2);  
		int size = list.size();
		String[] arr = (String[]) list.toArray(new String[size]);
		return arr;
	}
}