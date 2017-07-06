package ali;
/*一个对于一个单行的逆波兰表达式，由如下元素构成：
数字：十进制数字字符构成的正整数，比如 223
运算符：支持三种运算符^+和*，分别代表自增，加法和乘法
分隔符：一个或者多个空格
例如下面的字符串就是个逆波兰表达式
2 3  4 * ^ 5 +
逆波兰表达式在一个基于栈的虚拟机中求解，虚拟机的栈能保存16个整数，
虚拟机从左向右扫描表达式，遇到整数就压栈，遇到表达式则从栈顶弹出若干个整数进行计算，
计算结果重新压回栈中。其中运算符^从栈顶弹出一个整数，增加1之后压栈；
运算符+和*从栈顶弹出两个整数，分别做相加和相乘运算后压栈。
如果遇到运算符的时候，栈内没有足够的整数，称为下溢出，返回-1；
把整数压栈的时候，如果栈没有足够的空间，称为上溢出，返回-2；
如果整个计算过程中没有发生溢出，在整个表达式求解完成后，返回栈顶的整数。



输入:
输入数据是一个单行的合法逆波兰表达式（可能存在上溢出或者下溢出，但是不会出现语法不合法的情形，
比如空字符串或者存在不支持的运算符）
输出:
一个整数
输入范例:
1 1 + 2 ^ *
输出范例:
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
