package innerclass;

import java.io.Serializable;
import java.util.ArrayList;

public class InnerClass implements Serializable {
	public static void main(String arg[]) {
		// for(int i=0;i<arg.length ;i++){
		// System.out.println(arg[i]);
		// }
		ArrayList b;
		System.out.println("main");
		InnerClass a = new InnerClass();
	}

	public InnerClass(){
		System.out.println("haha");
		
	}
	
	{
		System.out.println("blank block");
	}
	static {
		System.out.println("statc block");
	}
	

}
