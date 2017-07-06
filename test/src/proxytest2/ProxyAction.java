package proxytest2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyAction implements InvocationHandler {
	private Object object;

	ProxyAction(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("proxy begin");
		// TODO Auto-generated method stub
		Object ret= method.invoke(object, args);
		System.out.println("proxy end");
		return ret;
	}


}
