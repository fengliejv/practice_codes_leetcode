package shuzu;

public class ShuZu {	
	public static void main(String[] arg){
		int[] a={-3,5,3,8,2,1,5};
		ShuZu test =new ShuZu();
		int n=test.returnmax(a);	
		System.out.print(n);
	} 	
	
	//递归从数组中查找最大值
	public int returnmax(int[] a){
		int b = recal(a,a.length-1);
		return b;
	}
	public  int recal(int a[] ,int end){
		if(end==0){
			return a[0];
		}else{			
			return max(recal(a,end-1),a[end]);			
		}		
	}
	public static int max(int a,int b){
		return a>b?a:b;
	}

}
