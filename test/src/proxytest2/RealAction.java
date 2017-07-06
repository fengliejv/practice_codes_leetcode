package proxytest2;

public class RealAction implements SharedInterface {

	@Override
	public void put(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}

	@Override
	public int sum(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

}
