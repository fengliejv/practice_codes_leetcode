package test;

public class TryTest {

	public static void main(String[] args) {
		new TryTest();
		// TODO Auto-generated method stub
		System.out.println(TryTest.test());
		;
	}

	static int test() {
		int x = 1;
		try {
			return x;
		} finally {
			++x;
		}
	}
}
