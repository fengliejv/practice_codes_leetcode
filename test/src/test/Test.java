package test;

import java.util.Scanner;


public class Test implements CharSequence {
	public static void main(String[] args) {
		System.out.println("请输入字符串");
		Scanner scanner =new Scanner(System.in);
		String str=scanner.next();
		Test s = new Test(str);
		System.out.println("字符串的长度为："+s.length());
		System.out.println("从字符串中查找单个字符:"+s.charAt(0));	
		System.out.println("从字符串中截取子串:"+s.subSequence(1, 3));
		System.out.println("测试toString()方法:"+s.toString());
		System.out.println("将字符串倒序输出:"+s.backWards());
		scanner.close();
	}

	private char[] value;
	
	public Test(String a) {
		this.value=a.toCharArray();
	}
	
	public String backWards(){
		char[] c =new char[value.length] ;
		for(int i=0;i<value.length;i++){
		c[i]=value[value.length-i-1];
		}
		String s=String.valueOf(c);
		return s;	
	}
	
	@Override
	public int length() {
		int i = value.length;
		return i;
	}

	@Override
	public char charAt(int index) {
		
		 if ((index < 0) || (index >= value.length)) {
		 System.out.println("您想找的字符不存在");
		 }
		 return value[index];		
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		if (start < 0) {
            System.out.println("您输入的开始索引序号有误");
        }
        if (end> value.length) {
        	System.out.println("您输入的结束索引序号有误");
        }
        int subLen = end - start;
        if (subLen < 0) {
        	System.out.println("您输入的开始与结束索引序号有误");
        }
        return ((start == 0) && (end == value.length)) ? this
                : new String(value, start, subLen);	
	}

	public String toString() {
		String s=String.valueOf(value);
		return s;
	}
}
