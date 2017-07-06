package test;
import java.util.Scanner;
public class ShadowTest {	
	public static void main(String[] args){  
		int sum=0;
		System.out.println("请输入需要计算的数字，中间用空格隔开");
		Scanner s = new Scanner(System.in);
		String a = s.nextLine();
		String[] sp = a.split(" ");
		if(sp.length<2){
			System.out.println("请输入至少两个数字");
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