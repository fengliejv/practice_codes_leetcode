package bag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import sort.MySort;

public class Bag_Question {
	public static void main(String arg[]){
		int cap = 18;
		int n=6;
//		int[] weight1 = {0,3,2,5,7,4,1};
//		int[] value1 = {0,3,4,2,4,1,5};
//		dyna(n,weight1, value1, cap);
		int[] weight = {3,2,5,7,4,1};
		int[] value = {3,4,2,4,1,5};		
//		dyna_two(n,weight, value, cap);
//		greedy(n,weight, value, cap);
		
	}



	
	
	
	
	//̰���㷨ʵ�ֲ��ֱ������⡣��Objecte������ÿ����Ʒ��
	//ͨ��Arrays���Լ���дComparator��ʵ�ְ��յ�λ������ֵ�Ľ�������
	public static void greedy(int n,int[] weight,int[] value,int cap){
		Objecte[] prio = new  Objecte[n];
		for(int i=0;i<n;i++){
			prio[i]=(new Objecte(weight[i], value[i]));
		}
		Arrays.sort(prio,new Comparator<Objecte>() {
			@Override
			public int compare(Objecte o1, Objecte o2) {
				// TODO Auto-generated method stub
				if(o1.avervalue>o2.avervalue)
					return -1;
				if(o1.avervalue<o2.avervalue)
					return 1;
				else return 0;
			}		
		});
		int j=0;
		double sum=0;
		while(cap>0){
			if(j==n)
				break;
			Objecte objecte=prio[j];
			if(objecte.weight<cap){
				cap=(int) (cap-objecte.weight);
				j++;
				sum=sum+objecte.value;
			}
			else if(objecte.weight>cap||objecte.weight==cap){
				sum=sum+cap*objecte.avervalue;				
				break;
			}			
		}
		System.out.print(sum);	
	}
	

	/*��һ�ֶ�̬�滮�㷨���������������ͼ�ֵʱ��һλҪ����0
	 * int[] weight = {0,3,2,5,7,4,1};
		int[] value = {0,3,4,2,4,1,5};
	 * */
	public static void dyna(int n,int[] weight,int[] value,int cap ){
		int[][] table=new int[n+1][cap+1];
		for(int i=0;i<cap+1;i++){
			for(int j=0;j<n+1;j++){
				if(i==0||j==0){
					table[j][i]=0;
					continue;
				}
				if(weight[j]>i&&i>0)
					//table[j][i]=table[j][i-1];
					table[j][i]=0;
				if(weight[j]<i&&i>0||weight[j]==i){
					int a = table[j-1][i];
					int b = table[j-1][i-weight[j]]+value[j];
					if(a>b)
						table[j][i]=a;
					else
						table[j][i]=b;
				}
			}
		}
		System.out.println(table[n][cap]);
	}
	
	
	//	�ڶ��ж�̬�滮�㷨������Ҫ����0
	public static void dyna_two(int n,int[] weight,int[] value,int cap ){
		int[][] table=new int[n][cap];
		for(int i=0;i<cap;i++){
			for(int j=0;j<n;j++){				
				if((weight[j]-1)>i){
					table[j][i]=0;
				}
				if(((weight[j]-1)<i)){
					if(j==0){
						table[j][i]=value[j];
						continue;
					}				
					int a = table[j-1][i];
					int b = table[j-1][i-weight[j]]+value[j];
					if(a>b)
						table[j][i]=a;
					else
						table[j][i]=b;
				}
				if(((weight[j]-1)==i)){
					table[j][i]=value[j];
				}
			}
		}
		System.out.println(table[n-1][cap-1]);
	}
	
	
	
	
}
class Objecte{
	double weight=0;
	int value=0;
	double avervalue=0;
	public Objecte(int weight,int value) {
		// TODO Auto-generated constructor stub
		this.weight=weight;
		this.value=value;
		avervalue=this.value/this.weight;
	}
}