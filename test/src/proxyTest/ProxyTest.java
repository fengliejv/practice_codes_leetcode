package proxyTest;

import java.lang.reflect.Proxy;

public class ProxyTest {
	public static void main(String[] args) {
		Laptop laptop = new Laptop();
		TimeHander hander = new TimeHander(laptop);
		IComputer computer = (IComputer) Proxy.newProxyInstance(
				laptop.getClass().getClassLoader(),
				laptop.getClass().getInterfaces(),
				hander);
		
		/**
		 * ִ����һ�仰��ʱ���ͨ��������ƶ�̬������һ�������࣬
		 * ����ʵ����IComputer�ӿڣ�������д�˽ӿ�����ķ���
		 * ��Ҳ����˵�������뱻����������ͬ�Ľӿڣ���
		 * �ڸô�����������һ��InvocationHandler���͵ĳ�Ա������
		 * Ҳ���ǵ��ô������ͨ�����ô��������������������ǿ���ܡ�
		 * �����ô������͵������������������ص���棬
		 * Ȼ����ͨ�����䴴��һ���ô������ʵ������
		 * 
		 * */
		computer.execute();
	}
}
