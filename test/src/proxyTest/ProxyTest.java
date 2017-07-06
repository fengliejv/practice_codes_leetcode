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
		 * 执行这一句话的时候会通过反射机制动态的生成一个代理类，
		 * 该类实现了IComputer接口，并且重写了接口里面的方法
		 * （也就是说代理类与被代理类有相同的接口），
		 * 在该代理类里面有一个InvocationHandler类型的成员变量，
		 * 也就是调用处理程序，通过调用处理程序来给被代理类增强功能。
		 * 创建好代理类后就调用类加载器将该类加载到类存，
		 * 然后再通过反射创建一个该代理类的实例对象。
		 * 
		 * */
		computer.execute();
	}
}
