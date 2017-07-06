package test;

public class HashCodeTest {
	public static void main(String arg[]){
		
	String a = new String("i love yo");
	String b = new String("i love you");
	String c = "i love you";
	int d=a.hashCode();
	int e=b.hashCode();
	int f=c.hashCode();
	System.out.println(d);
	System.out.println(e);
	System.out.println(f);
	}
	
	
}
