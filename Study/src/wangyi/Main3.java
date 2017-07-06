package wangyi;

import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner scanne=new Scanner(System.in);
        int num=scanne.nextInt();
        int oper=scanne.nextInt();
        int array[]=new int[num];
        for (int i=0;i<num&&scanne.hasNext();i++)
            array[i]=scanne.nextInt();
        while (oper-->0){
            int temp=array[0];
            for (int i=0;i<num;i++)
                if (i==num-1)
                    array[i]=(array[i]+temp)%100;
                else
                    array[i]=(array[i]+array[i+1])%100;
        }
        String a="";
        for (int i=0;i<num;i++)
            a=a+array[i]+" ";
        System.out.println(a.trim());
    }
}
