package toutiao;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] arg){
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()){	
		HashMap<String, String> out = new HashMap<String, String>();
		StringBuilder inString = new StringBuilder(scanner.nextLine());
		while(!inString.toString().equals("0")){			
			if(!out.containsKey(inString)){
				out.put(inString.toString(), inString.toString());
			}
			inString = new StringBuilder(scanner.nextLine());
		}
		System.out.println(out.size());
		//System.out.println("haha");
	}
}
}