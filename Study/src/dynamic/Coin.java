package dynamic;

import java.util.ArrayList;
import java.util.Scanner;

/*�����м���Ӳ�ң���1��3��5�������������ޡ�
 * ���ҳ��ܹ����ĳ����Ŀ��������ʹ�����ٵ�Ӳ������ 
�ⷨ��
�����ô��������ֵk�����ӽṹ/״̬������sum[k]����ֵΪ�������СӲ������
���ڲ�ͬ��Ӳ����ֵcoin[0...n]����sum[k] = min(sum[k-coin[0]] , sum[k-coin[1]], ...)+1��
��Ӧ�ڸ�����Ŀ������total����Ҫ���sum[total]��ֵ�� 
 * */
public class Coin {
	int num=0;
	int[] coin = {1,3,5};
	ArrayList<Integer> sum = new ArrayList<Integer>();
	public Coin(){
		sum.add(0);		
	}
	public static void main(String arg[]){
		Scanner scanner = new Scanner(System.in);
		int need = scanner.nextInt();
		int num = new Coin().search(need);
		System.out.println(num);
	}
	
	private int search(int need){
		if(need<0){
			return -1;
		}
		while((sum.size()-1)<need){
			calcu();
		}
		return sum.get(sum.size()-1);
	}
	private void calcu(){
		int k=sum.size();
		int e=0;
		int a,b,c;
		if(k-coin[0]<0){
		}else if(k-coin[1]<0){
			e=sum.get(k-coin[0]);
		}else if(k-coin[2]<0){
			a=sum.get(k-coin[0]);
			b=sum.get(k-coin[1]);
			e =min(a,b); 	
		}else{
		a=sum.get(k-coin[0]);
		b=sum.get(k-coin[1]);
		c=sum.get(k-coin[2]);
		e =min(a,b,c); 		
		}
		//System.out.println(e+1);
		sum.add(e+1);
	}
	private int min(int a,int b){
		int min =a ;
		if(b<min)
			min =b;
		return min;
	}
	private int min(int a,int b,int c){
		int min = a;
		if(b<min)
			min=b;
		if(c<min)
			min=c;
		return min;
	}
}
