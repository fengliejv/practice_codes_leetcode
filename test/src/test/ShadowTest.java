package test;
import java.util.Scanner;
public class ShadowTest {	
	public static void main(String[] args){  
		int sum=0;
		System.out.println("��������Ҫ��������֣��м��ÿո����");
		Scanner s = new Scanner(System.in);
		String a = s.nextLine();
		String[] sp = a.split(" ");
		if(sp.length<2){
			System.out.println("������������������");
		}else{
		for(int i=0;i<sp.length;i++){
			int j=Integer.parseInt(sp[i]);
			sum=sum+j;
		}
		System.out.println(sum);
		} 
		s.close();
	}	
}