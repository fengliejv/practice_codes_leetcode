package test;

public class PrivateTest {
	private boolean a=true;

	public boolean isA() {
		return a;
	}

	public void setA(boolean a) {
		this.a = a;
	}
	
	public static void main(String arg[]){
		PrivateTest aPrivateTest= new PrivateTest();
		PrivateTest bPrivateTest= new PrivateTest();
		aPrivateTest.setA(false);
		System.out.println(bPrivateTest.isA());
		System.out.print(aPrivateTest.isA());
	}
	
}
