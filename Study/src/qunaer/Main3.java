package qunaer;

import java.math.BigInteger;

public class Main3 {
	public static void main(String arg[]){
		String string = "cc";
		char[] chars=string.toCharArray();
		for(int i=0;i<chars.length;i++){
			if(chars[i]<'k')
				chars[i]=(char)(chars[i]-'a'+'0');
			else {
				chars[i]-=10;
			}
		}
		BigInteger integer=new BigInteger(new String(chars),26);
		System.out.println(integer.toString());
	}
}
