package Huawei;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class ouchuan {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        char array[]=s.toCharArray();
        int count=0;
        HashMap<Character,Integer> integerHashMap=new HashMap<>();
        for (int i=0;i<array.length;i++){
            if (integerHashMap.get(array[i])==null){
                integerHashMap.put(array[i],1);
            }else {
                integerHashMap.put(array[i],integerHashMap.get(array[i])+1);
            }
        }
        HashSet<Character> set=new HashSet<>();

        for (Map.Entry<Character,Integer> entry:integerHashMap.entrySet()){
            if (entry.getValue()==1)
                set.add(entry.getKey());
        }

        for (int i=0;i<array.length;i++){
            if (set.contains(array[i]))
                continue;

            for (int j=i+1;j<array.length;j++){

                if (set.contains(array[j]))
                    break;

                if (((j-i)&1)==1){
                    char a=0;
                    for (int index=i;index<=j;index++)
                        a=(char)(a^array[index]);
                    if (a==0)
                        count++;
                }
            }
        }
        System.out.println(count);
    }
}