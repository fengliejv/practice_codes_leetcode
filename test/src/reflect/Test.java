package reflect;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class Test implements Serializable {

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, ClassNotFoundException {
		/*----------------------通过一个对象获得完整的包名和类名-------	
			Test test = new Test();
			//get class name 
			System.out.println(test.getClass().getName());
			//get pakage name 
			System.out.println(test.getClass().getPackage());
			System.out.println(test.getClass().hashCode());
			System.out.println(test.getClass().getCanonicalName());
		 */// -------------------------------------------------------------
			// 实例化Class类对象
		/*
		 * Class class1 = null; try { class1=Class.forName("reflect.Test"); }
		 * catch (ClassNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } System.out.println(class1.getName());
		 * //------------------------------------------------------------------
		 * //获取一个对象的父类与实现的接口
		 * System.out.println(class1.getSuperclass().getName()); Class inter[] =
		 * class1.getInterfaces(); for(int i=0;i<inter.length;i++){
		 * System.out.println(inter[i].toString()); }
		 */// -------------------------------------------------------------------------------------------
			// 获取某个类中的全部构造函数 - 通过反射机制实例化一个类的对象
		/*
		 * Class<?> class1 = Class.forName("reflect.User"); //
		 * 第一种方法，实例化默认构造方法，调用set赋值 User user = (User) class1.newInstance();
		 * user.setAge(20); user.setName("Rollen"); System.out.println(user); //
		 * 结果 User [age=20, name=Rollen] // 第二种方法 取得全部的构造函数 使用构造函数赋值
		 * Constructor<?> cons[] = class1.getConstructors(); // 查看每个构造方法需要的参数
		 * for (int i = 0; i < cons.length; i++) { Class<?> clazzs[] =
		 * cons[i].getParameterTypes(); System.out.print("cons[" + i + "] (");
		 * for (int j = 0; j < clazzs.length; j++) { if (j == clazzs.length - 1)
		 * System.out.print(clazzs[j].getName()); else
		 * System.out.print(clazzs[j].getName() + ","); }
		 * System.out.println(")"); } // 结果 // cons[0] (java.lang.String) //
		 * cons[1] (int,java.lang.String) // cons[2] () user = (User)
		 * cons[0].newInstance("Rollen"); System.out.println(user); // 结果 User
		 * [age=0, name=Rollen] user = (User) cons[1].newInstance("Rollen",20);
		 * System.out.println(user); // 结果 User [age=20, name=Rollen]
		 */

		Class<?> clazz = Class.forName("reflect.User");
		System.out.println("===============本类属性===============");
		// 取得本类的全部属性
		Field[] field = clazz.getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			// 权限修饰符
			int mo = field[i].getModifiers();
			String priv = Modifier.toString(mo);
			// 属性类型
			Class<?> type = field[i].getType();
			System.out.println(priv + " " + type.getName() + " "
					+ field[i].getName() + ";");
		}

		System.out.println("==========实现的接口或者父类的属性==========");
		// 取得实现的接口或者父类的属性
		Field[] filed1 = clazz.getFields();
		for (int j = 0; j < filed1.length; j++) {
			// 权限修饰符
			int mo = filed1[j].getModifiers();
			String priv = Modifier.toString(mo);
			// 属性类型
			Class<?> type = filed1[j].getType();
			System.out.println(priv + " " + type.getName() + " "
					+ filed1[j].getName() + ";");
		}

	}

}
