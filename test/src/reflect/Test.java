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
		/*----------------------ͨ��һ�������������İ���������-------	
			Test test = new Test();
			//get class name 
			System.out.println(test.getClass().getName());
			//get pakage name 
			System.out.println(test.getClass().getPackage());
			System.out.println(test.getClass().hashCode());
			System.out.println(test.getClass().getCanonicalName());
		 */// -------------------------------------------------------------
			// ʵ����Class�����
		/*
		 * Class class1 = null; try { class1=Class.forName("reflect.Test"); }
		 * catch (ClassNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } System.out.println(class1.getName());
		 * //------------------------------------------------------------------
		 * //��ȡһ������ĸ�����ʵ�ֵĽӿ�
		 * System.out.println(class1.getSuperclass().getName()); Class inter[] =
		 * class1.getInterfaces(); for(int i=0;i<inter.length;i++){
		 * System.out.println(inter[i].toString()); }
		 */// -------------------------------------------------------------------------------------------
			// ��ȡĳ�����е�ȫ�����캯�� - ͨ���������ʵ����һ����Ķ���
		/*
		 * Class<?> class1 = Class.forName("reflect.User"); //
		 * ��һ�ַ�����ʵ����Ĭ�Ϲ��췽��������set��ֵ User user = (User) class1.newInstance();
		 * user.setAge(20); user.setName("Rollen"); System.out.println(user); //
		 * ��� User [age=20, name=Rollen] // �ڶ��ַ��� ȡ��ȫ���Ĺ��캯�� ʹ�ù��캯����ֵ
		 * Constructor<?> cons[] = class1.getConstructors(); // �鿴ÿ�����췽����Ҫ�Ĳ���
		 * for (int i = 0; i < cons.length; i++) { Class<?> clazzs[] =
		 * cons[i].getParameterTypes(); System.out.print("cons[" + i + "] (");
		 * for (int j = 0; j < clazzs.length; j++) { if (j == clazzs.length - 1)
		 * System.out.print(clazzs[j].getName()); else
		 * System.out.print(clazzs[j].getName() + ","); }
		 * System.out.println(")"); } // ��� // cons[0] (java.lang.String) //
		 * cons[1] (int,java.lang.String) // cons[2] () user = (User)
		 * cons[0].newInstance("Rollen"); System.out.println(user); // ��� User
		 * [age=0, name=Rollen] user = (User) cons[1].newInstance("Rollen",20);
		 * System.out.println(user); // ��� User [age=20, name=Rollen]
		 */

		Class<?> clazz = Class.forName("reflect.User");
		System.out.println("===============��������===============");
		// ȡ�ñ����ȫ������
		Field[] field = clazz.getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			// Ȩ�����η�
			int mo = field[i].getModifiers();
			String priv = Modifier.toString(mo);
			// ��������
			Class<?> type = field[i].getType();
			System.out.println(priv + " " + type.getName() + " "
					+ field[i].getName() + ";");
		}

		System.out.println("==========ʵ�ֵĽӿڻ��߸��������==========");
		// ȡ��ʵ�ֵĽӿڻ��߸��������
		Field[] filed1 = clazz.getFields();
		for (int j = 0; j < filed1.length; j++) {
			// Ȩ�����η�
			int mo = filed1[j].getModifiers();
			String priv = Modifier.toString(mo);
			// ��������
			Class<?> type = filed1[j].getType();
			System.out.println(priv + " " + type.getName() + " "
					+ filed1[j].getName() + ";");
		}

	}

}
