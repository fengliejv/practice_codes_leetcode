package wangyi;

import java.util.Scanner;

public class Main2{

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int carnum=scanner.nextInt();
        Taxi[] taxis=new Taxi[carnum];
        
        for (int i=0;i<carnum&&scanner.hasNextInt();i++) {
        	taxis[i]=new Taxi();
        	taxis[i].x = scanner.nextInt();
        }
        for (int j=0;j<carnum&&scanner.hasNextInt();j++)
        	taxis[j].y=scanner.nextInt();
        
        int gx=scanner.nextInt();
        int gy=scanner.nextInt();
        
        int timeA=scanner.nextInt(),timeB=scanner.nextInt();

        for (int i=0;i<taxis.length;i++){
            int length1 =Math.abs(taxis[i].x)+Math.abs(taxis[i].y);
            int time1=length1*timeA;
            int length2=Math.abs(taxis[i].x-gx)+Math.abs(taxis[i].y-gy);
            int time2=length2*timeB;
            taxis[i].setTime(time1+time2);
        }

        int mintime=(Math.abs(gx)+Math.abs(gy))*timeA;
        for (int i=0;i<taxis.length;i++){
        	mintime=mintime<taxis[i].time?mintime:taxis[i].time;
        }
        System.out.println(mintime);

    }

    static class Taxi{
        int x;
        int y;
        int time;
        public void setTime(int time) {
            this.time = time;
        }
    }
}


