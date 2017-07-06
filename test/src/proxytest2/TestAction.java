package proxytest2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestAction {
	public static void main(String args[]){
		SharedInterface real_action=new RealAction();
		InvocationHandler handler=new ProxyAction(real_action);
		SharedInterface dynamicproxy=(SharedInterface) Proxy.newProxyInstance
				(handler.getClass().getClassLoader(), 
				real_action.getClass().getInterfaces(), 
				handler);
		
		dynamicproxy.put("hello");
		int a = dynamicproxy.sum(3,4);
		System.out.println(a);
	}

}
