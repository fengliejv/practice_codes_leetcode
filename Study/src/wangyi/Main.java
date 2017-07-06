package wangyi;

import java.util.Scanner;

public class Main {
	public static void main(String arg[]){
		Scanner scanner = new Scanner(System.in);
		String in = scanner.next();
		int size = in.length();
		char[] queue = in.toCharArray();
		int count = 0;
		for(int i=0;i<size-1;i++){
			if(queue[i]!=queue[i+1]){
				char a = queue[i];
				queue[i]=queue[i+1];
				queue[i+1]=a;
				count++;
			}
		}
		System.out.print(" "+count);
	}
}
