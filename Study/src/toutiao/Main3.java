package toutiao;
import java.util.*;

/**
 * Created by zhang on 17-4-18.
 */
public class Main3 {
    static String stringTemp=   "***    *    ***   ***   * *   ***   ***   ***   ***   ***\n" +
                                "* *    *      *     *   * *   *     *       *   * *   * *\n" +
                                "* *    *    ***   ***   ***   ***   ***     *   ***   ***\n" +
                                "* *    *    *       *     *     *   * *     *   * *     *\n" +
                                "***    *    ***   ***     *   ***   ***     *   ***   ***\n";

    static String signTemp= "                                 \n"+
                            " *          * *     *   ****     \n" +
                            "***   ***    *     *             \n" +
                            " *          * *   *     ****   **\n" +
                            "                               **";

   static String []numbers=new String[10];
   static String []sign=new String[6];

    public static void main(String[] args) {
        String[] splits=stringTemp.split("\\n");

        for (int i=0;i<numbers.length;i++)
            numbers[i]="";
        for (int i=0;i<splits.length;i++){
            for (int j=0;j<splits[i].length();j++){
                if ((j/3)%2==0){
                    numbers[(j/3)/2]+=splits[i].charAt(j);
                }
            }
            for (int j=0;j<numbers.length;j++)
                numbers[j]+="\n";
        }
        for (int i=0;i<sign.length;i++)
            sign[i]="";

        splits=signTemp.split("\n");
        for (int i=0;i<splits.length;i++){
            for (int j=0;j<splits[i].length();j++){
                if ((j/3)%2==0){
                    sign[(j/3)/2]+=splits[i].charAt(j);
                }
            }
            for (int j=0;j<sign.length;j++)
                sign[j]+="\n";
        }

        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();


       String []dig=input.split("[/+*-]");

        List<Double> numberList=new ArrayList<>();
        for (int i=0;i<dig.length;i++)
            numberList.add(Double.valueOf(dig[i]));

        List<Character> signList=new LinkedList<>();

       for (int i=0;i<input.length();i++){
           char c=input.charAt(i);
           switch (c){
               case '+':
               case '-':
               case '*':
               case '/':
                   signList.add(c);
           }
       }
       Iterator<Character> iterator=signList.iterator();

       for (int i=0;iterator.hasNext();i++){
           char c=iterator.next();
           if (c=='*'){
               double temp=numberList.get(i)*numberList.get(i+1);
               numberList.remove(i);
               numberList.set(i,temp);
               iterator.remove();
               i--;
           }else if (c=='/'){
               double temp=numberList.get(i)/numberList.get(i+1);
               numberList.remove(i);
               numberList.set(i,temp);
               iterator.remove();
               i--;
           }
       }


       double temp1=numberList.get(0);
       iterator=signList.iterator();
        for (int i=0;iterator.hasNext();i++){
            char c=iterator.next();
            if (c=='+'){
                temp1=temp1+numberList.get(i+1);
            }else if (c=='-'){
                temp1=temp1-numberList.get(i+1);
            }
        }

        temp1= (int)(temp1*100);
        temp1=temp1/100;

        input+="="+temp1;
        System.out.println( out(input));

    }
    public static String out(String input){
        String [][]numberArray=new String[numbers.length][];
        for (int i=0;i<numberArray.length;i++){
            numberArray[i]=numbers[i].split("\\n");
        }
        String [][]signArray=new String[sign.length][];
        for (int i=0;i<signArray.length;i++){
            signArray[i]=sign[i].split("\\n");
        }


        StringBuilder []builder=new StringBuilder[5];
        for (int i=0;i<builder.length;i++)
            builder[i]=new StringBuilder();

        char []array=input.toCharArray();

        for (int i=0;i<array.length;i++){
            char c=array[i];
            String []temp=null;
            if (c>='0'&&c<='9'){
                temp=numberArray[c-'0'];
            }else {
                int tt=0;
                switch (c){
                    case '+':
                        tt=0;
                        break;
                    case '-':
                        tt=1;
                        break;
                    case '*':
                        tt=2;
                        break;
                    case '/':
                        tt=3;
                        break;
                    case '=':
                        tt=4;
                        break;
                    case '.':
                        tt=5;
                        break;
                }
                temp=signArray[tt];
            }
            for (int j=0;j<builder.length;j++){
                builder[j].append(temp[j]);
            }
            if (i<array.length-1){
                for (int j=0;j<builder.length;j++){
                    builder[j].append("  ");
                }
            }else {
                for (int j=0;j<builder.length;j++){
                    builder[j].append("\n");
                }
            }
        }

        StringBuilder ret=new StringBuilder();
        for (int i=0;i<builder.length;i++){
            ret.append(builder[i]);
        }



        return ret.toString();
    }


}
