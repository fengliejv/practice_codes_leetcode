package ali;
/*һ������һ�����е��沨�����ʽ��������Ԫ�ع��ɣ�
���֣�ʮ���������ַ����ɵ������������� 223
�������֧�����������^+��*���ֱ�����������ӷ��ͳ˷�
�ָ�����һ�����߶���ո�
����������ַ������Ǹ��沨�����ʽ
2 3  4 * ^ 5 +
�沨�����ʽ��һ������ջ�����������⣬�������ջ�ܱ���16��������
�������������ɨ����ʽ������������ѹջ���������ʽ���ջ���������ɸ��������м��㣬
����������ѹ��ջ�С����������^��ջ������һ������������1֮��ѹջ��
�����+��*��ջ�����������������ֱ�����Ӻ���������ѹջ��
��������������ʱ��ջ��û���㹻����������Ϊ�����������-1��
������ѹջ��ʱ�����ջû���㹻�Ŀռ䣬��Ϊ�����������-2��
����������������û�з�����������������ʽ�����ɺ󣬷���ջ����������



����:
����������һ�����еĺϷ��沨�����ʽ�����ܴ����������������������ǲ�������﷨���Ϸ������Σ�
������ַ������ߴ��ڲ�֧�ֵ��������
���:
һ������
���뷶��:
1 1 + 2 ^ *
�������:
6
 * */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main2 {

    public static void main(String[] args) {

        ArrayList<Integer> inputsarray = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        String lines = input.nextLine();
        if(lines != null && !lines.isEmpty()) {
            int rese = resolve(lines.trim());
            System.out.println(String.valueOf(rese));
        }
    }

    // write your code here
    public static int resolve(String expr) {

        Stack<Integer> stacks=new Stack<>();

        String []special=expr.split(" +");
        for (int i=0;i<special.length;i++){
            int a,b;
            switch (special[i]){
                case "+":
                    if (stacks.size()<2)
                        return -1;
                    a=stacks.pop();
                    b=stacks.pop();
                    stacks.push(a+b);
                    break;
                case "*":
                    if (stacks.size()<2)
                        return -1;
                    a=stacks.pop();
                    b=stacks.pop();
                    stacks.push(a*b);
                    break;
                case "^":
                    if (stacks.size()<1)
                        return -1;
                    a=stacks.pop();
                    stacks.push(a+1);
                    break;

                default:
                    stacks.push(Integer.valueOf(special[i]));
                    if (stacks.size()>16)
                        return -2;

                    break;

            }
        }
        return stacks.pop();

    }


}
