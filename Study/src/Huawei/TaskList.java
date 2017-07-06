package Huawei;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class TaskList {
	public static void main(String arg[]){		
		        Scanner scanner=new Scanner(System.in);
		        int n=scanner.nextInt();
		        int k=scanner.nextInt();
		        int[] R1=new int[n];
		        Renwu[] R2=new Renwu[k];
		        for (int i=0;i<n&&scanner.hasNext();i++){
		            R1[i]=scanner.nextInt();
		        }
		        Arrays.sort(R1);
		        for (int i=0;i<k&&scanner.hasNext();i++){
		            R2[i]=new Renwu();
		            R2[i].time=scanner.nextInt();
		            R2[i].id=i;
		        }
		        Arrays.sort(R2);


		        List<Renwu> list=new LinkedList<>();
		        for (int i=0,j=0;i<R2.length;i++){
		            while (j<R1.length) {
		                if (j == 0 && R2[i].time < R1[j]) {
		                    R2[i].z = 1;
		                    list.add(R2[i]);
		                    break;
		                } else {
		                    if (j == R1.length - 1) {
		                        R2[i].z = R1[j] + 1;
		                        list.add(R2[i]);
		                        break;
		                    } else {
		                        if (R2[i].time < R1[j + 1] && R1[j+1] - R1[j ] > 1) {
		                            R2[i].z = R1[j] + 1;
		                            list.add(R2[i]);
		                            break;
		                        } else
		                            j++;
		                    }
		                }
		            }

		        }
		        Arrays.sort(R2, new Comparator<Renwu>() {
		            @Override
		            public int compare(Renwu o1, Renwu o2) {
		                return o1.id-o2.id;
		            }
		        });

		        for (Renwu r:list)
		            System.out.println(r.z);


		    }
		    static class Renwu implements  Comparable{
		        int id;
		        int time;
		        int z;
		        @Override
		        public int compareTo(Object o) {
		            return time-((Renwu)o).time;
		        }
		    }	
	}

