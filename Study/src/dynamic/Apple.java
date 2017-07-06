package dynamic;

import java.util.ArrayList;

/*一个矩形区域被划分为N*M个小矩形格子，在格子(i,j)中有A[i][j]个苹果。现在从左上角的格子(1,1)出发，
 * 要求每次只能向右走一步或向下走一步，最后到达(N,M)，每经过一个格子就把其中的苹果全部拿走。
 * 请找出能拿到最多苹果数的路线。
 * */
public class Apple {
	   int[][] appleStrings =  {{1, 0, 20, 0, 0, 10},
								{45,0,  0, 0, 0, 30},
								{0, 0, 11, 1, 2,  0}};
	   int row = appleStrings.length;
		int col = appleStrings[0].length;
	   //用于保存每个位子的最大值
		int[][] max=new int[row][col];
	  //用于保存每个位子的最大值从哪个方向过来，-1表示左边到来，1表示上方到来
	   int[][] apptab=new int[row][col];
	   
	   public Apple(){
		   max[0][0]=appleStrings[0][0];
	   }
	   
	   
	public static void main(String arg[]){
		Apple apple = new Apple();
		//System.out.print(apple.appleStrings[0].length);
		int m=apple.maxroute(apple.row-1, apple.col-1);
		System.out.println(m);
		apple.printRout();

	}
	
	public void printRout(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		int a = row-1;
		int b = col-1;
		while(a!=0||b!=0){
			int value = apptab[a][b];
			list.add(value);
			if(value==1)
				a--;
			else 
				b--;
		
		}
		for(int i=list.size();i>0;i--){
			System.out.println(list.get(i-1));
		}
	}
	
	
	public void printTable(){
		for(int i = 0;i<row;i++)
			for(int j=0;j<col;j++){
				System.out.print(apptab[i][j]);
			}
		
	}
	
	public int maxroute(int n,int m){
		if(n==0&&m==0){
			int rt=max[n][m];
			apptab[n][m] = 0;
			return rt;
		}
		if(n==0){
			int rt = maxroute(n,m-1)+appleStrings[n][m];
			apptab[n][m]=-1;
			return rt;
		}
		if(m==0){
			int rt = maxroute(n-1,m)+appleStrings[n][m];
			apptab[n][m]=1;
			return rt;
			
		}
		int rt;
		if(maxroute(n-1, m)>maxroute(n, m-1)){
			apptab[n][m]=1;
			rt=maxroute(n-1, m)+appleStrings[n][m];
		}else{
			apptab[n][m]=-1;
			rt=maxroute(n, m-1)+appleStrings[n][m];
		}
		return rt;
		
	}
	
}
