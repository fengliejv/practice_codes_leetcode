package reflect;

import proxytest2.SharedInterface;

public class User implements SharedInterface{
	private String name;
	private int age;

	public User(){
		super();
		System.out.println("this is user");
	}

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "User [age=" + age + ", name=" + name + "]";
	}

	@Override
	public void put(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int sum(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
}
