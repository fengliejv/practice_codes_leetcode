package huaweibishi;

import java.util.Scanner;

public class T3 {
	public static void main(String arg[]){
		Scanner scanner = new Scanner(System.in);{
			while(scanner.hasNext()){			
				int end=scanner.nextInt();
				int m = scanner.nextInt();
				int[][] reachtable={{0,2,10,5,3,1000},
									{1000,0,12,1000,1000,10},
									{1000,1000,0,1000,7,1000},
									{2,1000,1000,0,2,1000},
									{4,1000,1000,1,0,1000},
									{3,1000,1,1000,2,0}	
				};
				for(int i=0;i<reachtable.length;i++){
					reachtable[m-1][i]=1000;
					reachtable[i][m-1]=1000;
				}
				
				for(int i=0;i<reachtable.length;i++){
					
				}
				
			
			}
		}
	}
}
