package huaweibishi;
import java.util.Scanner;
import java.util.Scanner;
//骰子的上下左右前后顺时逆时旋转
public class T2 {
    public static void main(String[] args) {
        Commond c=new Commond();
        Scanner scanner=new Scanner(System.in);
        String input=null;
        if (scanner.hasNextLine())
            input=scanner.next();
        if (input.length()>50){
        	System.out.print("ERROW");
        }
        char in[]=input.toCharArray();
        for (char s:in)
            switch (s){
                case 'A':
                    c.A();
                    break;
                case 'B' :
                    c.B();
                    break;                    
                case 'C':
                    c.C();
                    break;
                case 'L':
                    c.L();
                    break;
                case 'R':
                    c.R();
                    break;
                case 'F':
                    c.F();
                    break;      
            }
        System.out.println(c);

    }
    static class Commond{
        int left=1;
        int right=2;
        int head=3;
        int behind=4;
        int up=5;
        int down=6;
        void L(){
            int temp=left;
            left=up;
            up=right;
            right=down;
            down=temp;
        }
        void R(){
            int temp=right;
            right=up;up=left;left=down;
            down=temp;

        }
        void F(){
            int temp=head;
            head=up;up=behind;behind=down;
            down=temp;
        }
        void B(){
            int temp=behind;
            behind=up;up=head;head=down;
            down=temp;
        }
        void A(){
            int temp=head;
            head=left;left=behind;behind=right;
            right=temp;
        }
        void C(){
            int temp=head;
            head=right;right=behind;behind=left;
            left=temp;
        }

        @Override
        public String toString() {
            return ""+left+right+head+behind+up+down;
        }
    }
}
