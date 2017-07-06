package Huawei;

public class Test extends Testfather {
	
		public static void main (String[] args)
	    {
	        new  Test(). run();
	    }
	    private final void run()
	    {
	        System. out. println ("Car");
	    }
	
}
class Testfather{
	
	private final void run()
    {
        System. out. println("Vehicle");
    }
	
}