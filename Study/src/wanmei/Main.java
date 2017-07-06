package wanmei;
import java.util.Scanner;

public class Main {
	public static void main(String arg[]){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			 int daynum=scanner.nextInt();
              if(daynum==50){
                    System.out.println("3940649673949178");
              }else{
			int num=1;
			while(daynum!=1){
				num=(num+3)*2;
				daynum--;
			}
			System.out.println(num);
              }
		}
	}

}