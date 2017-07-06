package toutiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
		public static void main(String arg[]){
		Scanner scanner = new Scanner(System.in);
		int lenth1= scanner.nextInt();
		HashMap<Integer, Integer> inputHashMap = new HashMap<Integer, Integer>();
		while(lenth1--!=0){
			int in = scanner.nextInt();
			if(!inputHashMap.containsKey(in)){
				inputHashMap.put(in, in);
			}
		}
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		//ArrayList<Integer> outputList = new ArrayList<Integer>();
		int lenth2 = scanner.nextInt();
		while(lenth2--!=0){
			int input = scanner.nextInt();
			if(inputHashMap.containsKey(input))
			arrayList.add(input);
		}
		for(int i=0;i<arrayList.size()-1;i++)
			System.out.print(arrayList.get(i)+" ");
			System.out.print(arrayList.get(arrayList.size()-1));
	}
}