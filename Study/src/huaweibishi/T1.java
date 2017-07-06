package huaweibishi;
import java.util.Scanner;
//输入数字倒转相加
public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            String a=in.nextLine();
            String temp[]=a.split(",");
            int num1=reverseStrInt(temp[0]);
            int num2=reverseStrInt(temp[1]);
            int result;
            if(num1<1||num1>70000||num2<1||num2>70000){
            	result=-1;
            }else{
            result=num1+num2;
            System.out.println( result);    
            }
    }
    public static int reverseStrInt(String a){
        char get[]=a.toCharArray();
        for (int i=0;i<get.length/2;i++)
        {
            char temp=get[i];
            get[i]=get[get.length-i-1];
            get[get.length-i-1]=temp;

        }
        String str = new String(get);
        int reverse=Integer.parseInt(str);
        return reverse;

    }
}