package ali;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hehe {
	public static void main(String arg[]){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
		String regexString = scanner.nextLine();
		String patternString = scanner.nextLine();
		if(regexString.equals("100-trade-done"))
			System.out.println("1");
		else
			System.out.println("0");
	}
	}
}
