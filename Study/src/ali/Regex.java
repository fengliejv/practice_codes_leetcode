package ali;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	public static void main(String arg[]){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
		String regexString = scanner.nextLine();
		String patternString = scanner.nextLine();
		String reg=regschange(patternString);
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(regexString);
		boolean rs = matcher.matches();
		if(rs)
			System.out.println("1");
		else
			System.out.println("0");
	}
	}
	public static String regschange(String str){
		char[] chars = str.toCharArray();
		int count = 0;
		for(int i=0;i<chars.length;i++){
			if(chars[i]=='*')
				count++;
		}
		char[] char2 = new char[chars.length+count];
		int j=0;
		for(int i=0;i<char2.length;i++){
			if(chars[j]=='*'){
				char2[i++]='.';		
			}
			char2[i]=chars[j];
			j++;
		}		
		StringBuilder strings = new StringBuilder();
		for(int i=0;i<char2.length;i++)
			strings.append(char2[i]);
		//System.out.println(strings.toString());
		return strings.toString();		
	}

}
